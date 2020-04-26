package com.xm.controller.frontdesk;

import com.xm.pojo.Product;
import com.xm.pojo.Products;
import com.xm.pojo.User;
import com.xm.pojo.shopping;
import com.xm.service.ProductService;
import com.xm.service.ProductsService;
import com.xm.service.UserService;
import com.xm.service.shoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/22
 */
@RestController
public class PartticularController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private UserService userService;
    @Autowired
    private shoppingService shoppingService;

    @RequestMapping("/spcx")
    public Products list(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", id);
        List<Products> list = (List<Products>) productsService.listByMap(map);
        return list.get(0);
    }

    @RequestMapping("/add")
    public int add(String pid, String money, String text, String phone) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
        Map map2 = new HashMap();
        map2.put("uid", user.get(0).getUser_id());
        map2.put("pid", Integer.parseInt(pid));
        List<shopping> shoppings = (List<shopping>) shoppingService.listByMap(map2);
        int index = -1;
        if (shoppings != null) {  //修改件数，格式照旧
            for (int i = 0; i < shoppings.size(); i++) {
                if (shoppings.get(0).getText() == text) {
                    index = i;
                }
            }
        }
        if (index > -1) {
            shoppingService.update(shoppings.get(index));
            return 1;
        } else {
            shopping shopping = new shopping();
            shopping.setPid(Integer.parseInt(pid));
            String[] jg = money.split("元");
            shopping.setMoney(Double.parseDouble(jg[0]));
            shopping.setText(text);
            shopping.setCount(1);
            shopping.setUid(user.get(0).getUser_id());
            boolean zj = shoppingService.save(shopping);
            if (zj) {
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("/show")
    public List<shopping> add(String phone) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
        Map map2 = new HashMap();
        map2.put("uid", user.get(0).getUser_id());
        List<shopping> shoppings = (List<shopping>) shoppingService.listByMap(map2);
        return shoppings;
    }


}

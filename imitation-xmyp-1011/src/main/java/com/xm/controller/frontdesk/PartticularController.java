package com.xm.controller.frontdesk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.pojo.*;
import com.xm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private shoppingService shoppingService;
    @Autowired
    private OrderService orderServicel;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/spcx")
    public Products list(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", id);
        List<Products> list = (List<Products>) productsService.listByMap(map);
        return list.get(0);
    }

    @RequestMapping("/shows")
    public List<Products> lists() {
        List<Products> list = (List<Products>) productsService.list();
        return list;
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
                if (shoppings.get(i).getText().equals(text.trim())) {
                    System.out.println("----------------------------------------------------" + i);
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
            shopping.setText(text.trim());
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
    public List<Map<String, Object>> add(String phone) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
       /* Map map2 = new HashMap();
        map2.put("uid", user.get(0).getUser_id());
        List<shopping> shoppings = (List<shopping>) shoppingService.listByMap(map2);*/
        List<Map<String, Object>> orders = shoppingService.mapList(user.get(0).getUser_id());
        return orders;
    }

    @RequestMapping("/updata")
    public int updata(String phone, String sid, String count) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
        Map map2 = new HashMap();
        map2.put("uid", user.get(0).getUser_id());
        List<shopping> shoppings = (List<shopping>) shoppingService.listByMap(map2);
        for (int i = 0; i < shoppings.size(); i++) {
            if (shoppings.get(i).getSid() == Integer.parseInt(sid)) {
                shoppings.get(i).setCount(Integer.parseInt(count));
                shoppingService.updatecount(shoppings.get(i));
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("/adddd")
    public int adddd(@RequestParam(value = "sid[]") String[] sid, String phone, String dz, String sum) {
        String ddid = getRandomFileName();
        Order o = new Order();
        o.setOrder_number(ddid);
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
        o.setUser_id(user.get(0).getUser_id());
        o.setOrder_status(1);
        o.setCreate_time(new Date());
        o.setOrder_amount(Double.parseDouble(sum));
        o.setAddress(dz);
        orderServicel.add(o);
        map.remove("login_name");
        Order orders = orderServicel.select(ddid);

        for (int i = 0; i < sid.length; i++) {

            Map map1 = new HashMap();
            map1.put("sid", sid[i]);
            List<shopping> list = (List<shopping>) shoppingService.listByMap(map);
            System.out.println("--------------------------------------------");
            OrderDetail ooid = new OrderDetail();
            ooid.setBuy_number(list.get(0).getCount());
            ooid.setOrder_id(orders.getOrder_id());
            ooid.setProduct_id(list.get(0).getPid());
            ooid.setLists(list.get(0).getText());
            ooid.setProduct_amount((list.get(0).getCount()) * (list.get(0).getMoney()));
            orderDetailService.save(ooid);              //添加商品的记录
            System.out.println("++++++++++++++++++++++++++++++++");
            QueryWrapper<shopping> wrapper = new QueryWrapper<>();
            wrapper.eq("sid", sid[i]);
            shoppingService.remove(wrapper);   //删除购物车里面的记录
            //库存没做判断
        }
        return 0;
    }

    @RequestMapping("/del")
    public int delete(int oid) {
        QueryWrapper<OrderDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("order_product_id", oid);
        List<OrderDetail> listid = orderDetailService.list(wrapper);
        QueryWrapper<OrderDetail> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id", listid.get(0).getOrder_id());
        List<OrderDetail> listall = orderDetailService.list(wrapper1);

        if (listall.size() == 1) {
            orderDetailService.remove(wrapper);
            orderServicel.delete(listid.get(0).getOrder_id());
        } else {
            orderDetailService.remove(wrapper);
        }
        return 0;
    }

    @RequestMapping("/delgw")
    public int deletegw(int sid) {
        QueryWrapper<shopping> wrapper = new QueryWrapper<>();
        wrapper.eq("sid", sid);
        shoppingService.remove(wrapper);
        return 0;
    }

    @RequestMapping("/order")
    public List<Order> list(String phone) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);

        List<Order> orders = orderServicel.listall(user.get(0).getUser_id());

        return orders;
    }

    @RequestMapping("/OrderDetail")
    public List<Map<String, Object>> listall(String phone) {
        Map map = new HashMap();
        map.put("login_name", phone);
        List<User> user = (List<User>) userService.listByMap(map);
        List<Map<String, Object>> orders = orderDetailService.mapList(user.get(0).getUser_id());
        return orders;
    }

    public String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return str + rannum;// 当前时间
    }


}

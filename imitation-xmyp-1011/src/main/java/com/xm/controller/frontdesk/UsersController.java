package com.xm.controller.frontdesk;

import com.xm.pojo.User;
import com.xm.pojo.verificationcode;
import com.xm.service.UserService;
import com.xm.service.verificationcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@RestController
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private verificationcodeService verificationCodeMapper;

    @RequestMapping("/yz")
    public String yzm(verificationcode verificationcode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", verificationcode.getPhone());
        map.put("code", verificationcode.getCode());
        List<verificationcode> list = (List<verificationcode>) verificationCodeMapper.listByMap(map);
        if (list.size() != 0) {
            return "{\"zj\":" + list.get(0).getPhone() + "}";
        }
        return "{\"zj\":\"false\"}";
    }

    @PostMapping("/zc")
    public String zc(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        user.setStatus(1);
        /* String timeStr1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));*/
        user.setRegeist_time(new Date());
        user.setTelephone(user.getTelephone());
        user.setLogin_name(user.getTelephone());
        boolean i = userService.save(user);
        if (i == true) {
            return "true";
        }
        return "false";
    }

    @Autowired
    private HttpServletRequest request;

    private List<String> userSession;

    @PostMapping("/dl")
    public String dl(String username, String password, HttpSession session) {
        User user = new User();
        user.setLogin_password(password);
        session.setAttribute("user", username);

        Map<String, Object> map = new HashMap<String, Object>();
        /*if (username.length() < 11) {
            map.put("user_id", username);
        }*/
        map.put("login_name", username);
        map.put("login_password", password);
        List<User> users = (List<User>) userService.listByMap(map);
        if (users.size() != 0) {
            userSession = (List<String>) request.getServletContext().getAttribute("vsers");
            if (userSession.contains(session.getId())) {
                return "{\"zj\":\"用户已在线\"}";
            } else {
                userSession.add(session.getId());
                return "{\"zj\":\"true\"}";
            }
        }
        return "{\"zj\":\"false\"}";
    }

    @PostMapping("/zx")
    public void dl(String username, HttpSession session) {
        List<String> users = (List<String>) request.getServletContext().getAttribute("vsers");
        if (users.contains(session.getId())) {
            users.remove(session.getId());
        }
        System.out.println("-------------------------------------------注销成功");
    }

}

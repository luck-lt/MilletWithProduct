package com.cssl.client;

import com.xm.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "imitation-xmyp")
//@FeignClient(name = "gateway-zuul")//通过网关访问
public interface UsersClient {

    @PostMapping("/login")
    public int Login(User user);



}

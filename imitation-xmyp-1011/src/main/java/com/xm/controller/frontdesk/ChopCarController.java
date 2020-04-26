package com.xm.controller.frontdesk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChopCarController {

    @GetMapping("/AddChopCar")
    public void AddChopCar() {
        System.out.println("你好");
    }
}

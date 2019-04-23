package com.qhit.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
@RestController
public class HelloWorld {

    @RequestMapping(value = "/hello")
    String hello(){
        return "HelloWorld";
    }

}

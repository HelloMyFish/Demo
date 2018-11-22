package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @Author gyf
 * @Date 2018/11/22 14:07
 */
@RestController
public class TestController {
    @RequestMapping("test")
    public String test(){
        return "hello";
    }
}

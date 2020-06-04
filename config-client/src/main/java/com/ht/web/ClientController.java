package com.ht.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/4/14.
 */
@RestController
public class ClientController {
    @Value("${username}")
    String username;
    @Value("${pwd}")
    String pwd;
    @Value("${driver}")
    String driver;
    @Value("${url}")
    String url;

    @RequestMapping("/client")
    public String client(){
       return username+" "+pwd+" "+driver+" "+url;
    }
}

package com.eshaul.cloud.libs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by eshaul on 10/16/17.
 */
@Controller
@EnableAutoConfiguration
public class LibController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello";
    }
}
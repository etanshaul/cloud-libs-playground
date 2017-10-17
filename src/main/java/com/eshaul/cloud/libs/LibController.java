package com.eshaul.cloud.libs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by eshaul on 10/16/17.
 */
@Controller
@EnableAutoConfiguration
public class LibController {

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("message", "hw!!!");
        return "index";
    }
}
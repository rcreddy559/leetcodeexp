package com.leetcodeexp.home;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
class LeetCodeExpHome {

    @GetMapping
    String home() {
        return "home";
    }

}


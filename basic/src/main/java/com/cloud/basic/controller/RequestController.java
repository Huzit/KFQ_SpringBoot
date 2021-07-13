package com.cloud.basic.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.cloud.basic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
    @GetMapping("req/http")
    public String http(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pageNum = request.getParameter("pageNum");
        return name + ", " + pageNum;
    }

    @GetMapping("req/param1")
    public String param1(
            @RequestParam("key1") String key1,
            @RequestParam("key2") String key2) {
        return key1 + ", " + key2;
    }

    @GetMapping("/req/param2")
    public String param2(
            @RequestParam Map<String, Object> map, Model model) {
        model.addAllAttributes(map);
        return "param2";
    }

    @GetMapping("/signUp")
    public String signUp(@ModelAttribute User user) {
        System.out.println("sdkljflsdk");
        return "signUp";
    }

    @GetMapping("linkUrl")
    public String linkUrl(Model model, @RequestParam(defaultValue="1") int page, @RequestParam Map<String, Object> map) {
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;
        model.addAttribute("curPage", map.get("page"));
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);
        return "linkUrl";
    }
}
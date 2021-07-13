package com.cloud.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloud.basic.mapper.DemoMapper;
import com.cloud.basic.model.Demo;

@RestController
public class MyBatisController {
    @Autowired
    DemoMapper demoMapper;

    @GetMapping("/demo")
    public List<Demo> demo() {
        List<Demo> list = demoMapper.getDemoList();
        return list;
    }

    @GetMapping("/demo2")
    public List<Map<String, Object>> demo2(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> list = demoMapper.getDemoList2(map);
        return list;
    }
}
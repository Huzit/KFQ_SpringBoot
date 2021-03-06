package com.cloud.basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.cloud.basic.model.Demo;

@Mapper
public interface DemoMapper {
    public List<Demo> getDemoList();
    public List<Map<String, Object>> getDemoList2(Map<String, Object> map);
}
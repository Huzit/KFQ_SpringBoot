package com.cloud.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class RestTemplateController {
    @GetMapping("/getString")
    public List< Map<String, Object> > getString() {
        RestTemplate rt = new RestTemplate();
        List< Map<String, Object> > result = rt.getForObject("http://ggoreb.com/http/json3.jsp", List.class);

        for(Map<String, Object> res : result){
            String name = (String)res.getOrDefault("name", "");
            log.error(name);
        }

        return result;
    }

    @GetMapping("/getData")
    public List< Map<String, Object> > getData(){
        RestTemplate rest = new RestTemplate();
        List< Map<String, Object> > dino = rest.getForObject("http://ggoreb.com/dinosaur/info.jsp", List.class);

        for(Map<String, Object> d : dino){
            List< Map<String, Object> > dinosaurs = (List<Map<String, Object>>) d.get("dinosaurs");

            for (Map<String, Object> dinosaur : dinosaurs) {
                String title = (String)dinosaur.get("title");
                System.out.println(title);
            }
        }

        return dino;
    }

    @GetMapping("/getKakao")
    public ResponseEntity<Map> getKakao() {
        RestTemplate rt = new RestTemplate();
        RequestEntity requestEntity = null;
        try {
            requestEntity = RequestEntity.get(
                    new URI("https://dapi.kakao.com/v2/local/search/address.json?query=" +
                            URLEncoder.encode("부산 연제구 연산동 1000", "utf-8")))
                    .header("Authorization", "KakaoAK f33c0bdc28cf3a49a87aeb9f5e218e65")
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
        Map<String, Object> result = entity.getBody();
        List<Map<String, Object>> documents = (List<Map<String, Object>>) result.get("documents");

        for(Map<String, Object> document : documents){
            Map<String, Object> doc = document;
            Map<String, Object> address = (Map<String, Object>) document.get("address");

            String 위도 = (String) address.get("y");
            String 경도 = (String) address.get("x");

            System.out.println(위도 +','+ 경도);
        }
        return entity;
    }
}

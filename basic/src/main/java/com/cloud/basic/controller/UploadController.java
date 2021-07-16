package com.cloud.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Controller
public class UploadController {
    @GetMapping("/upload1")
    public String upload1() {
        // 1. static
        // 2. NAS
        //파일패스경로
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(path);
        return "upload1";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public String upload1Post(MultipartHttpServletRequest mRequest, @RequestParam("title") String title) {
        System.out.println("title: "+title);
        //파일입력이 여러개일 시 폼의 필드네임을 가져옴
        Iterator<String> iter = mRequest.getFileNames();
        //iterator로 처리
        while(iter.hasNext()){
            String name = iter.next();
            //파일을 2개 넣을 시
            List<MultipartFile> mFile = mRequest.getFiles(name);

            for(MultipartFile f : mFile){
                //파일명 작성
                Long time = System.currentTimeMillis();
                String fName = f.getOriginalFilename();
                //TODO String -> substring, replace, indexOf, split
                String prefix = fName.substring(0, fName.indexOf('.'));
                String subFix = fName.substring(fName.indexOf('.'));
                fName = prefix+'_'+time+subFix;
                
                try{
                    //절대경로
                    String aPath = new File("").getAbsolutePath();
                    //실제 파일을 저장하는 함수
                    //f.transferTo(new File(aPath+"/static/"+fName));
                    f.transferTo(new File("D:/workBoot/basic"+fName));
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(fName);
            }
        }
//        String result = "";
//        MultipartFile mFile = mRequest.getFile("file");
//        String oName = mFile.getOriginalFilename();
//        result += oName + "\n";
        return "result";
    }
}
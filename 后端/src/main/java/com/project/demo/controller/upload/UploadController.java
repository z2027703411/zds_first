package com.project.demo.controller.upload;

import com.project.demo.util.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


//文件上传服务器控制器
@RestController
public class UploadController {
    @Autowired
    UploadService uploadService;


    @RequestMapping("/upload")
    public Map<String,Object> uploadImg(@RequestParam("file") MultipartFile multipartFile, String dir){
        if(multipartFile.isEmpty()){
            return null;
        }
        if(dir.equals(null)){
            dir="wushuzhi";
        }
        //1.获取用户指定的文件夹
        //String dir = request.getParameter("dir");
        return uploadService.uploadImg(multipartFile,dir);
    }
}

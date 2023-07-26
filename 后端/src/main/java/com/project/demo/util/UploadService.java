package com.project.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//文件上传服务器工具类
@Service
public class UploadService {
    @Value("${domain.url}")
    private String domain;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    public Map<String,Object> uploadImg(MultipartFile multipartFile,String dir){
        System.out.println("什么情况："+domain);
        try {
            //3.指定文件上传以后的目录(这样子是改变图片的名字再存到目录中去)
            //multipartFile.getOriginalFilename()：获取当前图片的名字
            String realFileName=multipartFile.getOriginalFilename();//旧文件名
            String imSuffix = realFileName.substring(realFileName.lastIndexOf("."));//文件后缀
            String newFileName= UUID.randomUUID().toString()+imSuffix;//新的文件名

            //4.日期目录
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
            String datapath=dateFormat.format(new Date());
            //5.指定文件上传的目录
//            String servrepath="D://一个没卵用的测试文件/fwq/";
            String servrepath=uploadFolder;
            File targetFile= new File(servrepath+dir,datapath);
            //如果文件不存在就创键一个
            if(!targetFile.exists())targetFile.mkdirs();

            //6.指定文件上传以后的服务器的完整文件名
            File targetFileName=new File(targetFile,newFileName);
            //7,文件上传到指定的目录
            multipartFile.transferTo(targetFileName);

            String filename=domain+dir+"/"+datapath+"/"+newFileName;

            Map<String,Object>map=new HashMap<>();
            map.put("url",filename);//完整路径
            map.put("size",multipartFile.getSize());//文件大小
            map.put("fileName",newFileName);//文件名
            map.put("ext",imSuffix);//文件后缀
            map.put("indirectUrl","uploadimg/"+"/"+dir+"/"+datapath+"/"+newFileName);//间接地址
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

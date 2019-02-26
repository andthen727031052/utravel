package com.utravel.controller;

import com.utravel.common.JsonBean;
import com.utravel.service.ImgService;
import com.utravel.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping(value = "/addImg.do", method = {RequestMethod.POST})
    public Object headImg(@RequestParam(value = "file",required =false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
       JsonBean bean = null;
        //String prefix="";
        String dateStr="";
       // String src = "";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                //String originalName = file.getOriginalFilename();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
               // prefix=originalName.substring(originalName.lastIndexOf(".")+1);
               dateStr = sdf.format(new Date());
                String filepath = /*request.getServletContext().getRealPath("/static")*/"D:\\upload\\ut/";
                filepath = filepath.replace("\\", "/");
                File temFile=new File(filepath);
                //打印查看上传路径
               // System.out.println(filepath);
                /*if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }*/
                if(!temFile.exists()){
                    temFile.mkdirs();
                }
               /* for(MultipartFile file:files){
                    file.transferTo(new File(filepath+dateStr+file.getOriginalFilename()));
                    src+=dateStr+file.getOriginalFilename()+";";
                }*/
               file.transferTo(new File(filepath+dateStr+file.getOriginalFilename()));
            }
        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        map.put("data",map2);
        map2.put("src",dateStr+file.getOriginalFilename());

        //bean = JsonUtils.createJsonBean(1,map);
        return map;
    }



}

package com.chentuo.springboot.controller.org.web.load.upload;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author 孟翔飞
 * @date 2019/4/3
 */
@RestController
@RequestMapping("/org/web/load/upload/upload")
public class UploadController {

    @RequestMapping("uploda.json")
    public String uploadImg(@RequestParam("file") MultipartFile file){
        String prefix = UUID.randomUUID().toString();
        String dfilename = prefix + file.getOriginalFilename();
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            File dfile = new File(path + "/static/upload/" + dfilename);
            file.transferTo(dfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dfilename ;
    }
}

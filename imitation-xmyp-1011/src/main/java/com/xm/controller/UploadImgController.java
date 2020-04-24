package com.xm.controller;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 上传图片类
 * @create 2019- 07- 11- 23:19
 */
@Controller
public class UploadImgController {
    //    上传图片
    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> fileupload(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
            String originalFilename = file.getOriginalFilename();
            //扩展名
            String extendName = originalFilename.substring(originalFilename.indexOf("."));
            String newfilename = "xmyp/img/index/" + UUID.randomUUID().toString() + extendName;
            String filepath = "D:/Y2/毕业项目/MilletWithProduct/imitation-xmyp-1011/targetclasses/static/X-admin/";
            String filepath2 = "D:/Y2/毕业项目/MilletWithProduct/imitation-xmyp-1011/target/classes/static/X-admin/";

            File uploadfile = new File(filepath + newfilename);
            File uploadfile2 = new File(filepath + newfilename);
            file.transferTo(uploadfile);
            file.transferTo(uploadfile2);
            map.put("data", newfilename);
            map.put("code", 0);
        }
        return map;
    }
}

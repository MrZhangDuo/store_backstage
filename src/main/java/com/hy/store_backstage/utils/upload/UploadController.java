package com.hy.store_backstage.utils.upload;

import com.hy.store_backstage.utils.uploadimage.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author licheng
 * @date 2020/6/11 21:42
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadImage")
    public UploadImage uploadImage(MultipartFile file){
        /*
        * 返回的上传图片地址
        * */
        String url = uploadService.uploadImage(file);
        if(!StringUtils.isEmpty(url)){
            return new UploadImage(200,"上传成功",url);
        }else {
            return new UploadImage(400,"上传失败",null);
        }
    }
}

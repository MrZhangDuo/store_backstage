package com.hy.store_backstage.commodity.controller;

import com.hy.store_backstage.commodity.entity.ColorEntity;
import com.hy.store_backstage.commodity.entity.SizeEntity;
import com.hy.store_backstage.commodity.service.impl.SizeAndColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/SizeAndColor")
public class SizeAndColorController {
    @Autowired
    private SizeAndColorServiceImpl sizeAndColorService;

    /*查询所有的颜色*/
    @RequestMapping("/selectAllColor.do")
    @ResponseBody
    public List<ColorEntity> selectAllColor(){
        return sizeAndColorService.selectAllColor();
    };
    /*查询所有的尺寸大小*/
    @RequestMapping("/selectAllSize.do")
    @ResponseBody
    public List<SizeEntity> selectAllSize(){
        return sizeAndColorService.selectAllSize();
    };

    /*添加尺寸*/
    @RequestMapping("/addSize.do")
    @ResponseBody
    public void addSize(@RequestBody SizeEntity sizeEntity){
        sizeAndColorService.addSize(sizeEntity);
    }

   /*添加颜色*/
   @RequestMapping("/addColor.do")
   @ResponseBody
   public void addColor(@RequestBody ColorEntity colorEntity){
       sizeAndColorService.addColor(colorEntity);
   }

    /*删除选中的多选框 尺寸*/
//    @RequestMapping("/delSize.do")
//    @ResponseBody
//    public void delSize(String sizeName){
//        sizeAndColorService.delSize(sizeName);
//    };


}

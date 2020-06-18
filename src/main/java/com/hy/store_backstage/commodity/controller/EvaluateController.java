package com.hy.store_backstage.commodity.controller;

import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;
import com.hy.store_backstage.commodity.service.impl.EvaluateFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/Evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateFService evaluateFService;

    /*查询商品评价farther的信息*/
    @RequestMapping("/selectEvaInfo.do")
    @ResponseBody
    public List<EvaluateFEntity> selectEvaInfo(){
        return  evaluateFService.list();
    };

    /*根据id查看具体某一条的信息*/
    @RequestMapping("/SelectById.do")
    @ResponseBody
    public EvaluateFEntity SelectById(Integer evaId){
        return  evaluateFService.getById(evaId);
    }

    /*根据父评论下的所有子评论*/
    @RequestMapping("/selectSonInfo.do")
    @ResponseBody
    public List<EvaluateSEntity> selectSonInfo(Integer evaId){
        List<EvaluateSEntity> aa= evaluateFService.selectSonInfo(evaId);
        for (int i = 0; i < aa.size(); i++) {
            System.out.println(aa.get(i).getSonContent()+aa.get(i).getSonPerson()+aa.get(i).getSonTime());
        }
//        return evaluateFService.selectSonInfo(evaId);
        return aa;
    };

    /*添加管理员评论的信息*/
    @RequestMapping("/addMassageInfo.do")
    @ResponseBody
    public void addMassageInfo(EvaluateSEntity evaluateSEntity){
        evaluateSEntity.setSonTime(LocalDateTime.now());
        evaluateSEntity.setSonIsManage(1);
        evaluateFService.addMassageInfo(evaluateSEntity);
    };

    /*根据商品名称或用户昵称模糊查询父评价*/
    @RequestMapping("/selectPingjiaLike.do")
    @ResponseBody
    public List<EvaluateFEntity> selectPingjiaLike(EvaluateFEntity evaluateFEntity){
        return evaluateFService.selectPingjiaLike(evaluateFEntity);
    };
}

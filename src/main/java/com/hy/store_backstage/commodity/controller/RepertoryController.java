package com.hy.store_backstage.commodity.controller;

import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import com.hy.store_backstage.commodity.entity.RepertoryBean;
import com.hy.store_backstage.commodity.service.impl.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestMapping("/Repertory")
@CrossOrigin
@Controller
public class RepertoryController {

    @Autowired
    private RepertoryService repertoryService;

    /*根据商品id查询库存的所有信息*/
    @RequestMapping("/selectGoTo.do")
    @ResponseBody
    public List<RepertoryBean> selectGoTo(Long comId){
        return repertoryService.selectGoTo(comId);
    };

    /*修改库存信息*/
    @RequestMapping("/updatGoTo.do")
    @ResponseBody
    public void updatGoTo(RepertoryBean repertoryBean){
        repertoryService.updatGoTo(repertoryBean);
    };

    /*查询商品入库的信息*/
    @RequestMapping("/selectGo.do")
    @ResponseBody
    public List<GoOutRepertoryBean> selectGo(){
        return repertoryService.selectGo();
    };

    /*查询商品出库的信息*/
    @RequestMapping("/selectOut.do")
    @ResponseBody
    public List<GoOutRepertoryBean> selectOut(){
        return repertoryService.selectOut();
    };

    /*入库信息模糊查询*/
    @RequestMapping("/selectLikeGo.do")
    @ResponseBody
    public List<GoOutRepertoryBean> selectLikeGo(GoOutRepertoryBean goOutRepertoryBean,String gooutTimes){
        if(!StringUtils.isEmpty(gooutTimes)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            goOutRepertoryBean.setGooutTime(LocalDate.parse(gooutTimes,dateTimeFormatter));
        }
        return repertoryService.selectLikeGo(goOutRepertoryBean);
    };

    /*出库信息模糊查询*/
    @RequestMapping("/selectLikeOut.do")
    @ResponseBody
    public List<GoOutRepertoryBean> selectLikeOut(GoOutRepertoryBean goOutRepertoryBean,String gooutTimes){
        if(!StringUtils.isEmpty(gooutTimes)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            goOutRepertoryBean.setGooutTime(LocalDate.parse(gooutTimes,dateTimeFormatter));
        }
        return repertoryService.selectLikeOut(goOutRepertoryBean);
    };
}

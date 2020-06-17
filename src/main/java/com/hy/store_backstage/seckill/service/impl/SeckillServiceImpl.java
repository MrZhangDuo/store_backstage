package com.hy.store_backstage.seckill.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckill.mapper.SeckillMapper;
import com.hy.store_backstage.seckill.service.ISeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements ISeckillService {
    @Autowired
    SeckillMapper seckillMapper;

    @Override
    public IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize,String startTimes,String endTimes) {
        if(!StringUtils.isEmpty(startTimes) && !StringUtils.isEmpty(endTimes)){
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            seckillBo.setStartTime(LocalDateTime.parse(startTimes.replace("T"," "),dt));
            seckillBo.setEndTime(LocalDateTime.parse(endTimes.replace("T"," "),dt));
        }
        return this.seckillMapper.queryAllSeckill(new Page(currentPage,pageSize),seckillBo);
    }

    @Override
    public Seckill querySeckillById(Long seckillId) {
        return seckillMapper.selectById(seckillId);
    }

    @Override
    public ReturnJson updateSeckillById(Seckill seckill,String startTimes,String endTimes) {
        int returns = seckillMapper.updateById(returnSeckill(seckill,startTimes,endTimes));
        if(returns>0){
            return new ReturnJson(200,"修改成功!!!");
        }else{
            return new ReturnJson(401,"修改失败!!!");
        }
    }

    @Override
    public ReturnJson deleteSeckillById(Long seckillId) {
        int returns = seckillMapper.deleteById(seckillId);
        if(returns>0){
            return new ReturnJson(200,"删除成功!!!");
        }else{
            return new ReturnJson(401,"删除失败!!!");
        }
    }

    @Override
    public ReturnJson addSeckill(Seckill seckill,String startTimes,String endTimes) {
        int returns = seckillMapper.insert(returnSeckill(seckill,startTimes,endTimes));
        if(returns>0){
            return new ReturnJson(200,"添加成功!!!");
        }else{
            return new ReturnJson(401,"添加失败!!!");
        }
    }

    public Seckill returnSeckill(Seckill seckill,String startTimes,String endTimes) {
        if(!StringUtils.isEmpty(startTimes) && !StringUtils.isEmpty(endTimes)){
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            seckill.setStartTime(LocalDateTime.parse(startTimes.replace("T"," "),dt));
            seckill.setEndTime(LocalDateTime.parse(endTimes.replace("T"," "),dt));
        }
        return seckill;
    }
}

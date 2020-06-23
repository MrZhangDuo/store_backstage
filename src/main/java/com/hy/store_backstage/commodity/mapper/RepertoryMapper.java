package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import com.hy.store_backstage.commodity.entity.RepertoryBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepertoryMapper extends BaseMapper<RepertoryBean> {
    /*根据商品id查询库存的所有信息*/
    @Select("select * from commodity_goout where com_id=#{value}")
    public List<RepertoryBean> selectGoTo(Long comId);

    /*修改库存信息*/
    @Update("update commodity_goout set com_price=#{comPrice},repertory_number=#{repertoryNumber},com_warning=#{comWarning} where com_sku=#{comSku}")
    public void updatGoTo(RepertoryBean repertoryBean);

    /*生成的sku编码*/
    @Select("SELECT RPAD('HY',18,DATE_FORMAT(NOW(),'%Y%m%d%H%i%s'))")
    public String bianma();

    /*查询商品入库的信息*/
    @Select("   SELECT c.com_img comImg,c.com_name comName,c.com_no comNo,g.size_name sizeName,g.color_name colorName,g.goout_number gooutNumber,\n" +
            "   (g.goout_number+g.repertory_number) repertoryNumber,g.handle_type handleType,g.goout_time gooutTime,g.goout_person gooutPerson,o.order_no orderNo \n" +
            "   FROM commodity c,commodity_goout g,orders o WHERE c.com_id=g.com_id AND g.`order_id`= o.`order_id` AND differ_both=1")
    public List<GoOutRepertoryBean> selectGo();

    /*查询商品出库的信息*/
    @Select("   SELECT c.com_img comImg,c.com_name comName,c.com_no comNo,g.size_name sizeName,g.color_name colorName,g.goout_number gooutNumber,\n" +
            "   (g.goout_number+g.repertory_number) repertoryNumber,g.handle_type handleType,g.goout_time gooutTime,g.goout_person gooutPerson,o.order_no orderNo \n" +
            "   FROM commodity c,commodity_goout g,orders o WHERE c.com_id=g.com_id AND g.`order_id`= o.`order_id` AND differ_both=2")
    public List<GoOutRepertoryBean> selectOut();

    /*入库信息模糊查询*/
    @SelectProvider(type = UniteSelect.class ,method="selectLikeGo" )
    public IPage<GoOutRepertoryBean> selectLikeGo(@Param("ipage") IPage<GoOutRepertoryBean> page,@Param("goOutRepertoryBean") GoOutRepertoryBean goOutRepertoryBean);

    /*查询入库商品的总数量*/
    @Select("SELECT COUNT(goout_id) FROM commodity_goout WHERE differ_both=1")
    public Integer goNumber();

    /*出库信息模糊查询*/
    @SelectProvider(type = UniteSelect.class ,method="selectLikeOut" )
    public IPage<GoOutRepertoryBean> selectLikeOut(@Param("ipage") IPage<GoOutRepertoryBean> page,@Param("goOutRepertoryBean") GoOutRepertoryBean goOutRepertoryBean);

    /*查询出库商品的总数量*/
    @Select("SELECT COUNT(goout_id) FROM commodity_goout WHERE differ_both=2")
    public Integer outNumber();
}

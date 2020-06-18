package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import com.hy.store_backstage.commodity.entity.RepertoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
    @Select("SELECT C.com_img AS 'comImg',C.com_name AS 'comName',C.com_brand AS 'comBrand',C.com_no AS 'comNo',O.order_no AS 'orderNo',\n" +
            "G.handle_type AS 'handleType',G.goout_time AS 'gooutTime',G.goout_person AS 'gooutPerson',G.color_name AS colorName,\n" +
            "G.size_name AS sizeName,G.goout_number AS gooutNumber,(G.repertory_number+G.goout_number) AS repertoryNumber \n" +
            "FROM commodity C,orders O,commodity_goout G WHERE C.com_id=O.order_commodity AND C.com_id=G.com_id AND G.differ_both=1")
    public List<GoOutRepertoryBean> selectGo();

    /*查询商品出库的信息*/
    @Select("SELECT C.com_img AS 'comImg',C.com_name AS 'comName',C.com_brand AS 'comBrand',C.com_no AS 'comNo',O.order_no AS 'orderNo', \n" +
            "G.handle_type AS 'handleType',G.goout_time AS 'gooutTime',G.goout_person AS 'gooutPerson',G.color_name AS colorName,\n" +
            "G.size_name AS sizeName,G.goout_number AS gooutNumber,(G.repertory_number+G.goout_number) AS repertoryNumber \n" +
            "FROM commodity C,orders O,commodity_goout G WHERE C.com_id=O.order_commodity AND C.com_id=G.com_id AND G.differ_both=2")
    public List<GoOutRepertoryBean> selectOut();

    /*入库信息模糊查询*/
    @SelectProvider(type = UniteSelect.class ,method="selectLikeGo" )
    public List<GoOutRepertoryBean> selectLikeGo(GoOutRepertoryBean goOutRepertoryBean);

    /*出库信息模糊查询*/
    @SelectProvider(type = UniteSelect.class ,method="selectLikeOut" )
    public List<GoOutRepertoryBean> selectLikeOut(GoOutRepertoryBean goOutRepertoryBean);

}

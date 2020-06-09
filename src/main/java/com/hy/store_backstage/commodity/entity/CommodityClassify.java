package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("commodity_type")
@Data
public class CommodityClassify implements Serializable {
       /*商品分类id*/
       private Long typeId;
       /*商品分类编号*/
       private String typeNo;
       /*分类名称*/
       private String typeName;
       /*级别*/
       private String typeGrade;
       /*商品数量*/
       private Long typeNumber;
       /*数量单位*/
       private String typeUnit;
       /*导航栏*/
       private String typeBar;
       /*是否展示*/
       private String typeIsshow;
       /*排序*/
       private Long typeSort;
       /*设置*/
       private Long typeSet;/*无用*/



}

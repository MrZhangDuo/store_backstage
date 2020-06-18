package com.hy.store_backstage.commodity.entity;

import java.util.List;

public class ComAndReper {
    private CommodityEntity commodity;
    private List<RepertoryBean> sizeAndColors;


    public CommodityEntity getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityEntity commodity) {
        this.commodity = commodity;
    }

    public List<RepertoryBean> getSizeAndColors() {
        return sizeAndColors;
    }

    public void setSizeAndColors(List<RepertoryBean> sizeAndColors) {
        this.sizeAndColors = sizeAndColors;
    }


    @Override
    public String toString() {
        return "ComAndReper{" +
                "commodity=" + commodity +
                ", sizeAndColors=" + sizeAndColors +
                '}';
    }
}

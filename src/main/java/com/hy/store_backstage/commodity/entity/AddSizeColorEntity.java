package com.hy.store_backstage.commodity.entity;

public class AddSizeColorEntity {
   private String  comName;
   private String comImg;
   private String comNo;
   private String comBrand;
   private String colorName;
   private String sizeName;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public String getComNo() {
        return comNo;
    }

    public void setComNo(String comNo) {
        this.comNo = comNo;
    }

    public String getComBrand() {
        return comBrand;
    }

    public void setComBrand(String comBrand) {
        this.comBrand = comBrand;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Override
    public String toString() {
        return "AddSizeColorEntity{" +
                "comName='" + comName + '\'' +
                ", comImg='" + comImg + '\'' +
                ", comNo='" + comNo + '\'' +
                ", comBrand=" + comBrand +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }
}

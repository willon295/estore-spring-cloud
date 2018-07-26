package com.briup.estore.common.dto;

/**
 * 书本查询的参数
 *
 * @author willon
 */
public class BookQueryParamDTO {

    /**
     * 所有文字描述信息
     */
    private String des;


    /**
     * 最低价
     */
    private Double fromPrice;

    /**
     * 最高价
     */
    private Double toPrice;


    public Double getFromPrice() {
        return fromPrice;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setFromPrice(Double price) {
        //如果存在最高价，且此价格大于最高价
        if (toPrice != null && price > toPrice) {
            this.fromPrice = toPrice;
            this.toPrice = price;
        } else {
            this.fromPrice = price;
        }

    }

    public Double getToPrice() {
        return toPrice;
    }

    public void setToPrice(Double price) {
        if (fromPrice != null && price < fromPrice) {
            this.toPrice = fromPrice;
            this.fromPrice = price;
        } else {
            this.toPrice = price;
        }
    }


    @Override
    public String toString() {
        return "BookQueryParamDTO{" +
                "des='" + des + '\'' +
                ", fromPrice=" + fromPrice +
                ", toPrice=" + toPrice +
                '}';
    }
}

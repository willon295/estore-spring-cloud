package com.briup.estore.common.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * 书本查询条件 参数DTO 类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Getter
@ToString
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


    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 设置最低价，处理异常输入，空输入
     *
     * @param price 价格
     */
    public void setFromPrice(Double price) {
        //如果存在最高价，且此价格大于最高价
        if (toPrice != null && price > toPrice) {
            this.fromPrice = toPrice;
            this.toPrice = price;
        } else {
            this.fromPrice = price;
        }

    }

    public void setToPrice(Double price) {
        if (fromPrice != null && price < fromPrice) {
            this.toPrice = fromPrice;
            this.fromPrice = price;
        } else {
            this.toPrice = price;
        }
    }


}

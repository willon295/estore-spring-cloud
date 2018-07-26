package com.briup.estore.common.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class BizContent {

    /**
     * 订单号 ： 对应入参的 out_trade_no
     */
    private String orderId;


    /**
     * 总金额： 对应入参 total_amount
     */
    private String cost;


    /**
     * 订单标题： 对应入参 subject
     */
    private String title;


    /**
     * 商家 id： 对应入参 store_id
     */
    private String traderId = "2018000007201200";


    /**
     * 交易超时(默认120秒)： 对应入参 timeout_express
     */
    private String timeout = "120m";


    public BizContent(String orderId, String cost, String title) {
        this.orderId = orderId;
        this.cost = cost;
        this.title = title;
    }

    @Override
    public String toString() {
        return "{" +
                " 'out_trade_no': '" + orderId + '\'' +
                ", 'total_amount': '" + cost + '\'' +
                ", 'subject': '" + title + '\'' +
                '}';
    }
}

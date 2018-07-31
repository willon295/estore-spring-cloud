package com.briup.estore.common.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 支付宝订单请求内容实体类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Getter
@NoArgsConstructor
@Setter
public class BizContent {
    private String outTradeNo;
    private String totalAmount;
    private String subject;
    private String body;
    private String productCode = "FAST_INSTANT_TRADE_PAY";

    @Override
    public String toString() {

        return "{\"out_trade_no\":\"" +outTradeNo + "\"" +
                ", \"total_amount\":\"" + totalAmount + "\"" +
                ", \"subject\":\"" + subject + "\"" +
                ", \"body\":\"" + body + "\"" +
                ", \"product_code\":\"" + productCode + "\"" +
                '}';
    }

}

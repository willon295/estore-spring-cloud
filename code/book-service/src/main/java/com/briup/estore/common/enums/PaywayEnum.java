package com.briup.estore.common.enums;


/**
 *  支付方式 枚举类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
public enum PaywayEnum {

    /**
     * 现金
     */
    CASH(0, "现金"),

    /**
     * 支付宝
     */
    ALIPAY(1, "支付宝"),

    /**
     * 微信
     */
    WECHAT(2, "微信");
    int code;
    String desc;

    PaywayEnum(int id, String type) {
        this.code = id;
        this.desc = type;
    }

    public int getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Payway{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
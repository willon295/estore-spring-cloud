package com.briup.estore.common.enums;


public enum PaywayEnum {

    /**
     * 货到付款
     */
    HDFK(0, "货到付款"),

    /**
     * 邮局汇款
     */
    YJHK(1, "邮局汇款"),

    /**
     * 银行转账
     */
    YHZZ(2, "银行转账");
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

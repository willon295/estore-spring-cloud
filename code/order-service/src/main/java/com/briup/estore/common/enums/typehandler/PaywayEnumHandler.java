package com.briup.estore.common.enums.typehandler;

import com.briup.estore.common.enums.PaywayEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举类型处理器
 *
 * @author willon
 */
public class PaywayEnumHandler extends BaseTypeHandler<PaywayEnum> {


    private Class<PaywayEnum> type;
    private final PaywayEnum[] payways;

    public PaywayEnumHandler(Class<PaywayEnum> type) {
        this.type = type;
        this.payways = type.getEnumConstants();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PaywayEnum payway, JdbcType jdbcType) throws SQLException {

        ps.setInt(i, payway.getCode());
    }

    @Override
    public PaywayEnum getNullableResult(ResultSet rs, String s) throws SQLException {
        return locatePayway(rs.getInt(s));
    }

    @Override
    public PaywayEnum getNullableResult(ResultSet rs, int i) throws SQLException {
        return locatePayway(rs.getInt(i));
    }

    @Override
    public PaywayEnum getNullableResult(CallableStatement cs, int i) throws SQLException {

        return locatePayway(cs.getInt(i));
    }

    private PaywayEnum locatePayway(int code) {

        for (PaywayEnum payway : payways) {
            if (payway.getCode() == code) {
                return payway;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型" + code + "," + type);
    }

}




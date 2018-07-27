package com.briup.estore.common.dto;

import lombok.Data;

/**
 * 统一 响应数据类
 *
 * @author willon
 */
@Data
public class ResponseDTO {

    /**
     * 状态
     * OK     成功
     * FAILED 失败
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

}

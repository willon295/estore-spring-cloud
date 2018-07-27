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
     * 处理的结果
     * OK   成功处理
     * FAILED 处理失败
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object data;
}

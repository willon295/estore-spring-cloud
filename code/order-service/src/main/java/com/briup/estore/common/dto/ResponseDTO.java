package com.briup.estore.common.dto;

import lombok.Data;

/**
 *  服务器统一相应数据 DTO 类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
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

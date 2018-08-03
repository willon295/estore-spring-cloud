package com.briup.estore.common.handler;

import com.briup.estore.common.dto.ResponseDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 404 异常信息处理
 *
 * @author willon
 * @version 1.0
 * 联系方式： willon295@163.com
 * @since 18-8-3
 */
@RestController
public class NotFoundHandler implements ErrorController {

    /**
     * 404处理路径
     */
    private static final String ERROR_PATH = "/error";
    private static final String FAILED = "FAILED";

    /**
     * 404 请求路径
     *
     * @return 错误信息
     */
    @GetMapping(ERROR_PATH)
    public ResponseDTO error() {
        ResponseDTO response = new ResponseDTO();
        response.setMsg(FAILED);
        response.setData("接口不存在");
        return response;
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}

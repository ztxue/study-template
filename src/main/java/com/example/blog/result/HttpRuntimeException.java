package com.example.blog.result;



import lombok.Getter;
import lombok.Setter;

/**
 * @author: sunping
 * @description: 自定义异常处理
 * @date: 2020/5/20
 */
@Setter
@Getter
public class HttpRuntimeException extends RuntimeException {

    /**
     * 返回码
     */
    private final String code;
    /**
     * 返回提示消息
     */
    private final String message;

    public HttpRuntimeException(String message) {
        super(message);
        this.code = "500";
        this.message = message;
    }
    public HttpRuntimeException(String code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
    public HttpRuntimeException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
        this.message = resultEnum.getDesc();
    }
}

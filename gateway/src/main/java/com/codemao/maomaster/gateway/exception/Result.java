package com.codemao.maomaster.gateway.exception;import lombok.Getter;@Getterpublic enum Result {    SUCCESS("SUCCESS", 0),    BODY_NOT_MATCH("请求的数据格式不符!", 400),    SIGNATURE_NOT_MATCH("请求的数字签名不匹配!", 401),    NOT_FOUND("未找到该资源!", 404),    INTERNAL_SERVER_ERROR("服务器内部错误!", 500),    SERVER_BUSY("服务器正忙，请稍后再试!", 503),    FAIL("FAIL", 1);    private String message;    private Integer code;    Result(String message, Integer code) {        this.message = message;        this.code = code;    }}
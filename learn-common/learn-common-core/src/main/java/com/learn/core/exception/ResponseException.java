package com.learn.core.exception;


import com.learn.core.domain.R;
import com.learn.core.enums.ResponseStatus;
import com.learn.core.web.domain.AjaxResult;

/**
 * @ClassName CommonException
 * @Description 通用异常，包含AjaxResult，可直接返回到前端
 * @Author dajie
 * @Date 2021/4/29 2:10 下午
 * @Version V1.0
 **/
public class ResponseException extends RuntimeException {

    private final AjaxResult ajaxResult;

    public ResponseException(AjaxResult ajaxResult) {
        this.ajaxResult = ajaxResult;
    }

    public ResponseException(ResponseStatus responseStatus) {
        this.ajaxResult = AjaxResult.error(responseStatus);
    }

    public ResponseException(ResponseStatus responseStatus, Throwable e) {
        super(e);
        this.ajaxResult = AjaxResult.error(responseStatus, e);
    }

    public ResponseException(ResponseStatus responseStatus, String message) {
        this.ajaxResult = AjaxResult.error(responseStatus, message);
    }

    public ResponseException(R<?> r) {
        this.ajaxResult = r.conventToAjaxResult();
    }

    public AjaxResult getAjaxResult() {
        return ajaxResult;
    }

    public String getCode() {
        Object code = ajaxResult.get(AjaxResult.CODE_TAG);
        if (code == null) {
            return null;
        }
        return code.toString();
    }

    public String getMsg() {
        Object msg = ajaxResult.get(AjaxResult.MSG_TAG);
        if (msg == null) {
            return null;
        }
        return msg.toString();
    }


}

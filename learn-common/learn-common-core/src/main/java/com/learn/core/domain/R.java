package com.learn.core.domain;

import com.alibaba.fastjson.JSONObject;
import com.learn.core.constant.Constants;
import com.learn.core.enums.ResponseStatus;
import com.learn.core.utils.ExceptionUtil;
import com.learn.core.web.domain.AjaxResult;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author xkiot
 */
@ToString
public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final String SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final String FAIL = Constants.FAIL;

    private String code;

    private String msg;

    private String errorMsg;

    private T data;


    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data)
    {
        return restResult(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> R<T> fail(ResponseStatus responseStatus) {
        return restResult(null, responseStatus.getCode(), responseStatus.getMessage());
    }

    public static <T> R<T> fail(ResponseStatus responseStatus, Throwable e) {
        R<T> r = restResult(null, responseStatus.getCode(), responseStatus.getMessage());
        r.setErrorMsg(ExceptionUtil.getExceptionMessage(e));
        return r;
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> R<T> fail(T data, String code, String msg) {
        return restResult(data, code, msg);
    }

    public static <T> R<T> fail(String code, String msg) {
        return restResult(null, code, msg);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static <T> R<T> create(AjaxResult ajaxResult) {
        JSONObject json = new JSONObject(ajaxResult);
        Object tempData = json.get(AjaxResult.DATA_TAG);
        T data = tempData != null ? (T) tempData : null;
        return restResult(data,
                json.getString(AjaxResult.CODE_TAG),
                json.getString(AjaxResult.MSG_TAG)
        );
    }

    private static <T> R<T> restResult(T data, String code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AjaxResult conventToAjaxResult() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put(AjaxResult.CODE_TAG, code);
        ajaxResult.put(AjaxResult.MSG_TAG, msg);
        ajaxResult.put(AjaxResult.DATA_TAG, data);
        return ajaxResult;
    }
}

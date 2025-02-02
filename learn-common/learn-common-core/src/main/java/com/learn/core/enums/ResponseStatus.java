package com.learn.core.enums;


import com.learn.core.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResponseStatus
 * @Description
 * @Author dajie
 * @Date 2021/4/29 2:14 下午
 * @Version V1.0
 **/
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    SUCCESS(Constants.SUCCESS, "成功"),

    SYSTEM_ERROR("E100001", "系统异常"),
    SYSTEM_DATABASE_ERROR("E100002", "数据库异常"),
    SYSTEM_DOWNLOAD_FILE_ERROR("E100003", "文件下载失败"),
    SYSTEM_UPLOAD_FILE_ERROR("E100004", "文件上传失败"),
    PARAMS_ILLEGAL("E100005", "参数非法"),

    DEVICE_NOT_FOUND_ERROR("E100006", "设备不存在"),
    PRODUCT_NOT_FOUND_ERROR("E100007", "产品不存在"),
    DEVICE_NOT_REGISTER_ERROR("E100008", "设备未注册"),
    DEVICE_NOT_CHECK_ERROR("E100009", "设备验证错误"),
    DEVICE_NOT_ACCESS_ERROR("E100010", "设备access过期或错误"),

    VERIFICATION_CODE_INVALID("E100011", "验证码已失效"),
    VERIFICATION_CODE_WRONG("E100012", "验证码错误"),
    VERIFY_SIGN_WRONG("E100013", "签名错误"),
    QR_CODE_WRONG("E100014", "二维码已失效"),
    PARAMS_MISSING("E100015", "缺少必要参数"),
    FACE_NOT_FOUND("E100016", "图片不包含人脸，或人脸模糊"),
    SYSTEM_REQUEST_ERROR("E100017", "请求服务失败"),
    AI_RETURN_ERROR("E100018", "算法服务返回失败"),
    WX_LOGIN_RETURN_ERROR("E100019", "微信扫码登陆错误"),
    WX_NO_BIND_RETURN_ERROR("E100020", "请先绑定微信账户"),
    EXCEL_NOT_FOUND("E100021", "找不到Excel文件"),
    FILE_NOT_FOUND("E100022", "文件不存在"),
    GET_LOCK_TIMEOUT("E100023", "系统繁忙，请稍后再试"),
    ASSOCIATE_DATA_EXISTS("E100024", "删除数据失败, 存在关联的数据"),
    ID_NOT_FOUND("E100025", "id不存在"),


    PF_FILESERVER_SYSTEM_ERROR("E300600", "System error."),
    PF_FILESERVER_REQUEST_PARAMS_ERROR("E300601", "BAD_PARAMETER: <key>"),
    PF_FILESERVER_DB_SYSTEM_ERROR("E300602", "mongodb system error."),
    PF_FILESERVER_DB_DUPLICATEKEY_ERROR("E300603", "Duplicate id error."),
    PF_FILESERVER_DB_FILEUNEXIST_ERROR("E300604", "File not exist."),
    PF_FILESERVER_FILEUNEXIST_ERROR("E300605", "File not exist."),

    ALG_FVP_RECEIVE_SYSTEM_ERROR("E110101", "系统处理异常"),
    ALG_FVP_PARAMETER_ERROR("E110102", "BAD_PARAMETER: <key>"),
    AUTH_WX_SESSION_ERROR("E110103", "微信session_key过期"),
    MUST_WECHAT_LOGIN("E110104", "请使用微信登录"),
    USER_PHONE_NUMBER_EXIST_ERROR("E110105", "手机号已注册"),
    USER_COMPANY_EXIST_ERROR("E110106", "公司已存在"),
    USER_REGISTER_FAIL_ERROR("E110107", "用户注册失败"),
    USER_VERIFY_CODE_TOO_FAST_ERROR("E110108", "请求发送验证码过于频繁"),
    USER_NOT_EXIST_ERROR("E110109", "用户不存在"),
    NO_UPDATE_VERSION_AVAILABLE("E110110", "暂无可用升级包"),
    SOFT_VERSION_NOT_FOUND("E110111", "软件版本不存在"),

    NOT_IN_SIGN_SCENE_ERROR("E110112", "人员未绑定考勤场景，操作无效"),
    START_TIME_LATER_THAN_END_TIME_ERROR("E110113", "开始时间不得早于结束时间"),
    LEAVE_REQUEST_DURATION_TOO_SHORT_ERROR("E110113", "请假时间间隔过短"),
    DUPLICATED_REPLACEMENT_CARD("E110114", "该补卡申请已存在，无法重复申请"),

    /*************场景异常*************/
    SCENE_INFO_NOT_FOUND("E120001", "场景不存在"),
    SCENE_TYPE_NOT_SUPPORT("E120002", "不支持的场景类型"),
    SIGN_RULE_NOT_FOUND("E120003", "找不到考勤策略"),
    SIGN_RULE_TYPE_NOT_SUPPORT("E120004", "不支持的考勤类型"),

    /*************CMDB专用异常*************/
    PLATFORM_OBJECT_EXIST("E300001", "对象已存在"),
    PLATFORM_ATTRIBUTE_NAME_ILLEGAL("E300002", "属性名不能以下划线开头"),
    PLATFORM_ATTRIBUTE_PROTECTED("E300003", "属性被保护，无法删除"),
    PLATFORM_REF_OBJECT_NOT_FOUND("E300004", "关联对象不存在"),
    PLATFORM_DYNAMIC_INTERFACE_EXECUTE_FAIL("E300005", "执行失败"),
    PLATFORM_ATTRIBUTE_EXIST("E300006", "属性已存在"),
    PLATFORM_OBJECT_PROTECTED("E300007", "对象被保护，无法删除"),
    PLATFORM_INTERFACE_NOT_FOUND("E300008", "接口不存在"),
    PLATFORM_OPERATION_BLOCKED("E300009", "操作被拦截"),
    PLATFORM_INTERCEPTOR_NOT_FOUND("E300010", "拦截器类名不正确或未在ioc容器中注册"),

    DYNAMIC_REPORT_INFO_NOT_FOUND("E300011", "自定义报表不存在"),
    MONGO_COMMAND_INVALID("E300012", "无效的mongo语句"),
    DYNAMIC_REPORT_EXIST("E300013", "自定义报表已存在"),
    SHARE_INFO_INVALID("E300014", "分享链接已失效"),
    SHARE_SAVE_MULTIPLE_EXCEPTION("E300015", "请勿重复填写"),
    SHARE_DATA_NO_PERMISSION("E300016", "无权限操作，请联系管理员"),
    INTERFACE_ATTRIBUTE_NOT_FOUND("E300017", "对象属性不存在"),
    TERM_INFO_INTERFACE_NOT_FOUND("E300018", "创建失败，设备管理对象不存在"),

    /******************sms异常定义*******************************************************/
    SMS_SYSTEM_ERROR("E400001", "aliyun 短信服务异常."),
    SMS_SYSTEM_NULL_RESULT("E400002","aliyun 短信服务返回结果为空"),
    SMS_ISV_BUSINESS_LIMIT_CONTROL("E400003", "业务限流对同一个手机号码发送短信验证码，支持1条/分钟，5条/小时 ，累计10条/天"),
    SMS_ISV_AMOUNT_NOT_ENOUGH("E400004","aliyun短信服务账号余额不足");


    private final String code;
    private final String message;

}

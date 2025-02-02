package com.learn.core.constant;

/**
 * 通用常量信息
 *
 * @author xkiot
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final String SUCCESS = "200";

    /**
     * 失败标记
     */
    public static final String FAIL = "500";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 720;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 执行状态
     */
    public static final String EXECUTE_STATUS_SUCCESS = "success"; //成功
    public static final String EXECUTE_STATUS_FAIL = "fail"; //失败

    public static final String MASTER_CAPCHA_UUID = "5768d149aa1149dcb039f02eaf10a2ad";

    public static final String DATABASE_CLEAN_TABLE_TYPE_NORMAL = "normal"; //一般表格

    public final static String DYNAMIC_OBJECT_DATA_TYPE_STR = "str"; // 字符串数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_INT = "int"; // 整型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_FLOAT = "float"; // 浮点型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_DATE = "date"; // 日期型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_ENUM = "enum"; // 枚举型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_DATA_DICT = "dataDict"; // 数据字典型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_TEXT = "textarea"; // 文本型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_PIC = "pic"; // 图片型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_OBJ = "obj"; // 对象型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_FILE = "file"; // 文件型数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_CUSTOM_DROPDOWN = "customDropdown"; // 自定义下拉
    public final static String DYNAMIC_OBJECT_DATA_TYPE_OBJECT_ID = "objectId"; // objectId数据
    public final static String DYNAMIC_OBJECT_DATA_TYPE_OPERATE = "operate"; // 自定义操作

    public final static String DYNAMIC_OBJECT_QUERY_TYPE_EQ = "eq"; // 精确匹配
    public final static String DYNAMIC_OBJECT_QUERY_TYPE_RANGE = "range"; // 范围匹配
    public final static String DYNAMIC_OBJECT_QUERY_TYPE_REGEX = "regex"; // 模糊匹配
    public final static String DYNAMIC_OBJECT_QUERY_TYPE_PRE_REGEX = "preRegex"; // 前缀匹配
    public final static String DYNAMIC_OBJECT_QUERY_TYPE_IN = "in"; // 多选查询

    public final static String DYNAMIC_OBJECT_ORDER_DESC = "desc"; // 降序排序
    public final static String DYNAMIC_OBJECT_ORDER_ASC = "asc"; // 升序排序
    public final static String DYNAMIC_OBJECT_ORDER_NONE = "none"; // 不排序


    public final static String DYNAMIC_OBJECT_DISPLAY_MODE_TABLE = "table"; // 表格显示模式
    public final static String DYNAMIC_OBJECT_DISPLAY_MODE_TREE = "tree"; // 树形显示模式
    public final static String DYNAMIC_OBJECT_DISPLAY_MODE_TREE_TABLE = "treeTable"; // 树形-表格显示模式

    public final static String DYNAMIC_OBJECT_AUTHORITY_NONE = "none"; // 无权限
    public final static String DYNAMIC_OBJECT_AUTHORITY_SELF = "self"; // 仅自身权限
    public final static String DYNAMIC_OBJECT_AUTHORITY_TREE = "tree"; // 树形权限（自身及下级）
    public final static String DYNAMIC_OBJECT_AUTHORITY_REV_TREE = "revTree"; // 反向树形权限 (自身及上级)

    public final static String DYNAMIC_OBJECT_COMPANY_IDS = "_company_ids"; // 公司id
    public final static String DYNAMIC_OBJECT_ORG_INFO_ATTRIBUTE = "_org_info"; // 机构信息属性
    public final static String DYNAMIC_OBJECT_ORG_PATH_ATTRIBUTE = "_org_path"; // 机构路径
    public final static String DYNAMIC_OBJECT_TREE_PATH_ATTRIBUTE = "_path"; // 树形结构显示名称
    public final static String DYNAMIC_OBJECT_ORG_INFO_ANCESTORS_ATTRIBUTE = "ancestors"; // 机构路径字段
    public final static String DYNAMIC_OBJECT_TREE_ID_ATTRIBUTE = "_id"; // id字段
    public final static String DYNAMIC_OBJECT_TREE_PARENT_ID_ATTRIBUTE = "_parent_id"; // 树父级id
    public final static String DYNAMIC_OBJECT_TREE_IS_PARENT_ATTRIBUTE = "_is_parent"; // 是否为父级
    public final static String DYNAMIC_OBJECT_TREE_PARENT_NAME_ATTRIBUTE = "_parent_name"; // 树父级名称
    public final static String DYNAMIC_OBJECT_TREE_LEVEL_ATTRIBUTE = "_level"; // 树层级

    public final static String DYNAMIC_INTERFACE_TYPE_DATA_UPLOAD = "/message/receive"; // 数据上送-1
    public final static String DYNAMIC_INTERFACE_TYPE_EVENT_UPLOAD = "/event/receive"; // 事件上送-2
    public final static String DYNAMIC_INTERFACE_TYPE_ORDER = "order"; // 指令下发-3
    public final static String DYNAMIC_INTERFACE_TYPE_ORDER_REPLY = "/order/receive"; // 指令下发响应-4
    public final static String DYNAMIC_INTERFACE_TYPE_PARAMS = "/params/receive"; // 参数下发-5
    public final static String DYNAMIC_INTERFACE_TYPE_PARAMS_REPLY = "/params/receive"; // 参数下发响应-6
    public final static String DYNAMIC_INTERFACE_TYPE_DATA = "data"; // 数据下发-7
    public final static String DYNAMIC_INTERFACE_TYPE_DATA_REPLY = "/datasync/receive"; // 数据下发回复-8
    public final static String DYNAMIC_INTERFACE_TYPE_SOFT_UPDATE = "softUpdate"; // 软件更新(不可自定义)

    public final static String DYNAMIC_INTERFACE_TYPE_ID_DATA_UPLOAD = "1"; // 数据上送-1
    public final static String DYNAMIC_INTERFACE_TYPE_ID_EVENT_UPLOAD = "2"; // 事件上送-2
    public final static String DYNAMIC_INTERFACE_TYPE_ID_ORDER = "3"; // 指令下发-3
    public final static String DYNAMIC_INTERFACE_TYPE_ID_ORDER_REPLY = "4"; // 指令下发响应-4
    public final static String DYNAMIC_INTERFACE_TYPE_ID_PARAM = "5"; // 参数下发-5
    public final static String DYNAMIC_INTERFACE_TYPE_ID_PARAM_REPLY = "6"; // 参数下发响应-6
    public final static String DYNAMIC_INTERFACE_TYPE_ID_DATA = "7"; // 数据下发-7
    public final static String DYNAMIC_INTERFACE_TYPE_ID_DATA_REPLY = "8"; // 数据下发回复-8
    public final static String DYNAMIC_INTERFACE_TYPE_ID_NORMAL_TABLE = "99"; // 普通表格-99

    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_PATH_FIELD = "pathField"; // path对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_PARENT_ID_FIELD = "parentIdField"; // parentId对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_IS_PARENT_FIELD = "isParentField"; // isParent对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_LEVEL_FIELD = "levelField"; // level对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_PARENT_NAME_FIELD = "parentNameField"; // parentName对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_DISPLAY_NAME_FIELD = "displayNameField"; // displayName对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_INTERFACE_REF = "interfaceRef"; // 接口引用id对应字段名
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_EVENT_TYPE = "eventType"; // typeDefine中的eventType字段
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_ENUM_VALUES = "enumValues"; // 枚举值
    public final static String DYNAMIC_INTERFACE_TYPE_DEFINE_SINGLE_FLAG = "singleFlag";

    public final static String DYNAMIC_ATTRIBUTE_NAME_TREE_DISPLAY_NAME = "display_name"; // 显示名称
    public final static String DYNAMIC_ATTRIBUTE_NAME_TIME = "_time"; // 时间
    public final static String DYNAMIC_ATTRIBUTE_NAME_TERM_INFO = "_term_info"; // 设备信息
    public final static String DYNAMIC_ATTRIBUTE_NAME_CREATE_AUTHOR = "_create_author"; // 创建人
    public final static String DYNAMIC_ATTRIBUTE_NAME_UPDATE_AUTHOR = "_update_author"; // 更新人
    public final static String DYNAMIC_ATTRIBUTE_UPDATE_TIME = "_update_time"; // 更新时间
    public final static String DYNAMIC_ATTRIBUTE_CREATE_TIME = "_create_time"; // 创建时间
    public final static String DYNAMIC_ATTRIBUTE_CREATE = "_create"; // 是否新增
    public final static String DYNAMIC_ATTRIBUTE_UNIONID = "_unionid"; // 微信unionid


    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_DICT_REF = "dictRef"; // 数据字典引用字段
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_BASE64_FLAG = "base64Flag"; // base64标记
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_SAVE_FOREVER = "saveForever"; // 文件永久保存
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_FACE_CHECK = "faceCheck"; // 是否检测人脸
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_SAVE_OBJECT = "saveObject"; // 直接保存实体不进行引用
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_DB_REF = "dbRef"; // 数据表引用
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_FORMAT = "format"; // 日期格式化
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_SYNC_OBJECT = "syncObject"; // 是否同步对象
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_SYNC_BASE64 = "syncBase64"; // 是否同步base64
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_ONLY_DISPLAY_ATTR = "onlyDisplayAttr"; // 仅关联需要显示的字段
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_DATA_URL = "dataUrl"; // 数据来源接口
    public final static String DYNAMIC_ATTRIBUTE_TYPE_DEFINE_BUCKET_NAME = "bucketName"; // 文件bucketName

    public final static String DYNAMIC_ATTRIBUTE_REF_OBJECT_PARAMS_FIELD_DISPLAY = "fieldDisplay"; // 关联对象显示字段

    public final static String DYNAMIC_ATTRIBUTE_FORMABLE_REQUIRED = "required"; // 是否必填

    public final static String MENU_CMDB_COMPONENT = "platform/views/cmdb/index"; // cmdb菜单component

    public final static String MENU_CMDB_MINI_COMPONENT = "pages/cmdb/cmdb"; // cmdb小程序菜单component

    public final static String MENU_CMDB_VISIBLE_TYPE_ALL = "0"; // 菜单小程序、web都可见
    public final static String MENU_CMDB_VISIBLE_TYPE_ONLY_WEB = "1"; // 菜单仅web可见
    public final static String MENU_CMDB_VISIBLE_TYPE_ONLY_MINI = "2"; // 菜单仅小程序可见


    public final static String MINIO_HEADER_ORIGINAL_NAME = "original-name"; // minio header原始文件名

    public final static String CMDB = "cmdb";

    public final static String ENCRYPT_FILE_NAME_EXT = ".enc";
    public final static String ENCRYPT_FILE_NAME_EXT_CN = ".encx";
    public final static String ENCRYPT_FILE_NAME_EXT_NO_DOT = "enc";
    public final static String ENCRYPT_FILE_NAME_EXT_CN_NO_DOT = "encx";
    public final static String BUEKCT_NAME_TEMP = "temp";

    public final static String FILE_TYPE_FILE_SERVER = "fileServer"; // 文件类型-文件服务器
    public final static String FILE_TYPE_FILE_SERVER_DATE = "fileServerDate"; // 文件类型-文件服务器(根据日期分类)
    public final static String FILE_TYPE_LOCAL = "local"; // 文件类型-本地文件

    public final static String DATABASE_CLEAN_TABLE_TYPE_MONGO = "mongo"; // 数据库类型-mongo
    public final static String DATABASE_CLEAN_TABLE_TYPE_MYSQL = "mysql"; // 数据库类型-mysql

    public final static String DATABASE_CLEAN_FIELD_TYPE_STR = "str"; // 字段类型—str
    public final static String DATABASE_CLEAN_FIELD_TYPE_DATE = "date"; // 字段类型-date

    public final static String CLEAN_RESULT_FAIL = "1"; // 清理失败
    public final static String CLEAN_RESULT_SUCCESS = "0"; // 清理成功

    public final static String CLEAN_TASK_STATUS_ENABLE = "0"; // 清理任务开启
    public final static String CLEAN_TASK_STATUS_DISABLE = "1";// 清理任务关闭

    public final static String DELETE_SUB_FILE_ENABLE = "Y"; // 清除子文件
    public final static String DELETE_SUB_FILE_DISABLE = "N"; // 不清楚子文件

    // 0 已保存 1 已发送 2 已送达 3 已完成 4 指令发送超时 5 指令执行失败
    public final static String DATA_SYNC_EXECUTE_STATUS_SAVED = "0"; // 已保存
    public final static String DATA_SYNC_EXECUTE_STATUS_SENT = "1"; // 已发送
    public final static String DATA_SYNC_EXECUTE_STATUS_RECEIVED = "2"; // 已发送
    public final static String DATA_SYNC_EXECUTE_STATUS_COMPLETE = "3"; // 已完成
    public final static String DATA_SYNC_EXECUTE_STATUS_TIMEOUT = "4"; // 指令超时
    public final static String DATA_SYNC_EXECUTE_STATUS_FAIL = "5"; // 已失败

    public final static String[] DATA_SYNC_FAIL_STATUS_ARR = new String[]{"4","5"};//失败标志数组
    public final static String[] DATA_SYNC_UNTREATED_STATUS_ARR = new String[]{"0","1","2"};//未处理标志数组
    public final static String[] DATA_SYNC_SUCCESS_STATUS_ARR = new String[]{"3"};//成功标识数组

    public final static String EXCEL_TEMPLATE_INFO_SHEET = "templateInfo"; // excel模板信息sheet名
    public final static String FORM_TYPE_BASE_INFO = "baseinfo"; // formdata类型-baseinfo
    public final static String FORM_TYPE_BASE_INFO_CHINESE = "基础信息";

    public final static String EVENT_TYPE_INFO = "0"; // 消息等级-信息
    public final static String EVENT_TYPE_WARN = "1"; // 消息等级-警告
    public final static String EVENT_TYPE_ERROR = "2"; // 消息等级-故障

    public final static String DATA_SYNC_TYPE_ADD = "add"; // 同步类型-新增
//    public final static String DATA_SYNC_TYPE_UPDATE = "update"; // 同步类型-更新
    public final static String DATA_SYNC_TYPE_DELETE = "del"; // 同步类型-删除

    public final static String DEVICE_EXECUTE_CODE_SUCCESS = "0"; // 设备上送状态码-执行成功

    public final static String FILE_NAME_SEPARATOR = "--";

    public final static Integer CHANNEL_MQ = 1; //gateway mq渠道号
    public final static Integer CHANNEL_HTTP = 2; //gateway http渠道

    // 0 在线 1 离线 2 已激活
    public final static Integer TERM_STATUS_ONLINE = 0; // 设备在线
    public final static Integer TERM_STATUS_OFFLINE = 1; // 设备离线
    public final static Integer TERM_STATUS_ACTIVATED = 2; // 设备已激活
    public final static Integer TERM_STATUS_WARING = 3; // 设备警告

    public final static String DYNAMIC_REPORT_PARAMS_TYPE_DATE = "date"; // 日期类型
    public final static String DYNAMIC_REPORT_PARAMS_TYPE_STR = "str"; // 字符串类型
    public final static String DYNAMIC_REPORT_PARAMS_TYPE_FOREIGN_MATCH = "foreignMatch"; // 外键查询类型

    public final static String DYNAMIC_REPORT_STATISTIC_TYPE_CUSTOMIZE = "0"; // 报表类型-自定义配置
    public final static String DYNAMIC_REPORT_STATISTIC_TYPE_MQL = "1"; // 报表类型-自定义语句


    public final static String TIME_UNIT_MILLIS = "millis"; // 时间单位-毫秒
    public final static String TIME_UNIT_SECONDS = "seconds"; // 时间单位-秒
    public final static String TIME_UNIT_MINUTES = "minutes"; // 时间单位-分钟
    public final static String TIME_UNIT_HOURS = "hours"; // 时间单位-小时
    public final static String TIME_UNIT_DAYS = "days"; // 时间单位-天
    public final static String TIME_UNIT_MONTHS = "months"; // 时间单位-月
    public final static String TIME_UNIT_YEARS = "years"; // 时间单位-年

    public final static String DYNAMIC_REPORT_PARAMS_TYPE_DEFINE_TIME = "time"; // 动态参数-时间
    public final static String DYNAMIC_REPORT_PARAMS_TYPE_DEFINE_TIME_UNIT = "timeUnit"; // 动态参数-时间单位

    public final static String JOB_CONCURRENT_ENABLE = "0"; // 定时任务允许并发执行
    public final static String JOB_CONCURRENT_DISABLE = "1"; // 定时任务不允许并发执行

    public final static String JOB_STATUS_ENABLE = "0"; // 定时任务启动
    public final static String JOB_STATUS_DISABLE = "1"; // 定时任务禁用

    public final static String WEB_NOTICE_TYPE_GENERAL = "0";//页面通知类型，普通消息
    public final static String WEB_NOTICE_TYPE_WARN = "1";//页面通知类型，告警消息
    public final static String WEB_NOTICE_AUTH_TYPE_USER = "0";//通知权限根据用户区分
    public final static String WEB_NOTICE_AUTH_TYPE_DEVICE = "1";//通知权限根据设备区分
    public final static String WEB_NOTICE_STATUS_HAVE_READ = "0";// 通知已读
    public final static String WEB_NOTICE_STATUS_UNREAD = "1";//通知未读

    public final static long SHARE_INFO_TIMEOUT = 30; // 默认分享时长

    public final static String ORG_INFO_ATTRIBUTE_ANCESTORS = "ancestors"; // 机构路径

    public final static String DEFAULT_FILE_SERVER_TYPE = "local";

    public final static String TERM_SOFT_UPDATE_STATUS_NOTICE = "notice"; // 设备软件升级状态-已通知
    public final static String TERM_SOFT_UPDATE_STATUS_DOWNLOAD = "download"; // 设备软件升级状态-下载中
    public final static String TERM_SOFT_UPDATE_STATUS_INSTALL = "install"; // 设备软件升级状态-安装中
    public final static String TERM_SOFT_UPDATE_STATUS_COMPLETE = "complete"; // 设备软件升级状态-完成
    public final static String TERM_SOFT_UPDATE_STATUS_FAIL = "fail"; // 设备软件升级状态-失败

    public final static String TERM_MESSAGE_CHANNEL_MQTT = "mqtt"; // 设备消息来源-mqtt
    public final static String TERM_MESSAGE_CHANNEL_HTTP = "http"; // 设备消息来源-http

    public final static String DEVICE_HTTP_PROTOCOL = "device.http.protocol"; // 平台接口

    public final static String SCENE_TYPE_ENTRANCE_GUARD = "entranceguard"; // 门禁场景
    public final static String SCENE_TYPE_SIGN = "sign"; // 考勤场景

    public final static String COMPANY_IDS = "_company_ids"; // 公司id字段
    public final static String CUSTOMER_INFO_ATTR_SCENE_BIND = "scene_bind"; // 人员信息绑定场景字段

    /************************** 考勤场景专用常量 *************************/
    public final static String SIGN_TYPE_TERM = "term"; // 设备签到
    public final static String SIGN_TYPE_PHONE = "phone"; // 手机签到

    public final static String SIGN_DISTANCE_NORMAL = "normal"; // 考勤距离-正常
    public final static String SIGN_DISTANCE_OUTER = "outer"; // 考勤距离-外勤

    public final static String SIGN_DATE_TYPE_WORK = "work"; // 工作日
    public final static String SIGN_DATE_TYPE_REST = "rest"; // 休息

    public final static String SIGN_RECORD_STATUS_NORMAL_CHECK_IN = "0"; // 正常签到
    public final static String SIGN_RECORD_STATUS_LATE = "1"; // 迟到
    public final static String SIGN_RECORD_STATUS_EARLY = "2"; // 早退
    public final static String SIGN_RECORD_STATUS_OVERTIME = "8"; // 加班
    public final static String SIGN_RECORD_STATUS_NORMAL_CHECK_OUT = "9"; // 正常签退
    public final static String SIGN_RECORD_STATUS_REPLACE_CHECK_IN = "10"; // 补卡签到
    public final static String SIGN_RECORD_STATUS_REPLACE_CHECK_OUT = "11"; // 补卡签退

    public final static String SIGN_REPORT_STATUS_NORMAL = "0"; // 正常
    public final static String SIGN_REPORT_STATUS_LATE = "1"; // 迟到
    public final static String SIGN_REPORT_STATUS_EARLY = "2"; // 早退
    public final static String SIGN_REPORT_STATUS_LATE_EARLY = "3"; // 迟到早退
    public final static String SIGN_REPORT_STATUS_MISS = "4"; // 漏卡
    public final static String SIGN_REPORT_STATUS_ABSENT = "5"; // 缺勤
    public final static String SIGN_REPORT_STATUS_ABSENT_ALL = "6"; // 旷工
    public final static String SIGN_REPORT_STATUS_LEAVE = "7"; // 请假
    public final static String SIGN_REPORT_STATUS_BUSINESS = "8"; // 出差
    public final static String SIGN_REPORT_STATUS_INIT = "9"; // 未到(初始状态)

    public final static String SIGN_REPORT_STATUS_IN_LOST = "10"; // 进缺卡(仅时段状态存在)
    public final static String SIGN_REPORT_STATUS_OUT_LOST = "11"; // 出缺卡(仅时段状态存在)

    public final static String SIGN_REPORT_RULE_TYPE_FIXED = "fixed"; // 固定制
    public final static String SIGN_REPORT_RULE_TYPE_ELASTIC = "elastic"; // 弹性制
    public final static String SIGN_REPORT_RULE_TYPE_ARRANGE = "arrange"; // 排班制

    public final static String SIGN_REPORT_SIGN_FLAG_WORK = "0"; // 应出勤
    public final static String SIGN_REPORT_SIGN_FLAG_REST = "1"; // 不出勤

    public final static String SIGN_OVERTIME_MODE_CHECK_OUT = "0"; // 下班超过指定时间后才算加班
    public final static String SIGN_OVERTIME_MODE_ALL = "1"; // 上班前和下班后的工作时间都算作加班


    public final static String[] WEEK_STR = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    /************************** 接口ID专用常量 *************************/
    public static final String DOOR_STRATEGY_INTERFACE_ID = "6110a55f9932e4712354b870"; // 门禁策略接口id

    /************************** 设备专用常量 *************************/
    public static final String TERM_INFO_PARAMS_PASS_CONFIG = "pass_config"; // 通行参数配置
    public static final String TERM_INFO_ATTRIBUTE_DOOR_DIRECTION = "door_direction"; // 进出门标识字段名
    public static final String TERM_INFO_ATTRIBUTE_DOOR_DIRECTION_IN = "in"; // 进门标识
    public static final String TERM_INFO_ATTRIBUTE_DOOR_DIRECTION_OUT = "out"; // 出门标识


    public static final String APPLY_STATUS_PROCESSING = "0"; // 审批状态-处理中
    public static final String APPLY_STATUS_DISMISSED = "1"; // 审批状态-驳回
    public static final String APPLY_STATUS_SUCCESS = "2"; // 审批状态-成功
    public static final String APPLY_STATUS_CANCEL = "3"; // 审批状态-取消


}

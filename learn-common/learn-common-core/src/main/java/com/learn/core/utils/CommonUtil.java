package com.learn.core.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learn.core.constant.Constants;
import com.learn.core.domain.R;
import com.learn.core.enums.ResponseStatus;
import com.learn.core.exception.BaseException;
import com.learn.core.exception.ResponseException;
import com.learn.core.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 自定义工具类
 * <p>
 * 温馨提示：
 * 工程引入了 apache commons 及 hutool 两个工具包
 * 在编写工具类前，可以先找找上面两个包~
 **/
@Slf4j
public class CommonUtil {

    private static final Map<String, String> SCENE_TYPE_NAME;

    static {
        Map<String, String> temp = new HashMap<>();
        temp.put(Constants.SCENE_TYPE_ENTRANCE_GUARD, "门禁");
        temp.put(Constants.SCENE_TYPE_SIGN, "考勤");
        SCENE_TYPE_NAME = Collections.unmodifiableMap(temp);
    }

    public static void validataReceiveData(cn.hutool.json.JSONObject validataObj, String... fields) throws ResponseException {
        String checkContent = "";
        try {
            for (String field : fields) {
                if (validataObj.get(field) == null || "".equals(validataObj.getStr(field))) {
                    checkContent = checkContent + " " + field;
                }
            }
        } catch (Exception e) {
            log.error("checkInputName error:", e);
            throw new ResponseException(AjaxResult.error(ResponseStatus.SYSTEM_ERROR));
        }
        if (!"".equals(checkContent)) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.PARAMS_ILLEGAL, checkContent));
        }
    }

    public static void validataReceiveData(JSONObject validataObj, String... fields) throws ResponseException {
        String checkContent = "";
        try {
            for (String field : fields) {
                if (validataObj.get(field) == null || "".equals(validataObj.getString(field))) {
                    checkContent = checkContent + " " + field;
                }
            }
        } catch (Exception e) {
            log.error("checkInputName error:", e);
            throw new ResponseException(AjaxResult.error(ResponseStatus.SYSTEM_ERROR));
        }
        if (!"".equals(checkContent)) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.PARAMS_ILLEGAL, checkContent));
        }
        IdUtil.getSnowflake(1L,2L).nextId();
    }

    /**
     * 检查实体类中属性是否存在
     *
     * @param validataObj
     * @param fields
     * @throws ResponseException
     */
    public static void validataReceiveData(Object validataObj, String... fields) throws ResponseException {
        StringBuilder checkContent = new StringBuilder();
        try {
            Class<?> clazz = validataObj.getClass();
            for (String field : fields) {
                Field declaredField = clazz.getDeclaredField(field);
                declaredField.setAccessible(true);
                Object object = declaredField.get(validataObj);
                if (object == null || "".equals(object)) {
                    checkContent.append(" ").append(field);
                }
            }
        } catch (Exception e) {
            log.error("checkInputName error:", e);
            throw new ResponseException(AjaxResult.error(ResponseStatus.SYSTEM_ERROR));
        }

        if (checkContent.length() > 0) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.PARAMS_MISSING, checkContent.toString()));
        }
    }

    /**
     * 校验设备接入时，数据的验证
     *
     * @param params
     * @param secretKey
     * @throws ResponseException
     */
    public static void validateApiKeySign(cn.hutool.json.JSONObject params, String secretKey) throws ResponseException {
        String timestamp = params.getStr("timestamp");
        DateTime dateTime = new DateTime(Long.parseLong(timestamp));
        if (!dateTime.isIn(DateUtil.offsetMinute(DateTime.now(), -10), DateUtil.offsetMinute(DateTime.now(), 5))) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.PARAMS_ILLEGAL));
        }
        //暂存sign并移除请求实体中的sign
        String signP = params.getStr("sign");
        params.remove("sign");

        String signStr = MapUtil.sortJoin(params, StrUtil.EMPTY, StrUtil.EMPTY, false, secretKey);
        String sign = DigestUtil.md5Hex(signStr);
        if (!sign.equals(signP)) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.VERIFY_SIGN_WRONG));
        }
    }

    /**
     * 数组转换成十六进制字符串
     *
     * @param bArray
     * @return HexString
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuilder sb = new StringBuilder(bArray.length);
        String sTemp;
        for (byte b : bArray) {
            sTemp = Integer.toHexString(0xFF & b);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 把16进制字符串转换成字节数组
     *
     * @param hex
     * @return byte[]
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void checkInputName(Object requestModel, String... params) {
        String checkContent = "";
        try {
            for (String param : params) {
                Field[] fields = requestModel.getClass().getDeclaredFields();
                for (Field field : fields) {
                    String name = field.getName();
                    if (name.equals(param)) {
                        Object obj = field.get(requestModel);
                        if (obj == null) {
                            checkContent = checkContent + name + " ";
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("checkInputName error:", e);
            throw new ResponseException(AjaxResult.error(ResponseStatus.ALG_FVP_RECEIVE_SYSTEM_ERROR));
        }

        if (!"".equals(checkContent)) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.ALG_FVP_PARAMETER_ERROR, checkContent));
        }
    }

    /**
     * 获取主机名称
     *
     * @return
     * @throws UnknownHostException
     */
    public static String getHostName() throws UnknownHostException {
        try {
            InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 // PC-20140317PXKX/192.168.0.121
            return address.getHostName(); //获取本机计算机名称
        } catch (Exception e) {
            log.error("getHostName error:", e);
        }
        return "";
    }

    public static void checkRemoteResponse(R<?> result) {
        if (result == null) {
            throw new ResponseException(AjaxResult.error(ResponseStatus.SYSTEM_ERROR, "远程调用结果为空"));
        }
        if (!Constants.SUCCESS.equals(result.getCode())) {
            log.warn("远程调用返回失败结果:{}", result);
            throw new ResponseException(result);
        }
    }

    /**
     * 解析远程调用的结果
     *
     * @param result
     * @return
     */
    public static <T> T getRemoteResult(R<T> result) {
        if (!R.SUCCESS.equals(result.getCode())) {
            log.warn("远程调用返回失败结果:{}", result);
            throw new ResponseException(result);
        }
        return result.getData();
    }

    /**
     * 解析远程调用的结果
     *
     * @param result
     * @return
     */
    public static <T> T getRemoteResult(R<T> result, boolean isReturnNull) {
        if (!R.SUCCESS.equals(result.getCode())) {
            log.warn("远程调用返回失败结果:{}", result);
            if (isReturnNull) {
                return null;
            } else {
                throw new ResponseException(result);
            }
        }
        return result.getData();
    }

    /**
     * 根据byte数组，生成文件
     *
     * @param multipartFile 文件数组
     */
    public static File multipartFile2File(MultipartFile multipartFile) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            byte[] bfile = multipartFile.getBytes();
            String type = FileTypeUtil.getType(multipartFile.getInputStream());

            String systemDir = System.getProperty("user.dir");
            systemDir = systemDir + File.separator + "tmp";
            File dir = new File(systemDir);
            if (!dir.exists() && !dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            String fileName = IdUtil.fastSimpleUUID() + '.' + type;
            file = new File(systemDir + File.separator + fileName);
            if (bfile != null) {
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos);
                bos.write(bfile);
            }
        } catch (Exception e) {
            log.error("byte2File error:", e);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                log.error("byte2File error:", e);
            }
        }
        return file;
    }


    public static boolean checkUrl(JSONArray urlWhitelist, String checkUrl) {
        if (urlWhitelist == null) {
            return true;
        }
        return checkUrl(urlWhitelist.toJavaList(String.class), checkUrl);
    }

    /**
     * 检查url是否在白名单中
     *
     * @param urlWhitelist url白名单，支持通配符
     * @param checkUrl     需要检查的url(不包含host部分)
     * @return
     */
    public static boolean checkUrl(List<String> urlWhitelist, String checkUrl) {
        for (String url : urlWhitelist) {
            if (filterUrls(url, checkUrl)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将通配符表达式转化为正则表达式
     *
     * @param path
     * @return
     */
    private static String getRegPath(String path) {
        char[] chars = path.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        boolean preX = false;
        for (int i = 0; i < len; i++) {
            //遇到*字符
            if (chars[i] == '*') {
                //如果是第二次遇到*，则将**替换成.*
                if (preX) {
                    sb.append(".*");
                    preX = false;
                    //如果是遇到单星，且单星是最后一个字符，则直接将*转成[^/]*
                } else if (i + 1 == len) {
                    sb.append("[^/]*");
                    //否则单星后面还有字符，则不做任何动作，下一把再做动作
                } else {
                    preX = true;
                    continue;
                }
                //遇到非*字符
            } else {
                //如果上一把是*，则先把上一把的*对应的[^/]*添进来
                if (preX) {
                    sb.append("[^/]*");
                    preX = false;
                }
                //接着判断当前字符是不是?，是的话替换成.
                if (chars[i] == '?') {
                    sb.append('.');
                    //不是?的话，则就是普通字符，直接添进来
                } else {
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 通配符模式
     *
     * @param excludePath - 不过滤地址
     * @param reqUrl      - 请求地址
     * @return
     */
    private static boolean filterUrls(String excludePath, String reqUrl) {
        String regPath = getRegPath(excludePath);
        return Pattern.compile(regPath).matcher(reqUrl).matches();
    }

    public static String getExceptionMessage(Throwable throwable) {
        if (throwable instanceof BaseException) {
            return ((BaseException) throwable).getDefaultMessage();
        }
        return throwable.getMessage();
    }

    public static String getSceneTypeName(String sceneType) {
        String name = SCENE_TYPE_NAME.get(sceneType);
        if (StringUtils.isNotEmpty(name)) {
            return name;
        }
        return sceneType;
    }

    /**
     * 将HH:mm转换为HH:mm:ss
     */
    public static String timeNormalize(String time) {
        if (time.split(":").length > 3) {
            return time;
        }
        return time + ":" + "00";
    }

    /**
     * 从对象中获取属性的值
     *
     * @param obj       需要获取属性的对象
     * @param fieldName 属性名
     * @return 属性值
     */
    public static <T> T getFieldValue(Object obj, String fieldName) {
        Object fieldValue = ReflectUtil.getFieldValue(obj, fieldName);
        if (fieldValue == null) {
            return null;
        }
        return (T) fieldValue;
    }

    /**
     * 将object中所有为null的clazz初始化为initValue
     *
     * @param object    需要初始化的对象
     * @param clazz     需要初始化的类型
     * @param initValue 需要初始化的值
     */
    public static <T, V extends T> void initObjectType(Object object, Class<T> clazz, V initValue) {
        initObjectType(object, clazz, initValue, new HashSet<>());
    }

    /**
     * 将object中所有为null的clazz初始化为initValue
     *
     * @param object    需要初始化的对象
     * @param clazz     需要初始化的类型
     * @param initValue 需要初始化的值
     * @param exclude   需要排除的字段
     */
    public static <T, V extends T> void initObjectType(Object object, Class<T> clazz, V initValue, String... exclude) {
        initObjectType(object, clazz, initValue, new HashSet<>(Arrays.asList(exclude)));
    }

    private static <T, V extends T> void initObjectType(Object object, Class<T> clazz, V initValue, Set<String> exclude) {
        Map<Class<T>, V> initMap = new HashMap<>();
        initMap.put(clazz, initValue);
        initObjectType(object, initMap, exclude);
    }

    /**
     * 将object中所有为null的clazz初始化为initValue
     *
     * @param object  需要初始化的对象
     * @param initMap 需要类和值得map
     * @param exclude 需要排除的字段
     */
    public static <T, V extends T> void initObjectType(Object object, Map<Class<T>, V> initMap, Set<String> exclude) {
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (exclude.contains(field.getName())) {
                    continue;
                }
                Object initValue = initMap.get(field.getType());
                if (initValue != null) {
                    Object o = field.get(object);
                    if (o == null) {
                        field.set(object, initValue);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new ResponseException(AjaxResult.error(ResponseStatus.SYSTEM_ERROR, e.getMessage()));
            }
        }
    }

    /**
     * 计算两段时间相交的长度
     *
     * @param time1Start 时间段1开始
     * @param time1End   时间段1结束
     * @param time2Start 时间段2开始
     * @param time2End   时间段2结束
     * @return 两段时间相交的长度
     */
    public static long intersection(Date time1Start, Date time1End, Date time2Start, Date time2End) {
        return intersection(time1Start.getTime(), time1End.getTime(), time2Start.getTime(), time2End.getTime());
    }

    /**
     * 计算两段时间相交的长度
     *
     * @param time1Start 时间段1开始
     * @param time1End   时间段1结束
     * @param time2Start 时间段2开始
     * @param time2End   时间段2结束
     * @return 两段时间相交的长度
     */
    public static long intersection(long time1Start, long time1End, long time2Start, long time2End) {
        if (!(time1End >= time2Start && time1Start <= time2End)) {
            return 0;
        }
        // time1 包含 time2
        if (time1Start <= time2Start && time1End >= time2End) {
            return time2End - time2Start;
        }
        // time2Start 在 time1中
        else if (time2Start >= time1Start && time2Start <= time1End) {
            return time1End - time2Start;
        }
        // time2End 在 time1中
        else if (time2End >= time1Start && time2End <= time1End) {
            return time2End - time1Start;
        }
        // time2 包含 time1
        else if (time2Start <= time1Start) {
            return time1End - time1Start;
        }
        return 0;
    }

    /**
     * 小时字符串转毫秒
     *
     * @param time 小时字符串 HH:mm或HH:mm:ss
     * @return 毫秒
     */
    public static long hourToMillis(String time) {
        String[] split = time.split(":");
        if (split.length == 2) {
            return DateUtil.timeToSecond(time + ":00") * 1000L;
        }
        return DateUtil.timeToSecond(time + ":00") * 1000L;
    }
}

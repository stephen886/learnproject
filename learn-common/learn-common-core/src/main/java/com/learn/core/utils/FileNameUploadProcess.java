package com.learn.core.utils;

import cn.hutool.core.io.FileUtil;
import com.learn.core.config.ConfigData;
import com.learn.core.constant.Constants;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @ClassName FileNameUploadProcess
 * @Description 文件上传文件名处理
 * @Author dajie
 * @Date 2021/5/24 4:06 下午
 */

@Component
public class FileNameUploadProcess {

    private static ConfigData configData;

    @PostConstruct
    public void init() {
        configData = SpringUtils.getBean(ConfigData.class);
    }

    public static boolean needEncrypt(String fileName, long size) {
        String extName = FileUtil.extName(fileName);
        final Set<String> encryptTypes = configData.encryptTypes;
        // 文件类型不需要加密
        if (!encryptTypes.contains(extName)) {
            return false;
        }
        // 文件大小大于加密大小
        return configData.encryptSize >= size;
    }

    public static boolean needDecrypt(String fileName) {
        return fileName.endsWith(Constants.ENCRYPT_FILE_NAME_EXT) || fileName.endsWith(Constants.ENCRYPT_FILE_NAME_EXT_CN);
    }

    public static String removeEncSuffix(String fileName) {
        if (fileName.endsWith(Constants.ENCRYPT_FILE_NAME_EXT_CN)) {
            return fileName.replace(Constants.ENCRYPT_FILE_NAME_EXT_CN, "");
        }
        return fileName.replace(Constants.ENCRYPT_FILE_NAME_EXT, "");

    }

    public static String uploadParamsToUrl(String bucket, String date, String fileName) {
        if (StringUtils.isEmpty(date)) {
            return bucket + "/" + fileName;
        }
        return bucket + "/" + date + "/" + fileName;
    }

    public static String getEncryptFileName(long size, String originalFileName) {
        return size + Constants.FILE_NAME_SEPARATOR + originalFileName + CryptoUtil.getCryptoExt();
    }
}

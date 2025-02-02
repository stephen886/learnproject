package com.learn.core.exception.file;
import com.learn.core.exception.BaseException;

/**
 * 文件信息异常类
 * 
 * @author xkiot
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}

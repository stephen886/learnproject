package com.learn.core.web.page;


import com.learn.core.utils.ServletUtils;

import java.util.Optional;

/**
 * 表格数据处理
 * 
 * @author xkiot
 */
public class TableSupport
{
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
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        Integer pageNum = Optional.ofNullable(ServletUtils.getParameterToInt(PAGE_NUM))
                .orElse(ServletUtils.getAttributeToInt(PAGE_NUM));
        pageDomain.setPageNum(pageNum);
        Integer pageSize = Optional.ofNullable(ServletUtils.getParameterToInt(PAGE_SIZE))
                .orElse(ServletUtils.getAttributeToInt(PAGE_SIZE));
        pageDomain.setPageSize(pageSize);
        String orderByColumn = Optional.ofNullable(ServletUtils.getParameter(ORDER_BY_COLUMN))
                .orElse(ServletUtils.getAttribute(ORDER_BY_COLUMN));
        pageDomain.setOrderByColumn(orderByColumn);
        String isAsc = Optional.ofNullable(ServletUtils.getParameter(IS_ASC))
                .orElse(ServletUtils.getAttribute(IS_ASC));
        pageDomain.setIsAsc(isAsc);
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}

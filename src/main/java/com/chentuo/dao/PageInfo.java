package com.chentuo.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class PageInfo {

    public static final Integer DEFAULT_PAGESIZE = 20;
    private List rows = new ArrayList();//当前页记录集
    private Integer pageNum = 1;//当前页码
    private Integer pageSize = DEFAULT_PAGESIZE;//每页记录数
    private Long total = new Long(0);//数据库总条数

    /**
     * 获取记录集
     */
    public List<?> getRows() {
        return rows;
    }

    /**
     * 设置记录集
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    public Integer getFirstResult() {

        if (pageNum == null || pageNum < 1) {

            pageNum = 1;

        }

        if (pageSize == null || pageSize < 1) {

            pageSize = DEFAULT_PAGESIZE;

        }

        return (pageNum - 1) * pageSize;

    }

    /**
     * 设置当前页页码
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取每页记录数
     */
    public Integer getPageSize() {

        if (pageSize == null || pageSize < 1) {

            pageSize = DEFAULT_PAGESIZE;

        }

        return pageSize;
    }

    /**
     * 设置每页记录数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总记录数
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置总记录数
     */
    public void setTotal(Long total) {
        this.total = total;
    }
}

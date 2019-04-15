package com.chentuo.springboot.service;

import com.chentuo.dao.PageInfo;
import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SkuService extends SuperService {

    private String getFromSql() {

        String sql = " SELECT T.*, ( SELECT TRUE_NAME FROM ORG_INFO WHERE PID = T.CREATE_USER_ID ) AS CREATE_USER_NAME , DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d %k:%i') AS CREATE_TIME_STR, DATE_FORMAT(T.LAST_UP_TIME, '%Y-%m-%d %k:%i') AS LAST_UP_TIME_STR  FROM SKU_INFO T WHERE T.STATUS = '"
                + TABLE_STATUS_VALID + "' ";

        return sql;

    }

    public PageInfo getPage(String pid, Integer pageNumber, String searchValue, Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {

        String sql = getFromSql() + " AND T.COM_PID = '" + pid + "' ";

        if (StringUtils.isNotBlank(searchValue)) {
            sql = sql + " and (T.PNAME like '%" + searchValue + "%' or T.PCODE like '%" + searchValue + "%') ";
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = PageInfo.DEFAULT_PAGESIZE;
        }

        if (StringUtils.isBlank(sortName)) {
            sortName = "CREATE_TIME";
        }

        if(StringUtils.isBlank(sortOrder)) {
            sortOrder = "DESC";
        }

        return pagingAndSortingJdbcTemplate.getPage(sql, pageNumber, pageSize, sortName, sortOrder);
    }
}


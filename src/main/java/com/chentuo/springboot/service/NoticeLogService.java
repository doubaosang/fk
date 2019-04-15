package com.chentuo.springboot.service;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.NoticeLogInfo;
import com.chentuo.springboot.repository.NoticeLogRepo;
import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jian198001
 */
@Service
public class NoticeLogService extends SuperService {

    @Autowired
    private NoticeLogRepo noticeLogRepo = null;

    private String getFromSql() {

        String sql = " SELECT T.*, ( SELECT USERNAME FROM USER_INFO WHERE PID = T.CREATE_USER_ID ) AS CREATE_USER_NAME , DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d %k:%i') AS CREATE_TIME_STR, DATE_FORMAT(T.LAST_UP_TIME, '%Y-%m-%d %k:%i') AS LAST_UP_TIME_STR  FROM NOTICE_LOG_INFO T WHERE T.STATUS = '"
                + TABLE_STATUS_VALID + "' ";

        return sql;

    }

    public PageInfo getPage(String noticeId, Integer pageNumber, String searchValue, Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {

        String sql = getFromSql() + " AND T.NOTICE_ID = '" + noticeId + "' ";

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

    public String save(NoticeLogInfo noticeLogInfo) {

        noticeLogInfo.setCreateTime(new Date());

        noticeLogInfo.setLastUpTime(new Date());

        noticeLogInfo.setStatus("1");

        noticeLogRepo.save(noticeLogInfo);

        return noticeLogInfo.getPid();

    }

    public String update(NoticeLogInfo noticeLogInfo) {

        noticeLogInfo.setLastUpTime(new Date());

        noticeLogInfo.setStatus("1");

        noticeLogRepo.save(noticeLogInfo);

        return noticeLogInfo.getPid();

    }

    public String delete(NoticeLogInfo noticeLogInfo) {

        noticeLogInfo.setLastUpTime(new Date());

        noticeLogInfo.setStatus("0");

        noticeLogRepo.save(noticeLogInfo);

        return noticeLogInfo.getPid();

    }

    public String delete(String pid) {

        NoticeLogInfo noticeLogInfo = noticeLogRepo.getOne(pid);

        return delete(noticeLogInfo);

    }

}

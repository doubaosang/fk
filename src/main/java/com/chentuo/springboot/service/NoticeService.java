package com.chentuo.springboot.service;

import com.chentuo.dao.PageInfo;
import com.chentuo.model.NoticeInfo;
import com.chentuo.springboot.repository.NoticeRepo;
import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@Service
public class NoticeService extends SuperService {
    @Autowired
    private NoticeRepo noticeRepo = null;

    private String getFromSql(String userId) {

        String sql = " SELECT T.*, ( SELECT COUNT(0) AS COUNT_USER FROM NOTICE_LOG_INFO WHERE NOTICE_ID = T.PID AND STATUS = '"
                + SuperService.TABLE_STATUS_VALID
                + "' ) AS COUNT_USER , ( SELECT USERNAME FROM ORG_INFO WHERE PID = T.CREATE_USER_ID ) AS CREATE_USER_NAME , DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d %k:%i') AS CREATE_TIME_STR, DATE_FORMAT(T.LAST_UP_TIME, '%Y-%m-%d %k:%i') AS LAST_UP_TIME_STR, ( SELECT COUNT(0) FROM NOTICE_LOG_INFO WHERE CREATE_USER_ID = '" + userId + "' AND NOTICE_ID = T.PID ) AS USER_LOG FROM NOTICE_INFO T WHERE T.STATUS = '"
                + TABLE_STATUS_VALID + "' ";

        System.out.println(sql);

        return sql;

    }

    public PageInfo getPage(String userId, Integer pageNumber, String searchValue,
                            Integer pageSize, String sortName, String sortOrder, String startDate, String endDate) {

        String sql = getFromSql(userId);

        if (StringUtils.isNotBlank(searchValue)) {

            sql = sql + " and (T.PNAME like '%" + searchValue
                    + "%' or T.PCODE like '%" + searchValue
                    + "%' OR T.TITLE LIKE '%" + searchValue + "%' ) ";

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

        return pagingAndSortingJdbcTemplate.getPage(sql, pageNumber, pageSize, sortName,
                sortOrder);

    }

    public String save(NoticeInfo noticeInfo) {

        noticeInfo.setCreateTime(new Date());

        noticeInfo.setLastUpTime(new Date());

        noticeInfo.setStatus("1");

        noticeRepo.save(noticeInfo);

        return noticeInfo.getPid();

    }

    public String update(NoticeInfo noticeInfo) {

        noticeInfo.setLastUpTime(new Date());

        noticeInfo.setStatus("1");

        noticeRepo.save(noticeInfo);

        return noticeInfo.getPid();

    }

    public String delete(NoticeInfo noticeInfo) {

        noticeInfo.setLastUpTime(new Date());

        noticeInfo.setStatus("0");

        noticeRepo.save(noticeInfo);

        return noticeInfo.getPid();

    }

    public String delete(String pid) {

        NoticeInfo noticeInfo = noticeRepo.getOne(pid);

        return delete(noticeInfo);

    }

    @Override
    public Map<String, Object> getMapOne(String pid, String userId) {

        String sql = getFromSql(userId) + " AND T.PID = '"
                + pid + "' ";

        return jdbcTemplate.queryForMap(sql);

    }
}

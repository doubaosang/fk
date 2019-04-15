package com.chentuo.dao;

import com.chentuo.dao.dialect.JdbcDialect;
import com.chentuo.dao.dialect.JdbcMySqlDialect;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PagingAndSortingJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    private JdbcDialect jdbcDialect = null;

    public JdbcDialect getJdbcDialect() {
        return jdbcDialect;
    }

    public void setJdbcDialect(JdbcDialect jdbcDialect) {
        this.jdbcDialect = jdbcDialect;
    }

    // 添加分页查询
    public PageInfo getPage(String sql, Integer pageNum, Integer pageSize, String sortName, String sortOrder) {

        PageInfo pageInfo = new PageInfo();

        String sqlCount = " SELECT COUNT(0) AS COUNT_0 FROM ( " + sql + " ) COUNT_ROW ";

        Map<String, Object> map = jdbcTemplate.queryForMap(sqlCount);

        Long count = (Long) map.get("COUNT_0");

        pageInfo.setTotal(count);

        pageInfo.setPageNum(pageNum);

        if (pageSize != null) {
            pageInfo.setPageSize(pageSize);
        }

        Integer firstResult = pageInfo.getFirstResult();

        Integer maxResults = firstResult + pageInfo.getPageSize();

        if (StringUtils.isBlank(sortName)) {

            sortName = "CREATE_TIME";

        }

        if(StringUtils.isBlank(sortOrder)) {

            sortOrder = "DESC";

        }

        List list = queryForPage(sql, firstResult, maxResults, sortName,
                sortOrder);

        pageInfo.setRows(list);

        return pageInfo;

    }

    private List queryForPage(String sql, Integer firstResult,
                              Integer maxResults, String sortName, String sortOrder) {

        jdbcDialect = new JdbcMySqlDialect();

        List<Map<String, Object>> list = jdbcTemplate.queryForList(jdbcDialect.getLimitString(sql, firstResult, maxResults, sortName, sortOrder));

        return list;

    }

}

package com.chentuo.superClass;

import com.chentuo.dao.PageInfo;
import com.chentuo.dao.PagingAndSortingJdbcTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract class SuperService {

    public final static String TABLE_STATUS_VALID = "1";

    @Autowired
    protected JdbcTemplate jdbcTemplate = null;

    @Autowired
    protected PagingAndSortingJdbcTemplate pagingAndSortingJdbcTemplate = null;

    private JpaRepository jpaRepository = null;

    /**
     * @return the pagingAndSortingJdbcTemplate
     */
    public PagingAndSortingJdbcTemplate getPagingAndSortingJdbcTemplate() {
        return pagingAndSortingJdbcTemplate;
    }

    /**
     * @param pagingAndSortingJdbcTemplate the pagingAndSortingJdbcTemplate to set
     */
    public void setPagingAndSortingJdbcTemplate(PagingAndSortingJdbcTemplate pagingAndSortingJdbcTemplate) {
        this.pagingAndSortingJdbcTemplate = pagingAndSortingJdbcTemplate;
    }

    public Map<String, Object> getMapOne(String tableName, String pid) {

        String sql = " SELECT T.* FROM " + tableName + " T WHERE T.PID = '"
                + pid + "' ";

        return jdbcTemplate.queryForMap(sql);

    }

    public Map<String, Object> getUsernameOne(String tableName, String username) {

        String sql = " SELECT T.* FROM " + tableName + " T WHERE T.USERNAME = '"
                + username + "' ";
        Map<String, Object> map = null;

        try{
            map = jdbcTemplate.queryForMap(sql);

        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return map;

    }

    public Map<String, Object> getPasswordOne(String tableName, String password, String pid) {

        String sql = " SELECT T.* FROM " + tableName + " T WHERE T.PASSWORD = '" + password + "' and T.PID = '" + pid + "'";
        Map<String, Object> map = null;

        try{
            map = jdbcTemplate.queryForMap(sql);

        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return map;

    }

    public PageInfo getPage(String tableName, Integer pageNumber,
                            String searchValue, Integer pageSize, String sortName,
                            String sortOrder) {

        String sql = " SELECT T.*, DATE_FORMAT(CREATE_TIME, '%Y-%m-%d %k:%i') AS CREATE_TIME_STR, DATE_FORMAT(LAST_UP_TIME, '%Y-%m-%d %k:%i') AS LAST_UP_TIME_STR FROM " + tableName + " T WHERE T.STATUS = '"
                + TABLE_STATUS_VALID + "' ";

        if (StringUtils.isNotBlank(searchValue)) {

            sql = sql + " and (T.PNAME like '%" + searchValue
                    + "%' or T.PCODE like '%" + searchValue + "%') ";

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

    public List<Map<String, Object>> getList(String tableName) {

        String sql = " SELECT T.* FROM " + tableName + " T WHERE T.STATUS = '"
                + TABLE_STATUS_VALID
                + "' ORDER BY T.ORDER_NUM ";

        return jdbcTemplate.queryForList(sql);

    }

    public void sortOrderNew(String tableName, String pid, String prevId,
                             String nextId) {

        Integer orderNum = sortOrder(tableName, pid, prevId, nextId);

        if (orderNum < 32) {

            sortOrder(tableName);

        }

    }

    public Integer sortOrder(String tableName, String pid, String prevId,
                             String nextId) {

        if ((StringUtils.isBlank(prevId) || StringUtils.equals(prevId, "null") || StringUtils
                .equals(prevId, "undefined"))
                && (StringUtils.isBlank(nextId)
                || StringUtils.equals(nextId, "null") || StringUtils
                .equals(nextId, "undefined"))) {

            // 新增数据

            String sql = " SELECT COUNT(0) AS COUNT_0 FROM " + tableName + " T WHERE T.ORDER_NUM IS NOT NULL ";

            Map<String, Object> map = jdbcTemplate.queryForMap(sql);

            Integer count = (Integer) map.get("COUNT_0");

            if (count < 2) {

                String sqlUpdate = " UPDATE " + tableName
                        + " SET ORDER_NUM = 1073741823 WHERE PID = '" + pid
                        + "' ";

                jdbcTemplate.update(sqlUpdate);

                return 1073741823;

            } else {

                String sqlMinOrderNum = " SELECT MIN(T.ORDER_NUM) AS ORDER_NUM_MIN FROM "
                        + tableName + " T ";

                Integer orderNumPrev = 0;

                Map<String, Object> mapNext = jdbcTemplate.queryForMap(sqlMinOrderNum);

                Integer orderNumNext = (Integer) mapNext.get("ORDER_NUM_MIN");

                Integer orderNum = null;

                Integer orderNumSubtract = (orderNumNext - orderNumPrev);

                if (orderNumSubtract < 1) {

                    orderNumSubtract = (orderNumPrev - orderNumNext);

                    BigDecimal orderNumSubtractDec = new BigDecimal(
                            orderNumSubtract).divide(new BigDecimal(2), 0,
                            BigDecimal.ROUND_DOWN);

                    orderNum = orderNumNext + orderNumSubtractDec.intValue();

                } else {

                    BigDecimal orderNumSubtractDec = new BigDecimal(
                            orderNumSubtract).divide(new BigDecimal(2), 0,
                            BigDecimal.ROUND_DOWN);

                    orderNum = orderNumPrev + orderNumSubtractDec.intValue();

                }

                String sqlUpdate = " UPDATE " + tableName
                        + " SET ORDER_NUM = " + orderNum + " WHERE PID = '"
                        + pid + "' ";

                jdbcTemplate.update(sqlUpdate);

                return orderNum;

            }

        }

        if (StringUtils.isBlank(prevId) || StringUtils.equals(prevId, "null")
                || StringUtils.equals(prevId, "undefined")) {

            String sqlPrev = " SELECT MAX(ORDER_NUM) AS ORDER_NUM_MAX FROM " + tableName
                    + " T WHERE T.ORDER_NUM < ( SELECT ORDER_NUM FROM "
                    + tableName + " WHERE PID = '" + nextId + "' ) ";

            String sqlNext = " SELECT T.ORDER_NUM FROM " + tableName
                    + " T WHERE T.PID = '" + nextId + "' ";

            Map<String, Object> mapPrev = jdbcTemplate.queryForMap(sqlPrev);

            Integer orderNumPrev = (Integer) mapPrev.get("ORDER_NUM_MAX");

            if (orderNumPrev == null || orderNumPrev < 1) {

                orderNumPrev = 0;

            }

            Map<String, Object> mapNext = jdbcTemplate.queryForMap(sqlNext);

            Integer orderNumNext = (Integer) mapNext.get("ORDER_NUM");

            Integer orderNum = null;

            Integer orderNumSubtract = (orderNumNext - orderNumPrev);

            if (orderNumSubtract < 1) {

                orderNumSubtract = (orderNumPrev - orderNumNext);

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumNext + orderNumSubtractDec.intValue();

            } else {

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumPrev + orderNumSubtractDec.intValue();

            }

            String sqlUpdate = " UPDATE  " + tableName + " SET ORDER_NUM = "
                    + orderNum + " WHERE PID = '" + pid + "' ";

            jdbcTemplate.update(sqlUpdate);

            return orderNum;

        } else if (StringUtils.isBlank(nextId)
                || StringUtils.equals(nextId, "null")
                || StringUtils.equals(nextId, "undefined")) {

            String sqlPrev = " SELECT T.ORDER_NUM FROM " + tableName
                    + " T WHERE T.PID = '" + prevId + "' ";

            String sqlNext = " SELECT MIN(ORDER_NUM) AS ORDER_NUM_MIN FROM " + tableName
                    + " T WHERE T.ORDER_NUM > ( SELECT ORDER_NUM FROM "
                    + tableName + " WHERE PID = '" + prevId + "' ) ";

            Map<String, Object> mapPrev = jdbcTemplate.queryForMap(sqlPrev);

            Integer orderNumPrev = (Integer) mapPrev.get("ORDER_NUM");

            Map<String, Object> mapNext = jdbcTemplate.queryForMap(sqlNext);

            Integer orderNumNext = (Integer) mapNext.get("ORDER_NUM_MIN");

            if (orderNumNext == null || orderNumNext > 2147483646
                    || orderNumNext < 1) {

                orderNumNext = 2147483640;

            }

            Integer orderNum = null;

            Integer orderNumSubtract = (orderNumNext - orderNumPrev);

            if (orderNumSubtract < 1) {

                orderNumSubtract = (orderNumPrev - orderNumNext);

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumNext + orderNumSubtractDec.intValue();

            } else {

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumPrev + orderNumSubtractDec.intValue();

            }

            String sqlUpdate = " UPDATE " + tableName + " SET ORDER_NUM = "
                    + orderNum + " WHERE PID = '" + pid + "' ";

            jdbcTemplate.update(sqlUpdate);

            return orderNum;

        } else {

            String sqlPrev = " SELECT T.ORDER_NUM FROM " + tableName
                    + " T WHERE T.PID = '" + prevId + "' ";

            String sqlNext = " SELECT T.ORDER_NUM FROM " + tableName
                    + " T WHERE T.PID = '" + nextId + "' ";

            Map<String, Object> mapPrev = jdbcTemplate.queryForMap(sqlPrev);

            Integer orderNumPrev = (Integer) mapPrev.get("ORDER_NUM");

            Map<String, Object> mapNext = jdbcTemplate.queryForMap(sqlNext);

            Integer orderNumNext = (Integer) mapNext.get("ORDER_NUM");

            Integer orderNum = null;

            Integer orderNumSubtract = (orderNumNext - orderNumPrev);

            if (orderNumSubtract < 1) {

                orderNumSubtract = (orderNumPrev - orderNumNext);

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumNext + orderNumSubtractDec.intValue();

            } else {

                BigDecimal orderNumSubtractDec = new BigDecimal(
                        orderNumSubtract).divide(new BigDecimal(2), 0,
                        BigDecimal.ROUND_DOWN);

                orderNum = orderNumPrev + orderNumSubtractDec.intValue();

            }

            String sqlUpdate = " UPDATE " + tableName + " SET ORDER_NUM = "
                    + orderNum + " WHERE PID = '" + pid + "' ";

            jdbcTemplate.update(sqlUpdate);

            return orderNum;

        }

    }

    public Integer unique(String tableName, String columnName,
                          String columnValue) {

        return unique(tableName, columnName, columnValue, null);

    }

    public Integer unique(String tableName, String columnName,
                          String columnValue, String pid) {

        String sql = " SELECT COUNT(0) AS COUNT_0 FROM " + tableName
                + " T WHERE T.STATUS = '" + SuperService.TABLE_STATUS_VALID
                + "' AND T." + columnName + " = '" + columnValue + "' ";

        if (StringUtils.isNotBlank(pid)) {

            sql = sql + " AND T.PID != '" + pid + "' ";

        }

        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        Integer count = (Integer) map.get("COUNT_0");

        return count;

    }

    public void sortOrder(String tableName) {

        String sql = " SELECT COUNT(0) AS COUNT_0 FROM " + tableName + " T ";

        Map<String, Object> mapCount = jdbcTemplate.queryForMap(sql);

        Integer count = (Integer) mapCount.get("COUNT_0");

        String sqlOrder = " SELECT T.PID FROM " + tableName
                + " T ORDER BY T.ORDER_NUM ";

        List<Map<String, Object>> list = jdbcTemplate
                .queryForList(sqlOrder);

        if (list == null || list.isEmpty()) {

            return;

        }

        BigDecimal bigDecimal = new BigDecimal(1073741823).divide(
                new BigDecimal(count), 0, BigDecimal.ROUND_DOWN);

        Integer orderNum = bigDecimal.intValue();

        Integer orderNumStep = orderNum;

        orderNum = orderNum + 65536;

        for (Map<String, Object> map : list) {

            String sqlUpdate = " UPDATE " + tableName + " SET ORDER_NUM = "
                    + orderNum + " WHERE PID = '" + map.get("PID") + "' ";

            jdbcTemplate.update(sqlUpdate);

            orderNum = orderNum + orderNumStep;

        }

    }

    public String save(SuperModel superModel, String tableName) {

        return null;

    }

    public String update(SuperModel superModel) {

        return null;

    }

}

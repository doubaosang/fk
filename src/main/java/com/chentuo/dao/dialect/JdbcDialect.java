package com.chentuo.dao.dialect;

public interface JdbcDialect {
    /**
     *
     * @param sql
     * @param firstResult:limit start
     * @param maxResults:limit end
     * @param sortName:排序字段
     * @param sortOrder:排序规则
     * @return
     */
    public String getLimitString(String sql, Integer firstResult, Integer maxResults, String sortName, String sortOrder);

}

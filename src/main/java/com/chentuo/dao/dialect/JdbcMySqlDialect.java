package com.chentuo.dao.dialect;

import org.apache.commons.lang3.StringUtils;

public class JdbcMySqlDialect implements JdbcDialect {

    @Override
    public String getLimitString(String sql, Integer firstRow, Integer lastRow,
                                 String sortName, String sortOrder) {

        StringBuffer sb = new StringBuffer(sql);

        if (StringUtils.isNotBlank(sortName)) {

            if (StringUtils.isNotBlank(sortOrder) && StringUtils.equalsAnyIgnoreCase(sortOrder, "desc")) {

                sb.append(" ORDER BY " + sortName + " DESC ");

            } else {

                sb.append(" ORDER BY " + sortName + " ");

            }

        }

        sb.append(" LIMIT " + firstRow + ", " + lastRow + " ");

        return sb.toString();

    }

}

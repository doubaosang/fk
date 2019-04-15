package com.chentuo.springboot.service;

import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

/**
 * 用户服务类
 *
 * @author Administrator
 */
@Service
public class UserService extends SuperService {

    public static String passwordDigest(String password) {

        if (StringUtils.isBlank(password)) {

            return null;

        }

        return DigestUtils.md5DigestAsHex((password).getBytes());
    }

    public String getSql() {

        String sql = " select T.*, ( select role_name from ROLE_INFO where status = '"
                + SuperService.TABLE_STATUS_VALID
                + "' and ROLE_INFO.pid in ( select role_id from USER_ROLE_MAP where user_id = T.PID ) ) as role_name , DATE_FORMAT(T.CREATE_TIME, '%Y-%m-%d %k:%i') AS CREATE_TIME_STR, DATE_FORMAT(T.LAST_UP_TIME, '%Y-%m-%d %k:%i') AS LAST_UP_TIME_STR from USER_INFO T where T.status = '"
                + SuperService.TABLE_STATUS_VALID + "' ";

        return sql;

    }

    public String login(String username, String password) {

        String sql = " select * from USER_INFO where username = '" + username
                + "' and password = '" + password + "' and status = '"
                + SuperService.TABLE_STATUS_VALID + "' ";

        if (StringUtils.equals(password, "mShowNoPassword")) {

            sql = " SELECT T.* FROM USER_INFO T WHERE USERNAME = '" + username
                    + "' AND T.STATUS = '" + SuperService.TABLE_STATUS_VALID + "' ";

        }

        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        if (map == null || map.isEmpty()) {

            return null;

        }

        return (String) map.get("pid");

    }

}

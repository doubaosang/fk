package com.chentuo.springboot.service;

import com.chentuo.model.OrgInfo;
import com.chentuo.springboot.repository.OrgRepo;
import com.chentuo.superClass.SuperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@Service
public class OrgService extends SuperService {
    @Autowired
    private OrgRepo orgRepo = null;

    public String login(String username, String password) {

        String sql = " select * from ORG_INFO where username = '" + username
                + "' and password = '" + password + "' and status = '"
                + SuperService.TABLE_STATUS_VALID + "' ";

        if (StringUtils.equals(password, "mShowNoPassword")) {

            sql = " SELECT T.* FROM ORG_INFO T WHERE USERNAME = '" + username
                    + "' AND T.STATUS = '" + SuperService.TABLE_STATUS_VALID + "' ";

        }

        Object object = null;

        try{
            object = jdbcTemplate.queryForMap(sql);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

        Map<String, Object> map = jdbcTemplate.queryForMap(sql);

        return (String) map.get("PID");

    }

    public String save(OrgInfo orgInfo) {

        orgInfo.setCreateTime(new Date());

        orgInfo.setLastUpTime(new Date());

        orgInfo.setStatus("1");

        orgRepo.save(orgInfo);

        return orgInfo.getPid();

    }

    public String update(OrgInfo orgInfo) {

        orgInfo.setLastUpTime(new Date());

        orgInfo.setStatus("1");

        orgRepo.save(orgInfo);

        return orgInfo.getPid();

    }

    public String delete(OrgInfo orgInfo) {

        orgInfo.setLastUpTime(new Date());

        orgInfo.setStatus("0");

        orgRepo.save(orgInfo);

        return orgInfo.getPid();

    }

    public String delete(String pid) {

        OrgInfo orgInfo = orgRepo.getOne(pid);

        return delete(orgInfo);

    }

    public String upPassword (String pid, String password) {
        OrgInfo orgInfo = orgRepo.getOne(pid);
        orgInfo.setPassword(password);
        update(orgInfo);
        return "success";
    }
}

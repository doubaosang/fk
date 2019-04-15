package com.chentuo.util;

import com.chentuo.model.OrgInfo;
import java.util.Date;
import java.util.Map;

public class MapToBean {
    public static OrgInfo mapToBean (Map<String, Object> map) {
        OrgInfo orgInfo = new OrgInfo();
        orgInfo.setPid((String) map.get("PID"));
        orgInfo.setUsername((String) map.get("USERNAME"));
        orgInfo.setPassword((String) map.get("PASSWORD"));
        orgInfo.setTrueName((String) map.get("TRUE_NAME"));
        orgInfo.setTrueNamePinyin((String) map.get("TRUE_NAME_PINYIN"));
        orgInfo.setCreateTime((Date) map.get("CREATE_TIME"));
        orgInfo.setCreateUserId((String) map.get("CREATE_USER_ID"));
        orgInfo.setLastUpTime((Date) map.get("LAST_UP_TIME"));
        orgInfo.setStatus((String) map.get("STATUS"));
        orgInfo.setDescriptions((String) map.get("DESCRIPTIONS"));
        orgInfo.setOrderNum((Integer) map.get("ORDER_NUM"));
        orgInfo.setPcode((String) map.get("PIC"));
        orgInfo.setPcode((String) map.get("PCODE"));
        orgInfo.setPname((String) map.get("PNAME"));
        return orgInfo;
    }
}

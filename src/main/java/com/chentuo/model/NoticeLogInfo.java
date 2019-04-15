package com.chentuo.model;

import com.chentuo.superClass.SuperModel;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
@Entity
@Table(name = "NOTICE_LOG_INFO")
public class NoticeLogInfo extends SuperModel {
    private String noticeId = null; /* 通知公告 */
    private String userId = null; /* 阅读过的用户 */
    private String userType = null; /* 阅读过的用户 */

    @Column(name = "USER_TYPE")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Column(name = "NOTICE_ID")
    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    } /* property_code */

    /**
     * @return the createTime
     */
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the createUserId
     */
    @Column(name = "CREATE_USER_ID")
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return the descriptions
     */
    @Column(name = "DESCRIPTIONS")
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * @return the lastUpTime
     */
    @Column(name = "LAST_UP_TIME")
    public Date getLastUpTime() {
        return lastUpTime;
    }

    /**
     * @param lastUpTime the lastUpTime to set
     */
    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    /**
     * @return the orderNum
     */
    @Column(name = "ORDER_NUM")
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum the orderNum to set
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return the pcode
     */
    @Column(name = "PCODE")
    public String getPcode() {
        return pcode;
    }

    /**
     * @param pcode the pcode to set
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * @return the pid
     */
    @Column(name = "PID")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the pname
     */
    @Column(name = "PNAME")
    public String getPname() {
        return pname;
    }

    /**
     * @param pname the pname to set
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return the status
     */
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

package com.chentuo.model;

import com.chentuo.superClass.SuperModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@Entity
@Table(name = "COM_INFO")
public class ComInfo extends SuperModel {
    private String comName = null;
    private String brandPid = null;
    private String brandName = null;
    private String sortPid = null;
    private String sortName = null;
    private Integer count = null;
    private String pic = null;
    private double weight = 0;
    private BigDecimal prime = null;
    private String color = null;
    private String screen = null;
    private String cpu = null;

    @Column(name = "PID")
    @Id
    @GeneratedValue(generator = "uuid")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    @Column(name = "COM_NAME")
    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
    @Column(name = "BRAND_PID")
    public String getBrandPid() {
        return brandPid;
    }

    public void setBrandPid(String brandPid) {
        this.brandPid = brandPid;
    }
    @Column(name = "BRAND_NAME")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    @Column(name = "SORT_PID")
    public String getSortPid() {
        return sortPid;
    }

    public void setSortPid(String sortPid) {
        this.sortPid = sortPid;
    }
    @Column(name = "SORT_NAME")
    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
    @Column(name = "COUNT")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "PIC")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    @Column(name = "WEIGHT")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Column(name = "PRIME")
    public BigDecimal getPrime() {
        return prime;
    }

    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }
    @Column(name = "COLOR")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Column(name = "SCREEN")
    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
    @Column(name = "CPU")
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "CREATE_USER_ID")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    @Column(name = "LAST_UP_TIME")
    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "DESCRIPTIONS")
    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    @Column(name = "ORDER_NUM")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    @Column(name = "PCODE")
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    @Column(name = "PNAME")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}

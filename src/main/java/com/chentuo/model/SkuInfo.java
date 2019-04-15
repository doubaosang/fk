package com.chentuo.model;

import com.chentuo.superClass.SuperModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@Entity
@Table(name = "SKU_INFO")
public class SkuInfo extends SuperModel {
    private String skuName = null;
    private String comPid = null;//商品PID
    private String color = null;
    private String secreen = null;
    private String cpu = null;
    private BigDecimal prime = null;//进货价
    private BigDecimal sellprime = null;//售货价
    private String sncode = null;//条形码
    private Integer stock = null;//库存
    private Integer sastock = null;//安全库存
    private Integer limi = null;//购买限制

    @Column(name = "PID")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    @Column(name = "SKU_NAME")
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    @Column(name = "COM_PID")
    public String getComPid() {
        return comPid;
    }

    public void setComPid(String comPid) {
        this.comPid = comPid;
    }
    @Column(name = "COLOR")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Column(name = "SECREEN")
    public String getSecreen() {
        return secreen;
    }

    public void setSecreen(String secreen) {
        this.secreen = secreen;
    }
    @Column(name = "CPU")
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    @Column(name = "PRIME")
    public BigDecimal getPrime() {
        return prime;
    }

    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }
    @Column(name = "SELL_PRIME")
    public BigDecimal getSellprime() {
        return sellprime;
    }

    public void setSellprime(BigDecimal sellprime) {
        this.sellprime = sellprime;
    }
    @Column(name = "SN_CODE")
    public String getSncode() {
        return sncode;
    }

    public void setSncode(String sncode) {
        this.sncode = sncode;
    }
    @Column(name = "STOCK")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    @Column(name = "SA_STOCK")
    public Integer getSastock() {
        return sastock;
    }

    public void setSastock(Integer sastock) {
        this.sastock = sastock;
    }
    @Column(name = "LIMI")
    public Integer getLimi() {
        return limi;
    }

    public void setLimi(Integer limi) {
        this.limi = limi;
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

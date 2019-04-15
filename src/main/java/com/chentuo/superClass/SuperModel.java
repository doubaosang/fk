package com.chentuo.superClass;

import java.io.Serializable;
import java.util.Date;
/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
public class SuperModel implements Serializable {
    protected String pid = null;//主键
    protected Date createTime = null;//创建时间
    protected String createUserId = null;//创建人ID
    protected Date lastUpTime = null;//修改时间
    protected String status = null;//是否可见 0：不可见 1：可见
    protected String descriptions = null;//描述
    protected Integer orderNum = null;
    protected String pcode = null;
    protected String pname = null;
}

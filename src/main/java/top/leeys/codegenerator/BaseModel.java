package top.leeys.codegenerator;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DELETED = 1;
    public static final int NOT_DELETED = 0;

    protected Integer id;
    protected Date createTime;
    protected Date updateTime;
    protected Integer status;

    public BaseModel() {
        status = NOT_DELETED; // 删除字段初始化为不删除
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

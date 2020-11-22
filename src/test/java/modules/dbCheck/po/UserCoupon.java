package modules.dbCheck.po;

import java.util.Date;

public class UserCoupon {
    private Integer id;

    private Integer userId;

    private Integer couponId;

    private Byte status;

    private Date createTime;

    private Integer orderId;

    private Date updateTime;

    @Override
    public String toString() {
        return "UserCoupon{" +
                "id=" + id +
                ", userId=" + userId +
                ", couponId=" + couponId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", orderId=" + orderId +
                ", updateTime=" + updateTime +
                '}';
    }

    public UserCoupon(Integer id, Integer userId, Integer couponId, Byte status, Date createTime, Integer orderId, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.couponId = couponId;
        this.status = status;
        this.createTime = createTime;
        this.orderId = orderId;
        this.updateTime = updateTime;
    }

    public UserCoupon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
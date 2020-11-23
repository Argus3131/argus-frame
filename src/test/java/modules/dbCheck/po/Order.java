package modules.dbCheck.po;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String orderNo;

    private Integer userId;

    private BigDecimal totalPrice;

    private Integer totalCount;

    private Date createTime;

    private Date deleteTime;

    private Date updateTime;

    private String snapImg;

    private String snapTitle;

    private String snapItems;

    private String snapAddress;

    private String prepayId;

    private BigDecimal finalTotalPrice;

    private Byte status;

    private Date expiredTime;

    private Date placedTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", totalCount=" + totalCount +
                ", createTime=" + createTime +
                ", deleteTime=" + deleteTime +
                ", updateTime=" + updateTime +
                ", snapImg='" + snapImg + '\'' +
                ", snapTitle='" + snapTitle + '\'' +
                ", snapItems='" + snapItems + '\'' +
                ", snapAddress='" + snapAddress + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", finalTotalPrice=" + finalTotalPrice +
                ", status=" + status +
                ", expiredTime=" + expiredTime +
                ", placedTime=" + placedTime +
                '}';
    }

    public Order(Integer id, String orderNo, Integer userId, BigDecimal totalPrice, Integer totalCount, Date createTime, Date deleteTime, Date updateTime, String snapImg, String snapTitle, String snapItems, String snapAddress, String prepayId, BigDecimal finalTotalPrice, Byte status, Date expiredTime, Date placedTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalCount = totalCount;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.updateTime = updateTime;
        this.snapImg = snapImg;
        this.snapTitle = snapTitle;
        this.snapItems = snapItems;
        this.snapAddress = snapAddress;
        this.prepayId = prepayId;
        this.finalTotalPrice = finalTotalPrice;
        this.status = status;
        this.expiredTime = expiredTime;
        this.placedTime = placedTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSnapImg() {
        return snapImg;
    }

    public void setSnapImg(String snapImg) {
        this.snapImg = snapImg == null ? null : snapImg.trim();
    }

    public String getSnapTitle() {
        return snapTitle;
    }

    public void setSnapTitle(String snapTitle) {
        this.snapTitle = snapTitle == null ? null : snapTitle.trim();
    }

    public String getSnapItems() {
        return snapItems;
    }

    public void setSnapItems(String snapItems) {
        this.snapItems = snapItems == null ? null : snapItems.trim();
    }

    public String getSnapAddress() {
        return snapAddress;
    }

    public void setSnapAddress(String snapAddress) {
        this.snapAddress = snapAddress == null ? null : snapAddress.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public BigDecimal getFinalTotalPrice() {
        return finalTotalPrice;
    }

    public void setFinalTotalPrice(BigDecimal finalTotalPrice) {
        this.finalTotalPrice = finalTotalPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Date getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(Date placedTime) {
        this.placedTime = placedTime;
    }

}
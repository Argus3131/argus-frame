package modules.dbCheck.po;

import java.math.BigDecimal;
import java.util.Date;

public class Coupon {
    private Integer id;

    private String title;

    private Date startTime;

    private Date endTime;

    private String description;

    private BigDecimal fullMoney;

    private BigDecimal minus;

    private BigDecimal rate;

    private Short type;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Integer valitiy;

    private Integer activityId;

    private String remark;

    private Byte wholeStore;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", fullMoney=" + fullMoney +
                ", minus=" + minus +
                ", rate=" + rate +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", valitiy=" + valitiy +
                ", activityId=" + activityId +
                ", remark='" + remark + '\'' +
                ", wholeStore=" + wholeStore +
                '}';
    }

    public Coupon(Integer id, String title, Date startTime, Date endTime, String description, BigDecimal fullMoney, BigDecimal minus, BigDecimal rate, Short type, Date createTime, Date updateTime, Date deleteTime, Integer valitiy, Integer activityId, String remark, Byte wholeStore) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.fullMoney = fullMoney;
        this.minus = minus;
        this.rate = rate;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.valitiy = valitiy;
        this.activityId = activityId;
        this.remark = remark;
        this.wholeStore = wholeStore;
    }

    public Coupon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(BigDecimal fullMoney) {
        this.fullMoney = fullMoney;
    }

    public BigDecimal getMinus() {
        return minus;
    }

    public void setMinus(BigDecimal minus) {
        this.minus = minus;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getValitiy() {
        return valitiy;
    }

    public void setValitiy(Integer valitiy) {
        this.valitiy = valitiy;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getWholeStore() {
        return wholeStore;
    }

    public void setWholeStore(Byte wholeStore) {
        this.wholeStore = wholeStore;
    }
}
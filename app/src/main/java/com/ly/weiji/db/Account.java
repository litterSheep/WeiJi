package com.ly.weiji.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ly on 2017/3/2 14:50.
 */
@Entity
public class Account {

    @Id(autoincrement = true)
    private Long id;
    private Integer year;
    private Integer month;
    private Integer day;
    private Long writeTime;
    private Float money;
    private String remark;
    /**
     * 1： 收入(>0) 2： 支出(<0)
     */
    private Integer type;
    /**
     * 类别描述
     */
    private String description;

    /**
     * 类别显示的图标
     */
    private Integer icon;

    @Generated(hash = 2105213316)
    public Account(Long id, Integer year, Integer month, Integer day,
                   Long writeTime, Float money, String remark, Integer type,
                   String description, Integer icon) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.writeTime = writeTime;
        this.money = money;
        this.remark = remark;
        this.type = type;
        this.description = description;
        this.icon = icon;
    }

    @Generated(hash = 882125521)
    public Account() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return this.day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Long getWriteTime() {
        return this.writeTime;
    }

    public void setWriteTime(Long writeTime) {
        this.writeTime = writeTime;
    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIcon() {
        return this.icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }


}

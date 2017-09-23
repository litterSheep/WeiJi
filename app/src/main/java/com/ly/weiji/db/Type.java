package com.ly.weiji.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ly on 2017/9/22 16:50.
 */
@Entity
public class Type {

    @Id(autoincrement = true)
    private Long id;
    /**
     * 1： 收入(>0) 2： 支出(<0)
     */
    private Integer type;
    /**
     * 类别描述
     */
    private String descript;

    /**
     * 类别显示的图标
     */
    private Integer icon;
    /**
     * 决定该类别在列表显示的位置
     */
    private Integer index;

    @Generated(hash = 1980859922)
    public Type(Long id, Integer type, String descript, Integer icon,
                Integer index) {
        this.id = id;
        this.type = type;
        this.descript = descript;
        this.icon = icon;
        this.index = index;
    }

    @Generated(hash = 1782799822)
    public Type() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getIcon() {
        return this.icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}

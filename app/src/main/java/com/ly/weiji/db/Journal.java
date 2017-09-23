package com.ly.weiji.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ly on 2017/9/22 16:57.
 */
@Entity
public class Journal {

    @Id(autoincrement = true)
    private Long id;
    private Long writeTime;
    private String content;
    private String themColor;

    @Generated(hash = 118792837)
    public Journal(Long id, Long writeTime, String content, String themColor) {
        this.id = id;
        this.writeTime = writeTime;
        this.content = content;
        this.themColor = themColor;
    }

    @Generated(hash = 1562390721)
    public Journal() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWriteTime() {
        return this.writeTime;
    }

    public void setWriteTime(Long writeTime) {
        this.writeTime = writeTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThemColor() {
        return this.themColor;
    }

    public void setThemColor(String themColor) {
        this.themColor = themColor;
    }

}

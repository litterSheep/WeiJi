package com.ly.weiji.db;

import com.ly.weiji.App;
import com.ly.weiji.db.greendao.TypeDao;

import java.util.List;

/**
 * Created by ly on 2017/9/22 17:21.
 */

public class TypeManager {

    private TypeDao typeDao;

    public TypeManager() {
        this.typeDao = App.getInstance().getDaoSession().getTypeDao();
    }

    public long insert(Type type) {
        return typeDao.insert(type);
    }

    public void insert(List<Type> types) {
        if (types != null)
            for (Type type : types) {
                typeDao.insert(type);
            }
    }

    public Type getType(int type) {
        return typeDao.queryBuilder().where(TypeDao.Properties.Type.eq(type)).unique();
    }

    public String getDescByType(int type) {
        Type typeInfo = getType(type);
        if (typeInfo != null) {
            return getType(type).getDescript();
        } else {
            return "";
        }
    }

    public int getIconByType(int type) {
        Type typeInfo = getType(type);
        if (typeInfo != null) {
            return getType(type).getIcon();
        } else {
            return 0;
        }
    }

    public int getIndexByType(int type) {
        Type typeInfo = getType(type);
        if (typeInfo != null) {
            return getType(type).getIndex();
        } else {
            return 0;
        }
    }
}

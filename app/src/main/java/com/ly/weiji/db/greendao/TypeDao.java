package com.ly.weiji.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ly.weiji.db.Type;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TYPE".
*/
public class TypeDao extends AbstractDao<Type, Long> {

    public static final String TABLENAME = "TYPE";

    /**
     * Properties of entity Type.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Type = new Property(1, Integer.class, "type", false, "TYPE");
        public final static Property Descript = new Property(2, String.class, "descript", false, "DESCRIPT");
        public final static Property Icon = new Property(3, Integer.class, "icon", false, "ICON");
        public final static Property Index = new Property(4, Integer.class, "index", false, "INDEX");
    }


    public TypeDao(DaoConfig config) {
        super(config);
    }
    
    public TypeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TYPE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TYPE\" INTEGER," + // 1: type
                "\"DESCRIPT\" TEXT," + // 2: descript
                "\"ICON\" INTEGER," + // 3: icon
                "\"INDEX\" INTEGER);"); // 4: index
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TYPE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Type entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, type);
        }
 
        String descript = entity.getDescript();
        if (descript != null) {
            stmt.bindString(3, descript);
        }
 
        Integer icon = entity.getIcon();
        if (icon != null) {
            stmt.bindLong(4, icon);
        }
 
        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(5, index);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Type entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, type);
        }
 
        String descript = entity.getDescript();
        if (descript != null) {
            stmt.bindString(3, descript);
        }
 
        Integer icon = entity.getIcon();
        if (icon != null) {
            stmt.bindLong(4, icon);
        }
 
        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(5, index);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Type readEntity(Cursor cursor, int offset) {
        Type entity = new Type( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // descript
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // icon
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // index
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Type entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setDescript(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIcon(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setIndex(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Type entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Type entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Type entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

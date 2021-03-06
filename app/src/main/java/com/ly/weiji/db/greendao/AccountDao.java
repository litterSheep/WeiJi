package com.ly.weiji.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ly.weiji.db.Account;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT".
*/
public class AccountDao extends AbstractDao<Account, Long> {

    public static final String TABLENAME = "ACCOUNT";

    /**
     * Properties of entity Account.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Year = new Property(1, Integer.class, "year", false, "YEAR");
        public final static Property Month = new Property(2, Integer.class, "month", false, "MONTH");
        public final static Property Day = new Property(3, Integer.class, "day", false, "DAY");
        public final static Property WriteTime = new Property(4, Long.class, "writeTime", false, "WRITE_TIME");
        public final static Property Money = new Property(5, Float.class, "money", false, "MONEY");
        public final static Property Remark = new Property(6, String.class, "remark", false, "REMARK");
        public final static Property Type = new Property(7, Integer.class, "type", false, "TYPE");
        public final static Property Description = new Property(8, String.class, "description", false, "DESCRIPTION");
        public final static Property Icon = new Property(9, Integer.class, "icon", false, "ICON");
    }


    public AccountDao(DaoConfig config) {
        super(config);
    }
    
    public AccountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"YEAR\" INTEGER," + // 1: year
                "\"MONTH\" INTEGER," + // 2: month
                "\"DAY\" INTEGER," + // 3: day
                "\"WRITE_TIME\" INTEGER," + // 4: writeTime
                "\"MONEY\" REAL," + // 5: money
                "\"REMARK\" TEXT," + // 6: remark
                "\"TYPE\" INTEGER," + // 7: type
                "\"DESCRIPTION\" TEXT," + // 8: description
                "\"ICON\" INTEGER);"); // 9: icon
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Account entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer year = entity.getYear();
        if (year != null) {
            stmt.bindLong(2, year);
        }
 
        Integer month = entity.getMonth();
        if (month != null) {
            stmt.bindLong(3, month);
        }
 
        Integer day = entity.getDay();
        if (day != null) {
            stmt.bindLong(4, day);
        }
 
        Long writeTime = entity.getWriteTime();
        if (writeTime != null) {
            stmt.bindLong(5, writeTime);
        }
 
        Float money = entity.getMoney();
        if (money != null) {
            stmt.bindDouble(6, money);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(7, remark);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(8, type);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(9, description);
        }
 
        Integer icon = entity.getIcon();
        if (icon != null) {
            stmt.bindLong(10, icon);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Account entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer year = entity.getYear();
        if (year != null) {
            stmt.bindLong(2, year);
        }
 
        Integer month = entity.getMonth();
        if (month != null) {
            stmt.bindLong(3, month);
        }
 
        Integer day = entity.getDay();
        if (day != null) {
            stmt.bindLong(4, day);
        }
 
        Long writeTime = entity.getWriteTime();
        if (writeTime != null) {
            stmt.bindLong(5, writeTime);
        }
 
        Float money = entity.getMoney();
        if (money != null) {
            stmt.bindDouble(6, money);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(7, remark);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(8, type);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(9, description);
        }
 
        Integer icon = entity.getIcon();
        if (icon != null) {
            stmt.bindLong(10, icon);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Account readEntity(Cursor cursor, int offset) {
        Account entity = new Account( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // year
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // month
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // day
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // writeTime
            cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5), // money
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // remark
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // type
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // description
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9) // icon
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Account entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setYear(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setMonth(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setDay(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setWriteTime(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setMoney(cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5));
        entity.setRemark(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setType(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setDescription(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIcon(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Account entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Account entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Account entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

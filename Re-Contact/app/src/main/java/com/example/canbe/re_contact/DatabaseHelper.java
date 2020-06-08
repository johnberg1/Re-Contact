package com.example.canbe.re_contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by canbe on 6.05.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    private static final  String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_HOBBIES = "hobbies";
    private static final String COLUMN_FACEBOOK = "facebook";
    private static final String COLUMN_TWITTER = "twitter";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_JOB = "job";
    private static final String COLUMN_WORKPLACE = "workplace";
    private static final String COLUMN_PHONENUM = "phonenum";
    private static final String COLUMN_ISUSER = "isuser";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , "+
            "name text not null , email text not null , uname text not null , password text not null , " +
            "hobbies text not null , " +
            "facebook text not null , twitter text not null , age text not null , job text not null ," +
            " workplace text not null , phonenum text not null, isuser text not null);";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    public String getTableName(){
        return DATABASE_NAME;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_HOBBIES, c.getHobbies());
        values.put(COLUMN_FACEBOOK, c.getFacebook());
        values.put(COLUMN_TWITTER, c.getTwitter());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_JOB, c.getJob());
        values.put(COLUMN_WORKPLACE, c.getWorkplace());
        values.put(COLUMN_PHONENUM, c.getPhoneNum());
        values.put(COLUMN_ISUSER, c.getIsUser());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String searchPassword(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if ( a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;
    }
    public boolean isUsernameUsed(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst())
        {
            do{
                if(uname.equals(cursor.getString(0)))
                {
                    return true;
                }
            }while(cursor.moveToNext());
        }
        return false;
    }
    public String getUsername() throws SQLException {
        String username = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_UNAME },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return username;
    }
    public ArrayList<String> getAllUsername() throws SQLException {
        ArrayList<String> userNames = new ArrayList<>();
        String username = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_UNAME },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                userNames.add(username);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return userNames;
    }
    public String getIsUser() throws SQLException {
        String isuser = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_ISUSER },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                isuser = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return isuser;
    }

    public String getName() throws SQLException {
        String name = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_NAME },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                name = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return name;
    }
    public String getEmail() throws SQLException {
        String email = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_EMAIL },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                email = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return email;
    }
    public String getHobbies() throws SQLException {
        String hobbies = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_HOBBIES },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                hobbies = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return hobbies;
    }
    public String getFacebook() throws SQLException {
        String facebook = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_FACEBOOK },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                facebook = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return facebook;
    }
    public String getTwitter() throws SQLException {
        String twitter = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_TWITTER },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                twitter = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return twitter;
    }
    public String getAge() throws SQLException {
        String age = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_AGE },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                age = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return age;
    }
    public String getJob() throws SQLException {
        String job = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_JOB },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                job = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return job;
    }
    public String getWorkplace() throws SQLException {
        String workplace = "";
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_WORKPLACE },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                workplace = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return workplace;
    }
    public int getPhoneNum() throws SQLException {
        int phoneNum = 0;
        Cursor cursor = this.getReadableDatabase().query(
                TABLE_NAME, new String[] { COLUMN_PHONENUM },
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                phoneNum = Integer.parseInt(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return phoneNum;
    }

    public Contact getContact( String uname)
    {
        Cursor cursor = getReadableDatabase().query(true, TABLE_NAME, new String[]
                { COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL , COLUMN_UNAME, COLUMN_PASSWORD
                        , COLUMN_HOBBIES, COLUMN_FACEBOOK, COLUMN_TWITTER, COLUMN_AGE, COLUMN_JOB,
                        COLUMN_WORKPLACE, COLUMN_PHONENUM, COLUMN_ISUSER},COLUMN_UNAME + "=?",
                         new String[]{uname}
                        ,null,null,null,null);
        if ( cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact();
        contact.setName(cursor.getString(1));
        contact.setEmail(cursor.getString(2));
        contact.setUname(cursor.getString(3));
        contact.setPassword(cursor.getString(4));
        contact.setHobbies(cursor.getString(5));
        contact.setFacebook(cursor.getString(6));
        contact.setTwitter(cursor.getString(7));
        contact.setAge(cursor.getString(8));
        contact.setJob(cursor.getString(9));
        contact.setWorkplace(cursor.getString(10));
        contact.setPhoneNum(Integer.parseInt(cursor.getString(11)));
        contact.setIsUser(cursor.getString(12));
        cursor.close();
        return contact;
    }


    public void update( Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_HOBBIES, c.getHobbies());
        values.put(COLUMN_FACEBOOK, c.getFacebook());
        values.put(COLUMN_TWITTER, c.getTwitter());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_JOB, c.getJob());
        values.put(COLUMN_WORKPLACE, c.getWorkplace());
        values.put(COLUMN_PHONENUM, c.getPhoneNum());
        values.put(COLUMN_ISUSER, c.getIsUser());
        System.out.println(c.getUname());
        db.update(TABLE_NAME, values,  "uname= '" + c.getUname() + "'", null);
        db.close();
    }
}

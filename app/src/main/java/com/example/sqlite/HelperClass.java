package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class HelperClass extends SQLiteOpenHelper {
    Context context;
    public HelperClass(@Nullable Context context) {
        super(context, "STUDENTTEACHERDATABASE.db", null, 2);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create Table STUDENTTable(Sno Interger Primary key ,Name text,Mail text)");
        Toast.makeText(context, "Student SQl Started", Toast.LENGTH_SHORT).show();

        db.execSQL("Create Table TEACHERTable(Tno Interger Primary key ,Tname text,Tmail text)");
        Toast.makeText(context, "Teacher SQl Started", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        if(i<i1)
        {
            db.execSQL("ALTER TABLE STUDENTTable ADD Mobile TEXT");
            db.execSQL("ALTER TABLE STUDENTTable ADD Address TEXT");
            db.execSQL("ALTER TABLE TEACHERTAble ADD Mobile TEXT");
            db.execSQL("ALTER TABLE TEACHERTable ADD Address TEXT");
        }


    }
    public long createMethod(SQLiteDatabase db,int sno,String name,String mail)
    {
        ContentValues cv=new ContentValues();
        cv.put("Sno",sno);
        cv.put("Name",name);
        cv.put("Mail",mail);

        long set=db.insert("STUDENTTable",null,cv);
        return set;
    }

    public long createMethod1(SQLiteDatabase db,int tno,String tname,String tmail)
    {
        ContentValues cv=new ContentValues();
        cv.put("Tno",tno);
        cv.put("Tname",tname);
        cv.put("Tmail",tmail);

        long set=db.insert("TEACHERTable",null,cv);
        return set;
    }
}

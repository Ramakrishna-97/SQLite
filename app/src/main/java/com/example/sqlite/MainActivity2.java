package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spin1;
    String[] names = { "Student","Teacher"};
    ListView SqlListView;
    Cursor cursor;
    HelperClass helperClass;
    SQLiteDatabase db;

    ArrayList<String> stringArrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    ModelClass modelClassStudent,modelClassTeacher;
    AdapterClass adapterClass;
    List<ModelClass> modelClassList=new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spin1 = findViewById(R.id.spinner1);
        SqlListView = findViewById(R.id.SQlList);


        spin1.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),names[position] , Toast.LENGTH_LONG).show();

        if(names[position]=="Student")
        {
            studentMethod();
        }
        else if(names[position]=="Teacher")
        {
            teacherMethod();
        }

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void studentMethod() {
        modelClassList.clear();


        String[] Col={"Sno","Name","Mail"};


        helperClass =new HelperClass(this);
        db=helperClass.getReadableDatabase();



        cursor=db.query("STUDENTTable",Col,null,null,null,null,null);


        if(cursor.getCount()>0 &&cursor!=null)
        {
            while (cursor.moveToNext())
            {


                String Name=cursor.getString(1);
                String Mail=cursor.getString(2);

                modelClassStudent = new ModelClass(Name,Mail);
                modelClassList.add(modelClassStudent);

                adapterClass = new AdapterClass(getApplicationContext(),modelClassList);
                SqlListView.setAdapter(adapterClass);





            }

        }
        else
        {
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
        }



    }





    private void teacherMethod() {

        modelClassList.clear();


        String[] Col={"Tno","Tname","Tmail"};



        helperClass =new HelperClass(this);
        db=helperClass.getReadableDatabase();



        cursor=db.query("TEACHERTable",Col,null,null,null,null,null);


        if(cursor.getCount()>0 &&cursor!=null)
        {
            while (cursor.moveToNext())
            {

                String Name=cursor.getString(1);
                String Mail=cursor.getString(2);


                modelClassTeacher = new ModelClass(Name,Mail);
                modelClassList.add(modelClassTeacher);

                adapterClass = new AdapterClass(getApplicationContext(),modelClassList);
                SqlListView.setAdapter(adapterClass);




            }

        }
        else
        {
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
        }

    }


}
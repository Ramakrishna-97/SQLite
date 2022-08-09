package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spin;

    String[] names = { "Student","Teacher"};
    TextView studentdisplayTxt,teacherdisplayTxt;
    EditText sname, smail, sid, teacherName, teacherMail, teacherId;

    HelperClass helperClass;
    SQLiteDatabase db;

    String snameStr, smailStr, tnameStr, tmailStr;
    int sValue, tValue;




    LinearLayout l1, l2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spinner);

        studentdisplayTxt = findViewById(R.id.displaytxt);
        teacherdisplayTxt = findViewById(R.id.displaytextt);
        sname = findViewById(R.id.name);
        smail = findViewById(R.id.mail);
        sid = findViewById(R.id.id);
        teacherName = findViewById(R.id.tname);
        teacherMail = findViewById(R.id.tmail);
        teacherId = findViewById(R.id.tid);


        helperClass = new HelperClass(this);
        db = helperClass.getWritableDatabase();
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),names[position] , Toast.LENGTH_LONG).show();
        if(names[position]=="Student")
        {

            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.GONE);

        }
        else if(names[position]=="Teacher")
        {
            l2.setVisibility(View.VISIBLE);
            l1.setVisibility(View.GONE);

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void insert(View view) {

        // setmail.setText(""+name.getText().toString());

        snameStr=sname.getText().toString();
        smailStr=smail.getText().toString();
        sValue=Integer.parseInt(sid.getText().toString());

        long set=helperClass.createMethod(db,sValue,snameStr,smailStr);

        if(set==-1)
        {
            Toast.makeText(this, "Student Record Already Exist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Student New Record Created Successfully", Toast.LENGTH_SHORT).show();

        }

    }
    public  void insert1(View view)
    {
        tnameStr = teacherName.getText().toString();
        tmailStr = teacherMail.getText().toString();
        tValue = Integer.parseInt(teacherId.getText().toString());

        long set = helperClass.createMethod1(db,tValue,tnameStr,tmailStr);

        if(set==-1)
        {
            Toast.makeText(this,"Teacher Record Already Exist",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Teacher New Record Created Successfully",Toast.LENGTH_SHORT).show();
        }
    }


    public void Next(View view) {

        startActivity(new Intent(this,MainActivity2.class));

    }
}
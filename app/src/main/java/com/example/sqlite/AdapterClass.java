package com.example.sqlite;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends BaseAdapter {

    Context context;

    List<ModelClass> modelClassList=new ArrayList<>();
    LayoutInflater inflater;

    public AdapterClass(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return modelClassList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View root=inflater.inflate(R.layout.custom_list,null);
        TextView Name = root.findViewById(R.id.nameDisplay);
        TextView Mail = root.findViewById(R.id.mailDisplay);

        Name.setText(""+modelClassList.get(i).getStudentName());

        Mail.setText(""+modelClassList.get(i).getStudentMail());



        return root;
    }
}
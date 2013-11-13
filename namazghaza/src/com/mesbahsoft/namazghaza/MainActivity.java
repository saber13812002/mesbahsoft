package com.mesbahsoft.namazghaza;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */

    int rokat=0;

    private db_helper RokatDBHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        RokatDBHelper = new db_helper(this);

        TextView txtRokatAll = (TextView)findViewById(R.id.txtRemainRokatAll);
        int a = RokatDBHelper.getCountKolGhaza()-RokatDBHelper.getCountKolAda();
        String s=Integer.toString(a);
        txtRokatAll.setText(s);

        TextView last2rowGhaza = (TextView) findViewById(R.id.last2);
        last2rowGhaza.setText(RokatDBHelper.getlast2records());

        Button b= (Button) findViewById(R.id.btnIncrement);
        b.setOnClickListener(this);
        b.setId(1);

        TextView t2 = (TextView) findViewById(R.id.txtplustwo);
        t2.setOnClickListener(this);
        t2.setId(2);

        TextView t3 = (TextView) findViewById(R.id.txtplus3);
        t3.setOnClickListener(this);
        t3.setId(3);

        TextView t4 = (TextView) findViewById(R.id.txtplus4);
        t4.setOnClickListener(this);
        t4.setId(4);

        Button b_add = (Button) findViewById(R.id.btnCalc);
        b_add.setOnClickListener(this);
        b_add.setId(0);


        // use a default value using new Date()
//        long l = prefs.getLong(dateTimeKey, new Date().getTime());
//        int r= prefs.getInt(rokatKey,1);

//        if(r==1)
//        {
//            int rk = 100;
//            //prefs.edit().putInt(rokatKey,rk.getRokat()).commit();
//            //Date dt = getSomeDate();
//            //prefs.edit().putLong(dateTimeKey, dt.getTime()).commit();
//        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case 0:
                Intent intent = new Intent(MainActivity.this, calc.class);
                startActivity(intent);
                break;
            case 1:
                rokat++;
                RokatDBHelper.addAdaRokatRow(1);
                break;
            case 2:
                rokat+=2;
                RokatDBHelper.addAdaRokatRow(2);
                break;
            case 3:
                rokat+=3;
                RokatDBHelper.addAdaRokatRow(3);
                break;
            case 4:
                rokat+=4;
                RokatDBHelper.addAdaRokatRow(4);
                break;
        }
        String stRokat= Integer.toString(rokat);
        TextView tv = (TextView)findViewById(R.id.txtBigNumnerTodayRokat);
        tv.setText(stRokat);

        //int totalRokat=getSharedPreferences(rokatKey,Context.MODE_PRIVATE);

    }


}
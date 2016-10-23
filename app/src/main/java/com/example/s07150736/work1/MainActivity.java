package com.example.s07150736.work1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private int num1=0,num2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv1.setText("tv1准备赋值");
        tv2.setText("tv2准备赋值");
        Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv1.setText("重启");
        tv2.setText("重启");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        num1++;
        num2++;
        outState.putString("tv1","此时的值为"+num1);
        outState.putString("tv2",String.valueOf(num2));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText("此时的值为"+savedInstanceState.getString("tv2"));
        num2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }
}

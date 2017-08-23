package com.ob.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ob.demo.widget.CustomDialog;
import com.ob.demo.widget.CustomToast;

public class MainActivity extends AppCompatActivity {

    private int number = 0;
    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            
        initView();
        initDialog();
    }


    private void initView() {
        findViewById(R.id.main_demo_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String concat = ((TextView) view).getText().toString().concat(String.valueOf(number++));
                customDialog.setContentText(concat).show();
            }
        });
    }
    private void initDialog() {
        customDialog = new CustomDialog(MainActivity.this).setContentText(String.valueOf(number))//.setSingleCancle(true).setCancleStr("¹Ø±Õ")
                .setOnOkClickListener(new CustomDialog.OnOkClickListener() {
            @Override
            public void onClick() {
                CustomToast.makeText(MainActivity.this, customDialog.getContentText());
            }
        })
                .setOnCancleClickListener(new CustomDialog.OnCancleClickListener() {
            @Override
            public void onClick() {
                CustomToast.makeText(MainActivity.this, customDialog.getContentText());
            }
        }).showDilaog();
    }
}

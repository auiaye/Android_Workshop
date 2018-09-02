package com.arit.demo.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    public TextView tvMessage;
    @BindView(R.id.tvMessage) TextView tvMessage;
//    @BindView(R.id.btnHello) Button btnHello;

    @OnClick(R.id.btnHello)
    public void doClickHello() {
        this.tvMessage.setText(R.string.helloMessage);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        2018-09-02
//        tvMessage =  findViewById(R.id.tvMessage);
//        Button btnHello = findViewById(R.id.btnHello);
//        btnHello.setText("Hello John!");
//        btnHello.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvMessage.setText("Hello John Woo.This is a message");
//            }
//        });


    }
}

package com.arit.demo.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    public TextView tvMessage;
    @BindView(R.id.tvMessage) TextView tvMessage;
    @BindView(R.id.txtHeight) EditText txtHeight;
    @BindView(R.id.tvWeight) EditText tvWeight;
//    @BindView(R.id.btnHello) Button btnHello;

    @OnClick(R.id.btnHello)
    public void doClickHello() {
        this.tvMessage.setText(R.string.helloMessage);
    }

    @OnClick(R.id.btnHello2)
    public void doClickHello2(){
//        this.tvMessage.setText(R.string.helloMessage2);
        double strHeight;
        double strWeight;
        strHeight = Double.parseDouble(this.txtHeight.getText().toString());
        strWeight = Double.parseDouble(this.tvWeight.getText().toString());
        this.tvMessage.setText(Double.toString(strHeight));
    }



//    public static double convertToDouble(String temp){
//        String a = temp;
//        //replace all commas if present with no comma
//        String s = a.replaceAll(",","").trim();
//        // if there are any empty spaces also take it out.
//        String f = s.replaceAll(" ", "");
//        //now convert the string to double
//        double result = Double.parseDouble(f);
//        return result; // return the result
//    }

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

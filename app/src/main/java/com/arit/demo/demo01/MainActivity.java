package com.arit.demo.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;




public class MainActivity extends AppCompatActivity {

//    public TextView tvMessage;
    @BindView(R.id.tvMessage) TextView tvMessage;
    @BindView(R.id.txtHeight) EditText txtHeight;
    @BindView(R.id.txtWeight) EditText txtWeight;
//    @BindView(R.id.btnHello) Button btnHello;
    private static DecimalFormat formatter = new DecimalFormat();


    @OnClick(R.id.btnCancel)
    public void doClickClear() {
        this.txtHeight.setText("");
        this.txtWeight.setText("");
        this.tvMessage.setText("---Result---");
    }


    @OnClick(R.id.btnCalculate)
    public void doClickCalculated(){
        double dblHeight, dblWeight, numBMI;
        String getCalculate;
        int decimalPlaces = 2;
        String strHeight, strWeight;
        strHeight = this.txtHeight.getText().toString();
        strWeight = this.txtWeight.getText().toString();


        if(!strHeight.equals("") && !strWeight.equals("")){
            dblHeight = Double.parseDouble(this.txtHeight.getText().toString());
            dblWeight = Double.parseDouble(this.txtWeight.getText().toString());
            numBMI = (dblWeight / ((dblHeight / 100) * 2));
            BigDecimal bd = new BigDecimal(numBMI);
            bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
            numBMI = bd.doubleValue();
            getCalculate = Calculate_BMI(numBMI);
            this.tvMessage.setText("BMI : " + getCalculate);
        }else{

            this.tvMessage.setText("Please check input text : Height / Weight!");
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("!Error Message!");
            builder.setMessage("Please check input text : Height / Weight!");
//            builder.setPositiveButton("รับ", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int id) {
//                    Toast.makeText(getApplicationContext(),
//                            "ขอบคุณครับ", Toast.LENGTH_SHORT).show();
//                }
//            });

//            builder.setNegativeButton("ไม่ชอบซักทีม", null);

            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
//            builder.create();
            builder.show();

        }
    }

    public static String Calculate_BMI(double numBMI) {
        String ResultCal;
        if (numBMI < 16) {
            ResultCal = "Skin and bones";
        }else if (numBMI >= 16 && numBMI < 17) {
            ResultCal = "Thin";
        }else if (numBMI >= 17 && numBMI < 18.5) {
            ResultCal = "Fit";
        }else if (numBMI >= 18.5 && numBMI < 25) {
            ResultCal = "Good shape";
        }else if (numBMI >= 25 && numBMI < 30) {
            ResultCal = "Over Weight";
        }else if (numBMI >= 30 && numBMI < 35) {
            ResultCal = "Chubby";
        }else if (numBMI >= 35 && numBMI < 40) {
            ResultCal = "Fluffy";
        } else {
            ResultCal = "Tubby";
        }
        return ResultCal;
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

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    Double num1, num2, result;
    String textView1, textView2, operator;
    boolean z = true;
    RadioButton selectedButton;
    String values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

    }

    public void digitFunction(View view) {
        if(z)
            tv2.setText("");
        z = false;
        textView2 = tv2.getText().toString();

        if(view.getId() == R.id.zero){
            if(textView2.equals("0"))
            {
                tv2.setText("0");
            }
            else {
                tv2.setText(textView2 + "0");
            }
        }
        else if(view.getId() == R.id.one){
            tv2.setText(textView2 + "1");
        }
        else if(view.getId() == R.id.two){
            tv2.setText(textView2 + "2");
        }
        else if(view.getId() == R.id.three){
            tv2.setText(textView2 + "3");
        }
        else if(view.getId() == R.id.four){
            tv2.setText(textView2 + "4");
        }
        else if(view.getId() == R.id.five){
            tv2.setText(textView2 + "5");
        }
        else if(view.getId() == R.id.six){
            tv2.setText(textView2 + "6");
        }
        else if(view.getId() == R.id.seven){
            tv2.setText(textView2 + "7");
        }
        else if(view.getId() == R.id.eight){
            tv2.setText(textView2 + "8");
        }
        else if(view.getId() == R.id.nine){
            tv2.setText(textView2 + "9");
        }
        else if(view.getId() == R.id.clear){
            tv2.setText("0");
            tv1.setText("");
            z = true;
        }
        else if(view.getId() == R.id.clear2){
            tv2.setText("0");
            z = true;
        }
        else if(view.getId() == R.id.dot){
            if(textView2.contains(".")){
                tv2.setText(textView2);
            }
            else {
                tv2.setText("0"+ textView2 + ".");
            }
        }
    }


    public void delete(View view) {
        textView2 = tv2.getText().toString();
        if(textView2.length() != 0){
            textView2 = textView2.substring(0, textView2.length()-1);
            tv2.setText(textView2);
            if(textView2.length() == 0){
                tv2.setText("0");
            }
        }
    }

    public void logic(View view) {
        z = true;

        textView2 = tv2.getText().toString();
        if(view.getId() == R.id.plus){
            operator = "+";
            tv1.setText(textView2 + "+");
            num1 = Double.parseDouble(textView2);
            tv2.setText("0");
        }
        else if(view.getId() == R.id.minus){
            operator = "-";
            tv1.setText(textView2 + "-");
            num1 = Double.parseDouble(textView2);
            tv2.setText("0");
        }
        else if(view.getId() == R.id.multi){
            operator = "*";
            tv1.setText(textView2 + "*");
            num1 = Double.parseDouble(textView2);
            tv2.setText("0");
        }
        else if(view.getId() == R.id.div){
            operator = "/";
            tv1.setText(textView2 + "/");
            num1 = Double.parseDouble(textView2);
            tv2.setText("0");
        }
        else if(view.getId() == R.id.negetive){
            operator = "-";
            if(textView2.contains("-")){
                textView2 = textView2.replaceAll("-", "");
                tv2.setText(textView2);
            }
            else {
                tv2.setText("-" + textView2);
            }
        }
    }

    public void getResult(View view) {
        num2 = Double.parseDouble(tv2.getText().toString());
        textView2 = tv2.getText().toString();
        textView1 = tv1.getText().toString();
        if(operator.equals("+")){
            result = num1 + num2;
            tv2.setText(""+result);
            tv1.setText(textView1 + "" + textView2 + "=");
        }
        else if(operator.equals("-")){
            result = num1 - num2;
            tv2.setText(""+result);
            tv1.setText(textView1 + "" + textView2 + "=");
        }
        else if(operator.equals("*")){
            result = num1 * num2;
            tv2.setText(""+result);
            tv1.setText(textView1 + "" + textView2 + "=");
        }
        else if(operator.equals("/")){
            result = num1 / num2;
            tv2.setText(""+result);
            tv1.setText(textView1 + "" + textView2 + "=");
        }

    }

    public void aboutMe(View view) {
        selectedButton = findViewById(R.id.about);
        values = selectedButton.getText().toString();
        if(values.equals("About")){
            Intent aboutMe = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(aboutMe);
        }
    }
}
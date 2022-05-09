package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }
    private void initTextViews(){
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String value){
        workings = workings + value;
        workingsTV.setText(workings);
    }

    public void solve(){
        String num [];
        if(workings.contains("=")){
            workings = "";
            setWorkings(String.valueOf(result));
        }
        else{
            if(workings.contains("+")){
                num = workings.split("\\+");
                double add = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
                workings = "";
                setWorkings(String.valueOf(add));
            }
            else if(workings.contains("_")){
                double min;
                num = workings.split("\\_");
                min = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
                workings = "";
                setWorkings (String.valueOf(min));
            }
            else if(workings.contains("*")){
                num = workings.split("\\*");
                double mul = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
                workings = "";
                setWorkings(String.valueOf(mul));
            }
            else if (workings.contains("/")){
                num = workings.split("\\/");
                double dev = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
                workings = "";
                setWorkings(String.valueOf(dev));
            }
        }
    }
    //Operator
    public void addOnClick(View view) {
        solve();
        setWorkings("+");
    }
    public void minusOnClick(View view) {
        solve();
        setWorkings("_");
    }
    public void mulOnClick(View view) {
        solve();
        setWorkings("*");
    }
    public void devideOnClick(View view) {
        solve();
        setWorkings("/");
    }

    public void prefixOnClick(View view) {
        setWorkings("-");
    }
    //Number
    public void zeroOnClick(View view) {
        setWorkings("0");
    }
    public void oneOnClick(View view) {
        setWorkings("1");
    }
    public void twoOnClick(View view) {
        setWorkings("2");
    }
    public void threeOnClick(View view) {
        setWorkings("3");
    }
    public void fourOnClick(View view) {
        setWorkings("4");
    }
    public void fiveOnClick(View view) {
        setWorkings("5");
    }
    public void sixOnClick(View view) {
        setWorkings("6");
    }
    public void sevenOnClick(View view) {
        setWorkings("7");
    }
    public void eightOnClick(View view) {
        setWorkings("8");
    }
    public void nineOnClick(View view) {
        setWorkings("9");
    }
    //Result
    public void equalOnClick(View view) {
        String num [];
        if(workings.contains("+")){
            num = workings.split("\\+");
            result  = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
            setWorkings("=");
            resultsTV.setText(String.valueOf(result));
        }
        else if(workings.contains("_")){
            num = workings.split("\\_");
            result = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
            setWorkings("=");
            resultsTV.setText(String.valueOf(result));
        }
        else if(workings.contains("*")){
            num = workings.split("\\*");
            result = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
            setWorkings("=");
            resultsTV.setText(String.valueOf(result));
        }
        else if (workings.contains("/")){
            num = workings.split("\\/");
            result = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
            setWorkings("=");
            resultsTV.setText(String.valueOf(result));
        }
    }

    public void toastOnClick(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_Dot,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void delOnClick(View view) {
        String s = workings.substring(0, workings.length()-1);
        workings = "";
        setWorkings(s);
    }
    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void bsOnClick(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_BS,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
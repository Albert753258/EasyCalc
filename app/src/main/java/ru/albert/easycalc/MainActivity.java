package ru.albert.easycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static LinkedList<String> actions = new LinkedList();
    public static String act = "";
    static TextView text;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc2);
        text = findViewById(R.id.text);
        text.setTextColor(Color.BLACK);
        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        if(isFirstStart()){
            final AlertDialog aboutDialog = new AlertDialog.Builder(this)
                    .setMessage(getResources().getString(R.string.firstOpen))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences.Editor ed = sharedPreferences.edit();
                            ed.putBoolean("isFirst", false);
                            ed.commit();
                        }
                    })
                    .create();
            aboutDialog.show();
            ((TextView) aboutDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        //Initializer.initialize(this, text);
    }
    public boolean isFirstStart(){
        return sharedPreferences.getBoolean("isFirst", true);
    }

    public static void onEquals(View view){
        if(!act.equals("")) {
            if(act.equals("*")){
                String arr[] = text.getText().toString().split(Pattern.quote("*"));
                int tmp = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
                text.setText("" + tmp);
            }
            if(act.equals("-")){
                String arr[] = text.getText().toString().split(Pattern.quote("-"));
                int tmp = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                text.setText("" + tmp);
            }
            if(act.equals("+")){
                String arr[] = text.getText().toString().split(Pattern.quote("+"));
                int tmp = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
                text.setText("" + tmp);
            }
            if(act.equals("/")){
                String arr[] = text.getText().toString().split(Pattern.quote("/"));
                double tmp = Double.parseDouble(arr[0]) / Double.parseDouble(arr[1]);
                text.setText("" + tmp);
            }
        }
    }
    public static void onClick(View view){
        text.append(((Button)view).getText());
    }
    public static void onDelClick(View view){
        if(!text.getText().toString().equals("")){
            char last = text.getText().toString().charAt(text.getText().toString().length() - 1);
            if(last == '/' || last == '*' || last == '-' || last == '+'){
                MainActivity.act = "";
            }
            text.setText(text.getText().toString().substring(0, text.getText().toString().length() - 1));
        }
    }
    public static void onLongDelClick(View view){
        text.setText("");
    }
    public static void onDivideClick(View view){
        text.append("/");
        MainActivity.act = "/";
    }
    public static void onMinusClick(View view){
        text.append("-");
        MainActivity.act = "-";
    }
    public static void onPlusClick(View view){
        text.append("+");
        MainActivity.act = "+";
    }
    public static void onMultipleClick(View view){
        text.append("*");
        MainActivity.act = "*";
    }
}
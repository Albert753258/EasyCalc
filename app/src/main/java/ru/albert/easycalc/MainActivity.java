package ru.albert.easycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static LinkedList<String> actions = new LinkedList();
    public static String act;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        text = findViewById(R.id.text);
        Initializer.initialize(this, text);
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    int tmp = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
                    text.setText("" + tmp);
                }
            }
        });
    }
}

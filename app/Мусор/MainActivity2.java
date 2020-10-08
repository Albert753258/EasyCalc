package ru.albert.easycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    //public static LinkedList<String> actions = new LinkedList();
    //public static String act = "";
    TextView text;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc2);
        //text = findViewById(R.id.text);
        //text.setTextColor(Color.BLACK);
//        int BOOKSHELF_ROWS = 4;
//        int BOOKSHELF_COLUMNS = 3;
//        TableLayout tableLayout = findViewById(R.id.tableLayout);
//
//        for (int i = 0; i < BOOKSHELF_ROWS; i++) {
//
//            TableRow tableRow = new TableRow(this);
//            tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//
//            for (int j = 0; j < BOOKSHELF_COLUMNS; j++) {
//                Button button = new Button(this);
//                tableRow.addView(button, j);
//            }
//
//            tableLayout.addView(tableRow, i);
//        }
    }
    public boolean isFirstStart(){
        return sharedPreferences.getBoolean("isFirst", true);
    }
}
package com.example.sqlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDB mydb = new MyDB(this);
        MyDatabaseHelper mdh = new MyDatabaseHelper(this);
        mdh.onCreate(mydb.getDatabase());
        mydb.createRecords(1, "Employee 1");
        mydb.createRecords(2, "Employee 2");
        mydb.createRecords(3, "Employee 3");
        Spinner s = findViewById(R.id.spinnerCategories);
        Cursor c = mydb.selectRecords();
        String[] from = new String[]{"nom"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, c, from, to, 0);
        sca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(sca);
    }
}

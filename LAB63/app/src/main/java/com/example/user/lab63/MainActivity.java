package com.example.user.lab63;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button add, pop;
    EditText edit_name, edit_number;
    ListView listView;
    String[] studentData;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name=(EditText) findViewById(R.id.edit_name);
        edit_number=(EditText) findViewById(R.id.edit_number);
        add=(Button)findViewById(R.id.btn_push);
        //Add to List View when Add Button is clicked
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit_name.getText().toString();
                String number=edit_number.getText().toString();
                if (number.isEmpty() || name.isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    insert(name,number); //call insert
                    invalidate();
                }
            }
        });
        //Click the Delete button to delete from the listview
        pop=(Button)findViewById(R.id.btn_pop);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit_name.getText().toString();
                if(name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    delete(name); //call delete
                    invalidate();
                }

            }
        });
        listView = (ListView) findViewById(R.id.listView);

        helper = new MySQLiteOpenHelper(getApplicationContext(), "student.db", null, 1);

        invalidate();
    }
    public void insert(String name, String number) {
        db = helper.getWritableDatabase();// Open the database in write mode using the getWritableDatabase method of the Helper object
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("number", number);
        db.insert("student", null, values);
    }
    private void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});

    }
    private void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        studentData = new String[c.getCount()];
        int count = 0;

        while (c.moveToNext()) {
            studentData[count] = c.getString(c.getColumnIndex("name")) + "     " + c.getString(c.getColumnIndex("number"));
            count++;
        }

        c.close();
    }

    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentData);
        listView.setAdapter(adapter);
    }

    public class MySQLiteOpenHelper extends SQLiteOpenHelper {

        public MySQLiteOpenHelper(Context context, String name,
                                  SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            String sql = "create table student (name text, number text);";
            db.execSQL(sql); //테이블을 만들기 위해 execSQL 메소드 사용
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exists student";
            db.execSQL(sql);
            onCreate(db);
        }
    }

}

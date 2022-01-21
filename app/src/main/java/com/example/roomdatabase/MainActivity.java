package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initialize Variables.....
    EditText editText;
    Button btn_add;
    RecyclerView recycler_view;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variables.....
        editText = findViewById(R.id.editText);
        btn_add = findViewById(R.id.btn_add);
        recycler_view = findViewById(R.id.recycler_view);

        //Initialize Database.....
        database = RoomDB.getInstance(this);

        //Store Database value in Data list.....
        dataList = database.mainDao().getAll();

        //Initialize linearLayoutManager.....
        linearLayoutManager = new LinearLayoutManager(this);

        //Set Layout Manager.....
        recycler_view.setLayoutManager(linearLayoutManager);

        //Initialize Adapter.....
        mainAdapter = new MainAdapter(MainActivity.this,dataList);

        //Set Adapter.....
        recycler_view.setAdapter(mainAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get String from Edit text.....
                String mtext = editText.getText().toString().trim();

                //check condition.....
                if (!mtext.equals("")){
                    //When text is not empty.....
                    //Initialize MainData.....
                    MainData data = new MainData();

                    //Set text on Main Data.....
                    data.setText(mtext);

                    //Insert text in database.....
                    database.mainDao().insert(data);

                    //Clear edit text.....
                    editText.setText("");

                    //Notify when data is inserted.....
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    mainAdapter.notifyDataSetChanged();
                }
            }
        });

    }
}
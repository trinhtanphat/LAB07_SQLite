package com.example.lab07_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button btnAdd, btnUpdate, btnDelete;
    public EditText edtId, edtContent, edtTitle, edtDate, edtType, edtStatus;

    ListView toDoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoListView = findViewById(R.id.todoListView);
        ToDoDAO toDoDao = new ToDoDAO(this);
        ArrayList<ToDo> listToDo = toDoDao.getListTodo();
        ToDoAdapter todoAdapter = new ToDoAdapter(this, listToDo);
        toDoListView.setAdapter(todoAdapter);

        btnAdd = findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

                edtTitle = findViewById(R.id.task_title);
                toDo.setTitle(edtTitle.getText().toString());

                edtContent = findViewById(R.id.task_content);
                toDo.setContent(edtContent.getText().toString());

                edtDate = findViewById(R.id.task_date);
                toDo.setDate(edtDate.getText().toString());

                edtType = findViewById(R.id.task_type);
                toDo.setType(edtType.getText().toString());

                toDo.setStatus(1);
                boolean added = toDoDao.addToDo(toDo);
                if (added) {
                    Toast.makeText(MainActivity.this, "ToDo added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate = findViewById(R.id.updateBtn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

//                edtId = findViewById(R.id.task_id);
//                toDo.setId(Integer.parseInt(edtId.getText().toString()));

                edtTitle = findViewById(R.id.task_title);
                toDo.setTitle(edtTitle.getText().toString());

                edtContent = findViewById(R.id.task_content);
                toDo.setContent(edtContent.getText().toString());

                edtDate = findViewById(R.id.task_date);
                toDo.setDate(edtDate.getText().toString());

                edtType = findViewById(R.id.task_type);
                toDo.setType(edtType.getText().toString());

                toDo.setStatus(1);
                boolean added = toDoDao.addToDo(toDo);
                if (added) {
                    Toast.makeText(MainActivity.this, "ToDo added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAdd = findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

                edtTitle = findViewById(R.id.task_title);
                toDo.setTitle(edtTitle.getText().toString());

                edtContent = findViewById(R.id.task_content);
                toDo.setContent(edtContent.getText().toString());

                edtDate = findViewById(R.id.task_date);
                toDo.setDate(edtDate.getText().toString());

                edtType = findViewById(R.id.task_type);
                toDo.setType(edtType.getText().toString());

                toDo.setStatus(1);
                boolean added = toDoDao.addToDo(toDo);
                if (added) {
                    Toast.makeText(MainActivity.this, "ToDo added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
package com.example.lab07_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnUpdate, btnDelete;
    EditText edtId, edtContent, edtTitle, edtDate, edtType, edtStatus;

    ListView toDoListView;
    ToDoDAO toDoDao = new ToDoDAO(this);

    private void setTextView() {
        this.edtId = findViewById(R.id.idInput);
        this.edtId.setVisibility(View.GONE);
        this.edtTitle = findViewById(R.id.titleInput);
        this.edtContent = findViewById(R.id.contentInput);
        this.edtDate = findViewById(R.id.dateInput);
        this.edtType = findViewById(R.id.typeInput);
        this.toDoListView = findViewById(R.id.todoListView);
    }

    private void loadData() {
        ArrayList<ToDo> listToDo = toDoDao.getListTodo();
        ToDoAdapter todoAdapter = new ToDoAdapter(this, listToDo);
        toDoListView.setAdapter(todoAdapter);
        toDoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object selectedItem = toDoListView.getItemAtPosition(position);
                ToDo toDo = (ToDo) selectedItem;
                edtId.setText(toDo.getId().toString());
                edtTitle.setText(toDo.getTitle().toString());
                edtContent.setText(toDo.getContent().toString());
                edtDate.setText(toDo.getDate().toString());
                edtType.setText(toDo.getType().toString());
//                edtStatus.setText(toDo.getStatus());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextView();

        loadData();

        btnAdd = findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

                toDo.setTitle(edtTitle.getText().toString());
                toDo.setContent(edtContent.getText().toString());
                toDo.setDate(edtDate.getText().toString());
                toDo.setType(edtType.getText().toString());
                toDo.setStatus(1);

                boolean added = toDoDao.addToDo(toDo);
                if (added) {
                    loadData();
                    Toast.makeText(MainActivity.this, "ToDo added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate = findViewById(R.id.updateBtn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

                toDo.setId(Integer.valueOf(edtId.getText().toString()));
                toDo.setTitle(edtTitle.getText().toString());
                toDo.setContent(edtContent.getText().toString());
                toDo.setDate(edtDate.getText().toString());
                toDo.setType(edtType.getText().toString());
//                toDo.setStatus(1);

                boolean updated = toDoDao.updateToDo(toDo);
                if (updated) {
                    loadData();
                    Toast.makeText(MainActivity.this, "ToDo updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to update ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete = findViewById(R.id.deleteBtn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo toDo = new ToDo();

                toDo.setId(Integer.valueOf(edtId.getText().toString()));
                toDo.setTitle(edtTitle.getText().toString());
                toDo.setContent(edtContent.getText().toString());
                toDo.setDate(edtDate.getText().toString());
                toDo.setType(edtType.getText().toString());
//                toDo.setStatus(1);

                boolean deleted = toDoDao.deleteToDo(toDo);
                if (deleted) {
                    loadData();
                    Toast.makeText(MainActivity.this, "ToDo delete successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to delete ToDo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
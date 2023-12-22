package com.example.lab07_sqlite;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;

public class ToDoDAO {
    private final DbHelper dbHelper;

    public ToDoDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<ToDo> getListTodo() {
        // Tạo một danh sách để add dữ liệu Todo vào
        ArrayList<ToDo> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //Database bắt đầu chạy
        database.beginTransaction();
        try {
            // Tạo câu lệnh truy vấn
            Cursor cursor = database.rawQuery("SELECT * FROM TODO", null);
            if (cursor.getCount() > 0) {
                //Nếu cursor lớn hơn không, di chuyển con trỏ lên đầu
                cursor.moveToFirst();
                //Khởi tạo vòng lặp do while để lấy toàn bộ dữ liệu truy vấn được thêm vào danh sách
                do {
                    list.add(new ToDo(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getInt(5)));
                } while (cursor.moveToNext());
                //Database đã chạy thành công
                database.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.e(TAG, "getListTodo: " + e);
        } finally {
            //Kết thúc lệnh chay
            database.endTransaction();
        }
        return list;
    }

    public boolean addToDo(ToDo toDo) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();

        ContentValues values = new ContentValues();

        values.put("TITLE", toDo.getTitle());
        values.put("CONTENT", toDo.getContent());
        values.put("DATE", toDo.getDate());
        values.put("TYPE", toDo.getType());
        values.put("STATUS", toDo.getStatus());

        long check = database.insert("TODO", null, values);
        return check != -1;
    }

//    public boolean updateToDo(ToDo toDo) {
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        database.beginTransaction();
//
//        ContentValues values = new ContentValues();
//
//        values.put("TITLE", toDo.getTitle());
//        values.put("CONTENT", toDo.getContent());
//        values.put("DATE", toDo.getDate());
//        values.put("TYPE", toDo.getType());
//        values.put("STATUS", toDo.getStatus());
//
//        long check = database.update("TODO", null, values);
//        return check != -1;
//    }

//    public boolean deleteToDo(ToDo toDo) {
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        database.beginTransaction();
//
//        ContentValues values = new ContentValues();
//
//        values.put("TITLE", toDo.getTitle());
//        values.put("CONTENT", toDo.getContent());
//        values.put("DATE", toDo.getDate());
//        values.put("TYPE", toDo.getType());
//        values.put("STATUS", toDo.getStatus());
//
//        long check = database.update("TODO", null, values);
//        return check != -1;
//    }
}

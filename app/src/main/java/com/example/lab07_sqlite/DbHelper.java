package com.example.lab07_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        //Khởi tạo database có tên là TodoDatabase và version là 1
        super(context, "TodoDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        // Tạo câu lệnh tạo bảng
        String sql = "CREATE TABLE TODO (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TITLE TEXT, CONTENT TEXT, DATE TEXT, TYPE TEXT, STATUS INTEGER)";
        sqliteDatabase.execSQL(sql);

        // Tạo câu lệnh thêm dữ liệu vào database
        String data = "INSERT INTO TODO VALUES(1, 'Học Java', 'Học Java cơ bản', '27/2/2023', 'Bình thường', 1)," +
                "(2, 'Học React Native', 'Học React Native cơ bản', '24/3/2023', 'Khó', 0)," +
                "(3, 'Học Kotlin', 'Học kotlin cơ bản', '1/4/2023', 'Dễ', 0)";
        sqliteDatabase.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int i, int i1) {
        // Khi upgrade database ta cần kiểm tra version hiện tại version khi ta upgrade có khác nhau hay không
        // Nếu có thực hiện câu lệnh xóa bảng và khởi tạo lại
        if (i != i1) {
            // Xóa barng nếu tồn tại
            sqliteDatabase.execSQL("DROP TABLE IF EXISTS TODO");
            // Gọi lại hàm onCreate
            onCreate(sqliteDatabase);
        }
    }
}
package com.example.sqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{

            val database=openOrCreateDatabase("Products",Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS products(id INTEGER PRIMARY KEY,name VARCHAR,price INT)")
            //database.execSQL("INSERT INTO products (name,price) VALUES ('Ayakkabi',100)")
            //database.execSQL("INSERT INTO products (name,price) VALUES ('Elbise',150)")
            //database.execSQL("INSERT INTO products (name,price) VALUES ('Atkı',50)")
            //database.execSQL("INSERT INTO products (name,price) VALUES ('Eldiven',20)")

            //val cursor=database.rawQuery("SELECT * FROM products",null)


            val cursor=database.rawQuery("SELECT * FROM products WHERE id='5'",null)

            val idColomnIndex=cursor.getColumnIndex("id")
            val nameColomnIndex=cursor.getColumnIndex("name")
            val priceColomnIndex=cursor.getColumnIndex("price")

            while(cursor.moveToNext())
            {
                textView.text=cursor.getInt(idColomnIndex).toString()
                textView2.text=cursor.getString(nameColomnIndex).toString()
                textView3.text=cursor.getInt(priceColomnIndex).toString()
            }

            cursor.close()


        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
}
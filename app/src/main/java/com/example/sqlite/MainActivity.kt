package com.example.sqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{

            val database=openOrCreateDatabase("Products",Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS products(id INTEGER PRIMARY KEY,name VARCHAR,fiyat INT)")
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
}
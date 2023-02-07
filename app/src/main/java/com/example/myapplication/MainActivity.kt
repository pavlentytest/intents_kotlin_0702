package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // https://developer.android.com/training/basics/intents/result
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == MainActivity2.CODE) {
            val str = result.data!!.getStringExtra(MainActivity2.KEY2)
            Toast.makeText(
                applicationContext,
                str,
                Toast.LENGTH_LONG).show();

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "https://mirea.ru";
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            // неявное намерение
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener {
            // явное намерение
            val intent = Intent(applicationContext,MainActivity2::class.java)
            intent.putExtra(KEY,getString(R.string.hello));
           // startActivity(intent)
            startForResult.launch(intent);

        }
    }

    companion object {
        const val KEY = "key"
    }
}
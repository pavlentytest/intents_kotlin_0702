package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras
        val data = bundle?.getString(MainActivity.KEY)
        Snackbar.make(findViewById(R.id.root2), data.toString(), Snackbar.LENGTH_LONG).show();

        val btn3: Button = findViewById(R.id.button3)
        val editText: EditText = findViewById(R.id.editTextTextPersonName)
        btn3.setOnClickListener {
            val intent = Intent()
            intent.putExtra(Companion.KEY2, editText.getText().toString())
            setResult(Companion.CODE, intent)
            finish() // активность завершает работу


        }

    }

    companion object {
        const val KEY2 = "key2"
        const val CODE = 200
    }
}
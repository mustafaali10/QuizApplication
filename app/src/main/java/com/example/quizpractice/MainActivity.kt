package com.example.quizpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val startBtn:Button=findViewById(R.id.btn_start)
val name:EditText=findViewById(R.id.name)

        startBtn.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
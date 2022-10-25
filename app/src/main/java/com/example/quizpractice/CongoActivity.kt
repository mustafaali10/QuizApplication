package com.example.quizpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CongoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congo)

        val pname:TextView=findViewById(R.id.p_name)
        val score:TextView=findViewById(R.id.score_brd)
        val finishBtn:Button=findViewById(R.id.finish_btn)

        pname.text=intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        score.text="Your Score is $correctAnswers out of $totalQuestions"

        finishBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
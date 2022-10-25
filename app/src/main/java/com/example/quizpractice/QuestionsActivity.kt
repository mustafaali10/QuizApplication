package com.example.quizpractice

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButtonToggleGroup
import org.w3c.dom.Text

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var questionImage:ImageView?=null
    private var questionText:TextView?=null
    private var progressBar:ProgressBar?=null
    private var progressQuestion:TextView?=null

    private var mCurrentPosition:Int=1
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0
    private var mQuestionsList:ArrayList<Question>?=null
    private var mUserName:String?=null

    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null
    private var submitButton:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
         questionImage=findViewById(R.id.question_image)
         questionText=findViewById(R.id.question_text)
         progressBar=findViewById(R.id.progress_bar)
         progressQuestion=findViewById(R.id.question_number)

         optionOne=findViewById(R.id.option_One)
         optionTwo=findViewById(R.id.option_Two)
         optionThree=findViewById(R.id.option_Three)
         optionFour=findViewById(R.id.option_Four)

         submitButton=findViewById(R.id.Submit_Button)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)


        mQuestionsList=Constants.getQuestions()
        if(mCurrentPosition<=mQuestionsList!!.size)

        setQuestion()
    }

    private fun setQuestion() {

        defaultOptionsView()

        val question:Question=mQuestionsList!![mCurrentPosition-1] //getting the 0th question
        questionImage?.setImageResource(question.image) //getting the 0th question details from the val question
        questionText?.text = question.question
        progressBar?.progress=mCurrentPosition
        progressQuestion?.text="$mCurrentPosition/${progressBar?.max}"
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition<=mQuestionsList!!.size){
            submitButton?.text="SUBMIT"
        }
        else {
            submitButton?.text="NEXT"
        }




    }


    private fun defaultOptionsView() {
        val options=ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let {
            options.add(1,it)
        }

        optionThree?.let {
            options.add(2,it)
        }
        optionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_bg)
        }
    }

    private fun selectedOptionView(option: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition=selectedOptionNum
        option.setTextColor(Color.parseColor("#363A43"))
        option.setTypeface(option.typeface,Typeface.BOLD)
        option.background=ContextCompat.getDrawable(this,R.drawable.selection_option_bg)


    }

    override fun onClick(view:View?){
        when(view?.id){
            R.id.option_One->{
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }

            R.id.option_Two->{
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }

            R.id.option_Three->{
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }

            R.id.option_Four->{
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }


            R.id.Submit_Button->{

                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when
                    {
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }

                        else->{
                            val intent=Intent(this,CongoActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName) //sending the mUserName to Constant
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }


                }

                else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)

                    if(question!!.correctAnswer!=mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_bg)
                    }
                    else{mCorrectAnswers++}
                    answerView(question.correctAnswer,R.drawable.correct_option_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        submitButton?.text="FINISH"
                    }
                    else{
                        submitButton?.text="NEXT"
                    }
                    mSelectedOptionPosition=0
                    }


                }


            }
        }


    private fun answerView(correctAnswer: Int, drawableView: Int) {
        when(correctAnswer){

            1->{
                optionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }

            2->{
                optionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            }

            3->{
                optionThree?.background=ContextCompat.getDrawable(this,drawableView)
            }

            4->{
                optionFour?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }

    }



}
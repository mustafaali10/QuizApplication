package com.example.quizpractice

object Constants {
    const val USER_NAME:String="user_name"
    const val CORRECT_ANSWERS:String="correct_answers"
    const val TOTAL_QUESTIONS:String="total_questions"

    fun getQuestions():ArrayList<Question>
    {

        val questionslist= ArrayList<Question>()
        val que1=Question(1,R.drawable.grp,"Brothers Since:",
            "5 years","10 years","15 years","Since Birth",4)

        questionslist.add(que1)

        val que2=Question(2,R.drawable.mustafa1,"Ibteda:","Ghar","Gaadi","Chai","Jayedaad",3)
        questionslist.add(que2)

        val que3=Question(3, R.drawable.mustafa2,"Inteha-e-Mohabbat : ",
            "Ghar","Gaadi",
            "Jaayedaad","Chai",4)

        questionslist.add(que3)

        //4

        val que4=Question(4, R.drawable.akash1,"My Date of Birth is : ",
            "11 June","11 Feb",
            "11 May","11 July",2)

        questionslist.add(que4)

        //5

        val que5=Question(5,R.drawable.malik1,"Aapku Toh Maloom Mama Mera _Kya Hai ! : ",
            "Iraada","Marzi",
            "Maqsad","Dil",3)

        questionslist.add(que5)

        //6

        val que6=Question(6,R.drawable.rahilhorse,"Ghode Pe Baithe  : ",
            "Diwaane","Sanki",
            "Paagal","Hero",1)

        questionslist.add(que6)


        //7
        val que7=Question(1, R.drawable.akash2,"Others: Kirrak Hai Mama Yeh ! " +
                "Akash Maamu :",
            "Zabardast","Lajawab",
            "Jhakaas","Behtreen",3)

        questionslist.add(que7)

        //8
        val que8=Question(1,R.drawable.rahil1,"Bekar Ke Plans Banaane Ki Aadat Kisku Hai : ",
            "Mustafa","Malik",
            "Akash","Rahil",4)

        questionslist.add(que8)

        //9
        val que9=Question(1,R.drawable.akashrahil,"Yeh Logan Aaj Chodke Last Time Kab Dikhe The Malleplly Mein ? ",
            "2 years","1 years",
            "6 months","Parsu ich Aaye Bolte ",4)

        questionslist.add(que9)

        //10

        val que10=Question(1,R.drawable.grp,"Brothers Till : ",
            "Death","10 years",
            "15 years","20 years",1)

        questionslist.add(que10)

        return questionslist   }
}
package com.example.cb2_tic_tac_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import kotlinx.coroutines.delay
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button

    lateinit var txt:TextView

    lateinit var winner:String

    var draw:Int=0
    var alreadywon:Int=0

    var b1:String=""
    var b2:String=""
    var b3:String=""
    var b4:String=""
    var b5:String=""
    var b6:String=""
    var b7:String=""
    var b8:String=""
    var b9:String=""
    var flag:Int=1
    var count:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        txt=findViewById<TextView>(R.id.txt)
        btn1=findViewById<Button>(R.id.btn1)
        btn2=findViewById<Button>(R.id.btn2)
        btn3=findViewById<Button>(R.id.btn3)

        btn4=findViewById<Button>(R.id.btn4)
        btn5=findViewById<Button>(R.id.btn5)
        btn6=findViewById<Button>(R.id.btn6)

        btn7=findViewById<Button>(R.id.btn7)
        btn8=findViewById<Button>(R.id.btn8)
        btn9=findViewById<Button>(R.id.btn9)

        //have to call all function to start the game like initializer...



        initializer()

        var message=intent.getStringExtra( "message_id_play_again")
        if(message=="1") {
            initializer()
        }

    }
    private fun initializer() {
        count=0
        flag=1
        draw=0
        new_game()//this is working fine,
        // maine ckeck kiya tha mai pahle kuch
        // text deke kiya to isne wo text hta diya
    }
    fun check_btn(view: View) {
        var temp:Button=(view as Button)
        if(flag==1&&temp.text==""&&alreadywon==0)
        {
            count++
            (view).setText("X")//iska problem hi nahi hai
            flag = 0
        }
        else if(flag==0&&temp.text==""&&alreadywon==0)
        {
            count++
            (view).setText("O")
            flag=1
        }

        if(count>4)
        {
            b1=btn1.text.toString()
            b2=btn2.text.toString()
            b3=btn3.text.toString()
            b4=btn4.text.toString()
            b5=btn5.text.toString()
            b6=btn6.text.toString()
            b7=btn7.text.toString()
            b8=btn8.text.toString()
            b9=btn9.text.toString()
        }

        //conditions
        if(alreadywon==1)
        {
            call_activity()
        }
        else if(b1==b2 && b2==b3 && b1!="")//row1
        {
            txt.text="btn1_2_3"
            alreadywon=1
            Toast.makeText(this, "btn1_2_3", Toast.LENGTH_SHORT).show()
            if(flag==1)
            {
                winner="O"//we have to take opposite her because we just change it above
            }
            call_activity()

        }
        else if (b4==b5 && b5==b6 && b4!="")//row2
        {
            alreadywon=1
            txt.text="btn4_5_6"
            Toast.makeText(this, "btn4_5_6", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b7==b8 && b8==b9 && b7!="")//row3
        {
            alreadywon=1
            txt.text="btn7_8_9"
            Toast.makeText(this, "btn7_8_9", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b1==b4 && b4==b7 && b1!="")//col1
        {
            alreadywon=1
            txt.text="btn1_4_7"
            Toast.makeText(this, "btn1_4_7", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b2==b5 && b5==b8 && b2!="")//col2
        {
            alreadywon=1
            txt.text="btn2_5_8"
            Toast.makeText(this, "btn2_5_8", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b3==b6 && b6==b9 && b3!="")//col3
        {
            alreadywon=1
            txt.text="btn3_6_9"
            Toast.makeText(this, "btn3_6_9", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b1==b5 && b5==b9 && b1!="")//dia1
        {
            alreadywon=1
            txt.text="btn1_5_9"
            Toast.makeText(this, "btn1_5_9", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if (b3==b5 && b5==b7 && b3!="")//dia2
        {
            alreadywon=1
            txt.text="btn3_5_7"
            Toast.makeText(this, "btn3_5_7", Toast.LENGTH_SHORT).show()
            call_activity()
        }
        else if(count>=9)
        {
            alreadywon=1
            txt.text="match draw"
            draw=1
            Toast.makeText(this, "Wait we are starting game again", Toast.LENGTH_SHORT).show()
            call_activity()
        }
    }
    fun new_game()
    {
        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""
        btn9.text=""
    }

    private fun call_activity()
    {
        if(flag==1)
        {
            winner="O"//we have to take opposite her because we just change it above
        }
        else{
            winner="X"
        }

        //here ill pass who wone and by what way but let it now do other things first
        var message:String="not_draw"
        if(draw==1)
        {
            message="draw"//or give nay value no need we are only comparing not_draw there
        }



        var intent=Intent(this,Nextpage::class.java)
        intent.putExtra("message_id_1",message)
        intent.putExtra("winner_id_1",winner)
        startActivity(intent)

    }
}
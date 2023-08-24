package com.example.cb2_tic_tac_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Nextpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)

        var message=intent.getStringExtra( "message_id_1")
        var winner=intent.getStringExtra( "winner_id_1")


        findViewById<TextView>(R.id.result_txt_of_result_page).apply {
            if(message=="not_draw")
            {
                text="Person  "+winner+"  won the match "
            }
            else{
                text="match draw  "
            }

        }


        var btn_exit=findViewById<Button>(R.id.exit_btn)
        btn_exit.setOnClickListener {
            finishAffinity()
        }

        var play_again_btn=findViewById<Button>(R.id.play_again_btn)
        play_again_btn.setOnClickListener {
            play_again_intent()
        }

    }
    private fun play_again_intent()
    {
        var intent= Intent(this,MainActivity::class.java)
        intent.putExtra("message_id_play_again","1")
        startActivity(intent)
    }
}
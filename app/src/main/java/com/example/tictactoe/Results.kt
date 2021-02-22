package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_results.*

class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
var p1=intent.getIntExtra("P1",0)
        var p2=intent.getIntExtra("P2",0)
        p1_result.text=p1.toString()
p2_result.text=p2.toString()

        if(p1>p2){
            winner_val.text="Player 1"

        }

        else{
            winner_val.text="Player 2"

        }


        play_again.setOnClickListener {

            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }
}
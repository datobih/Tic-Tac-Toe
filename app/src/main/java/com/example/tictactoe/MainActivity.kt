package com.example.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.round_choice.*
import java.lang.Exception
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var roundNo:Int=0

start_game.setOnClickListener {

    var options= Dialog(this)
    options.setContentView(R.layout.round_choice)


(options.select_round).setOnClickListener {

    try{
        roundNo=(options.rounds_no).text.toString().toInt()



    }
catch(e:NumberFormatException){
    Toast.makeText(this,"Wrong Value Inputted,Try Again",Toast.LENGTH_SHORT).show()

}
    if(roundNo>0){
       var intent=Intent(this,Game::class.java)

        intent.putExtra("ROUND",roundNo)

        startActivity(intent)
finish()

    }

    else{

        Toast.makeText(this,"Wrong Value Inputted,Try Again",Toast.LENGTH_SHORT).show()

    }



options.dismiss()
}

    options.show()

}
    }
}
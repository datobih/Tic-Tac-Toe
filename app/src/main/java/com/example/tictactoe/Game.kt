package com.example.tictactoe

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.round_choice.view.*

class Game : AppCompatActivity() {
var p1Score=0
    var p2Score=0
    var refresh:TextView?=null
    var mConstraintLayout:ConstraintLayout?=null
    var mConstraintSet=ConstraintSet()
    var recycle:Boolean?=null
    var round:Int=0
    var totalRound:Int?=null
    var tries=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        next_round.visibility=View.INVISIBLE
round=1
        totalRound=intent.getIntExtra("ROUND",0)
Log.d("CHECK",totalRound.toString())


refresh=p1


        mConstraintLayout=game_constraint
    }
    var pSide=true



    fun onTap(view: View) {
        if(round==totalRound){
            next_round.text="Results"
        }



        var topH=false
        var midH=false
        var lowH=false

        var leftV=false
        var midV=false
        var rightV=false


        var rightDiag=false
        var leftDiag=false


        cross.visibility=View.INVISIBLE

        var inputTxt = (view as TextView)
        if (inputTxt.text.isEmpty()|| inputTxt.text=="  ") {
            tries++
            if (pSide == true) {
                inputTxt.setPadding(0)
                inputTxt.setTextColor(ContextCompat.getColor(this, R.color.red))
                inputTxt.text = "X"

                refresh?.background = null
                refresh = p2
                refresh?.background = ContextCompat.getDrawable(this, R.drawable.on_turn)
                pSide = false
            } else {
                inputTxt.setPadding(0)
                inputTxt.setTextColor(ContextCompat.getColor(this, R.color.blue))
                inputTxt.text = "O"

                refresh?.background = null
                refresh = p1
                refresh?.background = ContextCompat.getDrawable(this, R.drawable.on_turn)
                pSide = true

            }


        }
      if ((top_left.text=="X"&& top_mid.text=="X" && top_right.text=="X")||(top_left.text=="O"&& top_mid.text=="O" && top_right.text=="O")){
          topH=true

      }


        else if ((mid_left.text=="X"&& mid_mid.text=="X" && mid_right.text=="X")||(mid_left.text=="O"&& mid_mid.text=="O" && mid_right.text=="O")){
            midH=true

        }

      else if ((low_left.text=="X"&& low_mid.text=="X" && low_right.text=="X")||(low_left.text=="O"&& low_mid.text=="O" && low_right.text=="O")){
          lowH=true

      }


        else if((top_left.text=="X" && mid_left.text=="X" && low_left.text=="X")||(top_left.text=="O" && mid_left.text=="O" && low_left.text=="O")){
          leftV=true

      }

      else if((top_mid.text=="X" && mid_mid.text=="X" && low_mid.text=="X")||(top_mid.text=="O" && mid_mid.text=="O" && low_mid.text=="O")){
          midV=true

      }


      else if((top_right.text=="X" && mid_right.text=="X" && low_right.text=="X")||(top_right.text=="O" && mid_right.text=="O" && low_right.text=="O")){
          rightV=true

      }

      else if((top_left.text=="X" && mid_mid.text=="X" && low_right.text=="X")||(top_left.text=="O" && mid_mid.text=="O" && low_right.text=="O")){
          rightDiag=true

      }

      else if((top_right.text=="X" && mid_mid.text=="X" && low_left.text=="X")||(top_right.text=="O" && mid_mid.text=="O" && low_left.text=="O")){
          leftDiag=true

      }



       if(topH==true){
check()

cross.rotation=0f

           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,180f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,140f,resources.displayMetrics).toInt()
           ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
           ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())
           cross.visibility=View.VISIBLE

       }

        else if(midH==true){

          check()
           cross.rotation=0f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,140f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())
           cross.visibility=View.VISIBLE
       }

       else if(lowH==true){

     check()
           cross.rotation=0f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,140f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,190f,resources.displayMetrics).toInt())
           cross.visibility=View.VISIBLE
       }

else if(leftV==true){
           check()
           cross.rotation=90f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,55f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())
cross.visibility=View.VISIBLE
       }

        else if(midV==true) {
check()
           cross.rotation=90f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,140f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())
           cross.visibility=View.VISIBLE

       }

        else if(rightV==true){

           check()
           cross.rotation=90f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,140f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())


           mConstraintSet.clone(mConstraintLayout)
           mConstraintSet.connect(R.id.cross,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
         mConstraintSet.connect(R.id.cross,ConstraintSet.LEFT,R.id.t_board,ConstraintSet.LEFT)

mConstraintSet.applyTo(mConstraintLayout)

           cross.visibility=View.VISIBLE

       }

        else if(rightDiag==true){

           check()
           cross.rotation=45f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())


           mConstraintSet.clone(mConstraintLayout)
           mConstraintSet.connect(R.id.cross,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
           mConstraintSet.connect(R.id.cross,ConstraintSet.LEFT,R.id.t_board,ConstraintSet.LEFT)

           mConstraintSet.applyTo(mConstraintLayout)

           cross.visibility=View.VISIBLE



       }

       else if(leftDiag==true){

           check()
           cross.rotation=-45f
           cross.setMargin( bottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt(),
                   leftMargin =TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt()
                   ,rightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
                   ,topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0f,resources.displayMetrics).toInt())


           mConstraintSet.clone(mConstraintLayout)
           mConstraintSet.connect(R.id.cross,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
           mConstraintSet.connect(R.id.cross,ConstraintSet.LEFT,R.id.t_board,ConstraintSet.LEFT)

           mConstraintSet.applyTo(mConstraintLayout)

           cross.visibility=View.VISIBLE



       }

        if(tries==9){
            recycle=true
        }

        if(recycle==true){

            next_round.visibility=View.VISIBLE
            next_round.setOnClickListener {


if(round<totalRound!!) {
    renew()
}
           else{
   var intent= Intent(this,Results::class.java)
    intent.putExtra("P1",p1Score)
    intent.putExtra("P2",p2Score)
    startActivity(intent)
finish()
           }


            }




        }



    }


    fun View.setMargin( leftMargin:Int?=null,rightMargin:Int?=null,topMargin:Int?=null,bottomMargin:Int?=null) {
        val params = layoutParams as ViewGroup.MarginLayoutParams

      params.setMargins(
              leftMargin?:params.leftMargin,
              topMargin?:params.topMargin,
             rightMargin?: params.rightMargin,
              bottomMargin?:params.bottomMargin
      )
        layoutParams = params
    }





    fun check(){
        if(pSide==false){
            p1Score++
            p1_score.text=p1Score.toString()
recycle=true
        }
        else if(pSide==true){
            p2Score++
            p2_score.text=p2Score.toString()
            recycle=true
        }




}

    fun renew()
    {
        refresh?.background = null
        refresh = p1
        refresh?.background = ContextCompat.getDrawable(this, R.drawable.on_turn)
        pSide = true



        round++
        cross.visibility=View.INVISIBLE
        mConstraintSet.clone(mConstraintLayout)
        mConstraintSet.connect(R.id.cross,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
        mConstraintSet.connect(R.id.cross,ConstraintSet.RIGHT,R.id.r_stroke,ConstraintSet.RIGHT)
mConstraintSet.connect(R.id.cross,ConstraintSet.TOP,R.id.r_stroke,ConstraintSet.TOP)
        mConstraintSet.connect(R.id.cross,ConstraintSet.BOTTOM,R.id.r_stroke,ConstraintSet.BOTTOM)


        clear()

        round_no.text=round.toString()


        next_round.visibility=View.INVISIBLE
    }

    fun clear() {

        top_left.text = "  "
        top_mid.text = "  "
        top_right.text = "  "
        mid_left.text = "  "
        mid_mid.text = "  "
        mid_right.text = "  "
        low_left.text = "  "
        low_mid.text = "  "
        low_right.text = "  "
recycle=false
        tries=0


    }

    }



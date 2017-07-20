package com.zzmachine.rocknegi.tictacktoe1pvcpu

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class  MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun onClickEvent(view: View) {
        val buttonSelected = view as Button
        var selectId = 0
        when (buttonSelected.id) {
            R.id.button1 -> selectId = 1
            R.id.button2 -> selectId = 2
            R.id.button3 -> selectId = 3
            R.id.button4 -> selectId = 4
            R.id.button5 -> selectId = 5
            R.id.button6 -> selectId = 6
            R.id.button7 -> selectId = 7
            R.id.button8 -> selectId = 8
            R.id.button9 -> selectId = 9
        }
        // Toast.makeText(this, "ID:" + selectId, Toast.LENGTH_LONG).show()
        playGame(selectId,buttonSelected)

    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer=1
    fun playGame(selectId:Int,buttonSelected:Button){

        if (activePlayer==1){
            buttonSelected.text="X"
            buttonSelected.setBackgroundResource(R.color.blue)
            player1.add(selectId)
            activePlayer=2
            autoPlay()
        }
        else{
            buttonSelected.text="O"
            buttonSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(selectId)
            activePlayer=1

        }


        buttonSelected.isEnabled=false
        checkWinner()

    }

    fun checkWinner(){
        var winner =-1


        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3))
            winner=1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7))
            winner=1
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9))
            winner=1
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7))
            winner=1
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9))
            winner=1
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
            winner=1
        if(player1.contains(7)&&player1.contains(5)&&player1.contains(3))
            winner=1
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
            winner=1



        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3))
            winner=2
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7))
            winner=2
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
            winner=2
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
            winner=2
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9))
            winner=2
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
            winner=2
        if(player2.contains(7)&&player2.contains(5)&&player2.contains(3))
            winner=2
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
            winner=2

        if(winner==1)
            Toast.makeText(this,"player 1 won the game",Toast.LENGTH_LONG).show()

        if(winner==2)
            Toast.makeText(this,"player 2 won the game",Toast.LENGTH_LONG).show()


    }

    fun autoPlay(){
        var emptyCell=ArrayList<Int>()
            for(cellId in 1..9){
                if(! player1.contains(cellId) || player2.contains(cellId)){
                    emptyCell.add(cellId)

                }
            }

        var rand =Random()
        val randIndex = rand.nextInt(emptyCell.size-0)

        val cellId = emptyCell.get(randIndex)

        var buttonSelect:Button?
        when(cellId){
            1-> buttonSelect=button1
            2-> buttonSelect=button2
            3-> buttonSelect=button3
            4-> buttonSelect=button4
            5-> buttonSelect=button5
            6-> buttonSelect=button6
            7-> buttonSelect=button7
            8-> buttonSelect=button8
            9-> buttonSelect=button9
            else->{
                buttonSelect=button1
            }
        }

        playGame(cellId,buttonSelect)

    }





}



























package com.plarium.raid.wh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.plarium.raid.R

class Game : AppCompatActivity() {
    lateinit var enemyPic: ImageView
    lateinit var playerPic: ImageView
    val choices = mutableListOf<String>("Princess", "Eye", "Lotus")
    var playerscore = 0
    var enemyscore = 0
    lateinit var playerScoreText: TextView
    lateinit var enemyScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        MaterialAlertDialogBuilder(this@Game)
            .setTitle("Simple Rules")
            .setMessage("Princess defeats Lotus, Eye defeats Princess, Lotus defeats Eye")
            .setCancelable(false)
            .setPositiveButton("Play"){dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()

        enemyPic = findViewById(R.id.enemy_pic)
        playerPic = findViewById(R.id.player_pic)

        playerScoreText = findViewById(R.id.player_score_text)
        enemyScoreText = findViewById(R.id.enemy_score_text)

    }
    fun rock(v: View){
        playerPic.setImageResource(R.drawable.three)
        val enemychoice = choices.random()
        when (enemychoice){
            "Princess" -> {enemyPic.setImageResource(R.drawable.three)}

            "Eye" -> {enemyPic.setImageResource(R.drawable.one)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()

            }

            "Lotus" -> {enemyPic.setImageResource(R.drawable.two)
                playerscore++
                playerScoreText.text = playerscore.toString()

            }

        }


    }

    fun paper(v: View){
        playerPic.setImageResource(R.drawable.one)
        val enemychoice = choices.random()
        when (enemychoice){
            "Princess" -> {enemyPic.setImageResource(R.drawable.three)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Eye" -> {enemyPic.setImageResource(R.drawable.one)}

            "Lotus" -> {enemyPic.setImageResource(R.drawable.two)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

        }
    }

    fun scissors(v: View) {
        playerPic.setImageResource(R.drawable.two)
        val enemychoice = choices.random()
        when (enemychoice) {
            "Princess" -> {
                enemyPic.setImageResource(R.drawable.three)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()
            }

            "Eye" -> {
                enemyPic.setImageResource(R.drawable.one)
                playerscore++
                playerScoreText.text = playerscore.toString()
            }

            "Lotus" -> {
                enemyPic.setImageResource(R.drawable.two)
            }

        }
    }


}
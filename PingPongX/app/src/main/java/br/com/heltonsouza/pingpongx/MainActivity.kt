package br.com.heltonsouza.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btFinishMatch.setBackgroundColor(resources.getColor(R.color.colorYellow))
        btFinishMatch.setTextColor(resources.getColor(R.color.colorBlue))

        Log.d("ESTADO", "onCreate")


        if (savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt(Constants.KEY_PLAYER_ONE_SCORE, 0)
            playerTwoScore = savedInstanceState.getInt(Constants.KEY_PLAYER_TWO_SCORE, 0)
        }

        setUpPlayers()
        setUpListeners()
    }

    var playerOneScore = 0
    var playerTwoScore = 0

    private fun setUpListeners() {
        btPlayerOneScore.setOnClickListener {
            playerOneScore++
            setUpScorePlayerOne()
        }

        btPlayerTwoScore.setOnClickListener {
            playerTwoScore++
            setUpScorePlayerTwo()
        }

        btRevenge.setOnClickListener {
            rematch()
        }

        btFinishMatch.setOnClickListener {
            val telaPlayer = Intent(this, PlayerActivity::class.java)
            telaPlayer.putExtra("rematch", true)
            startActivityForResult(telaPlayer, 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        intent = data
        setUpPlayers()
        rematch()
    }

    private fun setUpScorePlayerOne() {
        tvPlayerOneScore.text = playerOneScore.toString()
    }

    private fun setUpScorePlayerTwo() {
        tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_ONE)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_TWO)
    }

    private fun rematch() {
        playerOneScore = 0
        playerTwoScore = 0
        setUpScorePlayerTwo()
        setUpScorePlayerOne()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.KEY_PLAYER_ONE_SCORE, playerOneScore)
        outState.putInt(Constants.KEY_PLAYER_TWO_SCORE, playerTwoScore)
    }

//    btFinishMatch.setOnClickListener {
//        val telaPlayer = Intent(this, PlayerActivity::class.java)
//        startActivity(telaPlayer)
//        finish()
//    }


    override fun onStart() {
        super.onStart()
        Log.d("ESTADO", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ESTADO", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ESTADO", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ESTADO", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ESTADO", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ESTADO", "onDestroy")
    }
}



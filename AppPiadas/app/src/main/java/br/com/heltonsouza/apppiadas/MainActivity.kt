package br.com.heltonsouza.apppiadas

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btTellJoker.setOnClickListener {
            showJoker()
            playSong()
        }

        showJoker()
    }

    private fun showJoker() {
        val jokers = resources.getStringArray(R.array.jokers)
        val numberJoker:Int = Random.nextInt(jokers.size)
        val joker:String = jokers[numberJoker]
        tvJoker.text = joker
    }

    private fun playSong(){
        val mediaPlayer = MediaPlayer.create(this, R.raw.badumtss)
        mediaPlayer.start()
    }
}

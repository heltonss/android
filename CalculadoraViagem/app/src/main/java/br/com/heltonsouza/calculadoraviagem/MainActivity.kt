package br.com.heltonsouza.calculadoraviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = Html.fromHtml("<sup><small>R$</small></sup> 0")

        btCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        var distance:Int = etDistance.text.toString().toInt()
        var priceFuel = etPriceFuel.text.toString().toInt()
        var kms = etKm.text.toString().toInt()

        var result =  distance + priceFuel + kms

        tvResult.text = Html.fromHtml("<sup><small>R$</small></sup> $result");
    }
}

package br.com.heltonsouza.calculadoraviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import br.com.heltonsouza.calculadoraviagem.extensions.format
import br.com.heltonsouza.calculadoraviagem.watchers.DecimalTextWatchers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPriceFuel.addTextChangedListener(DecimalTextWatchers(etPriceFuel,2))

        tvResult.text = Html.fromHtml("<sup><small>R$</small></sup> 0")

        btCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        var distance = etDistance.text.toString().toDouble()
        var priceFuel = etPriceFuel.text.toString().toDouble()
        var kms = etKm.text.toString().toDouble()

        val media = distance / kms

        var result =  media * priceFuel

//        tvResult.text = Html.fromHtml("<sup><small>R$</small></sup> ${result.format(2)}");
        tvResult.text = getString(R.string.result, result.format(2))

    }
}

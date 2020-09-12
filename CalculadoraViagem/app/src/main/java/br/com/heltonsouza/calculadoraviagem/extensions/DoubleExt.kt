package br.com.heltonsouza.calculadoraviagem.extensions

fun Double.format(digits: Int) = "%.${digits}f".format(this)

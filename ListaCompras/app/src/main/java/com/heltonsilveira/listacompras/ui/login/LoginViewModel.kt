package com.heltonsilveira.listacompras.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heltonsilveira.listacompras.models.RequestState
import com.heltonsilveira.listacompras.models.Usuario
import com.heltonsilveira.listacompras.repository.UsuarioRepository

class LoginViewModel : ViewModel() {
    private  val usuarioRepository = UsuarioRepository();

    val loginState = MutableLiveData<RequestState<Boolean>>()

    fun logar(usuario: Usuario){
        loginState.value = usuarioRepository.logar(usuario).value

    }
}
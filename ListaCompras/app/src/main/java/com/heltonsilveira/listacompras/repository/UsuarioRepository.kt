package com.heltonsilveira.listacompras.repository

import androidx.lifecycle.MutableLiveData
import com.heltonsilveira.listacompras.models.RequestState
import com.heltonsilveira.listacompras.models.Usuario

class UsuarioRepository {

    fun logar(usuario: Usuario): MutableLiveData<RequestState<Boolean>> {

        val response = MutableLiveData<RequestState<Boolean>>()

        response.value = RequestState.Loading
        if (usuario.email == "usuario@fiap.com.br" && usuario.senha == "123") {
            response.value = RequestState.Success(true)
        } else {
            response.value = RequestState.Error(Throwable("Usuário ou senha inválidos"))
        }
        return response
    }

}
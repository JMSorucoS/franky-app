package com.calyrsoft.frankyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private var user = "user"
    private var pass="123"
    val cadena: LiveData<String>
        get() = _cadena
    private val _cadena = MutableLiveData<String>()

    fun verify(name: String, key: String) {
        if(name==user && pass ==key)
            _cadena.value="Datos Correctos"
        else if(name!=user)
            _cadena.value="No existe el usuario"
        else
            _cadena.value="Contraseña incorrecta"
    }
}
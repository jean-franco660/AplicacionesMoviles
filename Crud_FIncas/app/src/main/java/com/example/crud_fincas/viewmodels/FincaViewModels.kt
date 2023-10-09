package com.example.crud_fincas.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud_fincas.models.Fincas
import com.example.crud_fincas.room.FincasDatabaseDao
import com.example.crud_fincas.states.FincasState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FincaViewModels(
    private val dao: FincasDatabaseDao
): ViewModel() {

    var state by mutableStateOf(FincasState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerFincas().collectLatest {
                state = state.copy(
                    listaFincas = it
                )
            }
        }
    }
    fun agregarFincas(fincas: Fincas) = viewModelScope.launch {
        dao.agregarFincas(fincas = fincas)
    }

    fun actualizarFincas(fincas: Fincas) = viewModelScope.launch {
        dao.agregarFincas(fincas = fincas)
    }

    fun borrarFincas(fincas: Fincas) = viewModelScope.launch {
        dao.agregarFincas(fincas = fincas)
    }
}



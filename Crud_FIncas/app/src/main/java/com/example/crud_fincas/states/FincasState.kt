package com.example.crud_fincas.states

import com.example.crud_fincas.models.Fincas

data class FincasState(
    val listaFincas: List<Fincas> = emptyList()
)

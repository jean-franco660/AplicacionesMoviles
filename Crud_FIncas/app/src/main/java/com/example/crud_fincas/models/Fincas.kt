package com.example.crud_fincas.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Fincas")
data class Fincas(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo("nombres")
    val nombres: String,

    @ColumnInfo("direccion")
    val direccion: String,

    @ColumnInfo("Numbero de Hectareas")
    val numHectareas: String,

    @ColumnInfo("departamento")
    val departamento: String,

    @ColumnInfo("provincia")
    val provincia: String,

    @ColumnInfo("distrito")
    val distrito: String,
)

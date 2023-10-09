package com.example.crud_fincas.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud_fincas.models.Fincas
import kotlinx.coroutines.flow.Flow
@Dao
interface FincasDatabaseDao {

    @Query("SELECT * FROM fincas")
    fun obtenerFincas(): Flow<List<Fincas>>

    @Query("SELECT * FROM fincas WHERE id = :id")
    fun obtenerFincas(id: Int): Flow<Fincas>


    @Insert
    suspend fun agregarFincas(fincas: Fincas)

    @Update
    suspend fun actualizarFincas(fincas: Fincas)

    @Delete
    suspend fun borrarFincas(fincas: Fincas)
}
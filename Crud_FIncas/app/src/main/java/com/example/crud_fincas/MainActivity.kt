package com.example.crud_fincas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.crud_fincas.navigation.navManager
import com.example.crud_fincas.room.FincasDataBase
import com.example.crud_fincas.ui.theme.Crud_FIncasTheme
import com.example.crud_fincas.viewmodels.FincaViewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Crud_FIncasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, FincasDataBase::class.java, "db_fincas").build()
                    val dao = database.fincasDao()

                    val viewModels = FincaViewModels(dao)
                    navManager(viewModels = viewModels)

                }
            }
        }
    }
}


package com.example.crud_fincas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crud_fincas.models.Fincas
import com.example.crud_fincas.viewmodels.FincaViewModels



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(navController: NavController, viewModel: FincaViewModels, id: Int, nombres: String?, direccion: String?, numHectareas: String?, departamento: String?, provincia: String?, distrito: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {


        ContentEditarView(it, navController, viewModel, id, nombres, direccion, numHectareas, departamento, provincia, distrito)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditarView(it: PaddingValues, navController: NavController, viewModel: FincaViewModels, id: Int, nombres: String?, direccion: String?, numHectareas: String?, departamento: String?, provincia: String?, distrito: String?) {
    var nombres by remember { mutableStateOf(nombres) }
    var direccion by remember { mutableStateOf(direccion) }
    var numHectareas  by remember { mutableStateOf(numHectareas) }
    var departamento by remember { mutableStateOf(departamento) }
    var provincia by remember { mutableStateOf(provincia) }
    var distrito by remember { mutableStateOf(distrito) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombres ?: "",
            onValueChange = { nombres = it },
            label = { Text(text = "Nombres") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = direccion ?: "",
            onValueChange = { direccion = it },
            label = { Text(text = "Direccion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = numHectareas ?: "",
            onValueChange = { numHectareas = it },
            label = { Text(text = "Numero de Hectareas") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = departamento ?: "",
            onValueChange = { departamento = it },
            label = { Text(text = "Departamento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = provincia ?: "",
            onValueChange = { provincia = it },
            label = { Text(text = "Provincia") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = distrito ?: "",
            onValueChange = { distrito = it },
            label = { Text(text = "Distrito") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val fincas = Fincas(
                    id = id,
                    nombres = nombres!!,
                    direccion = direccion!!,
                    numHectareas = numHectareas!!,
                    departamento = departamento!!,
                    provincia = provincia!!,
                    distrito = distrito!!
                )
                viewModel.actualizarFincas(fincas)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}
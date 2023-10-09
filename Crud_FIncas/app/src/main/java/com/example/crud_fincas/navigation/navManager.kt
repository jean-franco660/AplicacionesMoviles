package com.example.crud_fincas.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.crud_fincas.viewmodels.FincaViewModels
import com.example.crud_fincas.views.AgregarView
import com.example.crud_fincas.views.InicioView
import com.example.crud_fincas.views.EditarView
@Composable
fun navManager(viewModels: FincaViewModels) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio"){
        composable("inicio"){
            InicioView(navController, viewModels)
        }

        composable("agregar"){
            AgregarView(navController, viewModels)
        }

        composable("editar/{id}/{nombre}/{direccion}/{numHectareas}/{departamento}/{provincia}/{distrito}", arguments = listOf(
            navArgument("id") {type = NavType.IntType},
            navArgument("nombre") {type = NavType.StringType} ,
            navArgument("direccion") {type = androidx.navigation.NavType.StringType},
            navArgument("numHectareas") {type = androidx.navigation.NavType.StringType},
            navArgument("departamento") {type = androidx.navigation.NavType.StringType},
            navArgument("distrito") {type = androidx.navigation.NavType.StringType},
            navArgument("provincia") {type = androidx.navigation.NavType.StringType}

        )) {
            EditarView(
                navController,
                viewModels,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre"),
                it.arguments?.getString("direccion"),
                it.arguments?.getString("numHectaras"),
                it.arguments?.getString("departamento"),
                it.arguments?.getString("provincia"),
                it.arguments?.getString("distrito")
            )
        }
    }
}
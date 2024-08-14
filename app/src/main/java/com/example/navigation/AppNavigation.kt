package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(){

    val navController = rememberNavController()

   NavHost(navController = navController, startDestination =Routes.scree_A, builder =  {
       composable(Routes.scree_A,){
           ScreenA(navController)

       }
       composable(Routes.scree_B+"/{name}",){

            val name=it.arguments?.getString("name")
           ScreenB(name?:"meremjrej")

       }



   })

}
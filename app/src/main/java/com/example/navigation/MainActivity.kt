package com.example.navigation

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationDrawer()
                }
            }
        }


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(){


    val navigationController = rememberNavController()
    val  coroutineScope= rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext


    ModalNavigationDrawer(
        drawerState=drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet( modifier = Modifier.width(250.dp) ) {
                Box(
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .background(Color.Cyan,
                            shape = RoundedCornerShape(
                                topStart = 16.dp,  // Customize the top left corner radius
                                topEnd = 16.dp,    // Customize the top right corner radius
                                bottomEnd = 0.dp,  // No rounding for the bottom right corner
                                bottomStart = 0.dp
                            )
                            )

                ) {
                    // Your content inside the Box
                }


            Divider()
                NavigationDrawerItem(label = { Text(text = "Home", color = Color.Black) },
                    selected =false ,
                    icon={ Icon(imageVector = Icons.Default.Home, contentDescription ="home", tint = Color.Green )  },

                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screen.Home.screen){
                            popUpTo(0)
                        }

                    })  //------------End of the Home NavigationItem-----------------------



                Divider()
                NavigationDrawerItem(label = { Text(text = "Profile", color = Color.Black) },
                    selected =false ,
                    icon={ Icon(imageVector = Icons.Default.Person, contentDescription ="profile", tint = Color.Green )  },

                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screen.Profile.screen){
                            popUpTo(0)
                        }

                    })  //------------End of the Profile NavigationItem-----------------------



                Divider()
                NavigationDrawerItem(label = { Text(text = "Settings", color = Color.Black) },
                    selected =false ,
                    icon={ Icon(imageVector = Icons.Default.Settings, contentDescription ="settings", tint = Color.Green )  },

                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screen.Settings.screen){
                            popUpTo(0)
                        }

                    })    //------------End of the Settings NavigationItem-----------------------





                Divider()
                NavigationDrawerItem(label = { Text(text = "Logout", color = Color.Black) },
                    selected =false ,
                    icon={ Icon(imageVector = Icons.Default.ExitToApp, contentDescription ="logout", tint = Color.Green )  },

                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context,"Logout",Toast.LENGTH_SHORT).show()

                    })   //------------End of the Logout NavigationItem-----------------------



            }  //------------End of the ModalDrawerSheet-----------------------
            

        },   //------------End of the drawerContent-----------------------


        )    //------------End of the ModalNavigationDrawer----------------------

    {  ////*--------------------- Scaffold*********-------------------------

      Scaffold (
          topBar = {
              TopAppBar(title = { /*TODO*/ },
                  colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                      navigationIconContentColor = Color.Red
                  ),

                  navigationIcon ={
                      IconButton(onClick = {
                          coroutineScope.launch {
                              drawerState.open()
                          }
                      })

                      {
                          Icon(
                              Icons.Rounded.Menu, contentDescription = "MenuButton"
                          )

                      }
                  }//----------------------End of the  navigationIcon _____________________
              )

          }
      )//----------------------End of the Scaffold______________________



      {
         NavHost(navController = navigationController, startDestination =Screen.Home.screen ){
             composable(Screen.Home.screen){ Home()}
             composable(Screen.Profile.screen){ Profile() }
             composable(Screen.Settings.screen){ Settings() }
         }
      }





    }  ////*-----------End of the ---------- Scaffold*********-------------------------

    

    
    
} //////////-----------End of the fun NavigationDrawer()




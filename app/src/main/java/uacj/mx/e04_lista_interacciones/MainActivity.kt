package uacj.mx.e04_lista_interacciones

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uacj.mx.e04_lista_interacciones.ui.theme.E04_Lista_InteraccionesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            E04_Lista_InteraccionesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modificador = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onPause() {
        Log.v ("Aplicacion","Aplicacion pausada")
        super.onPause()
    }

    override fun onResume() {
        Log.v ("Aplicacion","Aplicacion resumida")
        super.onResume()
    }

}

@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {

    var clicks_realizados by remember { mutableStateOf(0) }
    var click_money by remember { mutableStateOf(0) }

    Column(modifier = Modifier.clickable {
        Log.v("APLICACION","Hola Mundo")
        clicks_realizados = clicks_realizados + 1
    }) {
        Text(
            text = "Hello $name!, ${clicks_realizados}",
            modifier = modificador.background(Color.Red)
        )
        Text(
            text = "Hello $name!, ${clicks_realizados}",
            modifier = modificador.background(Color.Blue)
        )
        Text(
            text = "Hello $name!, ${clicks_realizados}",
            modifier = modificador
        )
        Text(
            text = "Hello $name!, Haz hecho ${clicks_realizados} en toda la columna",
            modifier = modificador
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    E04_Lista_InteraccionesTheme {
        Greeting("Android")
    }
}
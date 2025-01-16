package com.example.calculadorajetpack2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = num1,
            onValueChange = {
                if (it.all { char -> char.isDigit() }) num1 = it
            },
            label = { Text("Primer número") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = {
                if (it.all { char -> char.isDigit() }) num2 = it
            },
            label = { Text("Segundo número") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = error,
            color= Color.Red,
            style = TextStyle(
                fontSize = 16.sp
            ))
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (num1.toString().isEmpty() || num2.toString().isEmpty()){
                    error="Ingrese dos números válidos"
                }else{
                    val n1 = num1.toIntOrNull() ?:0
                    val n2 = num2.toIntOrNull() ?:0
                    result = (n1 + n2).toString();
                    error="";
                    num1 = "";
                    num2 = "";
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            )

        ) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = result,
                style = TextStyle(
                fontSize = 32.sp
                ))
    }
}
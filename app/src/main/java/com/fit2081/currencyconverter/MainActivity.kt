package com.fit2081.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit2081.currencyconverter.data.repository.RatesRepository
import com.fit2081.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyConverterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CurrencyConverterScreen(modifier: Modifier) {
    var repository: RatesRepository = RatesRepository()
    var baseCurrency by remember { mutableStateOf("")}
    var targetCurrency by remember { mutableStateOf("")}
    var amount by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = baseCurrency,
            onValueChange = {baseCurrency = it},
            label = {Text("Base Currency")}
        )
        OutlinedTextField(
            value = targetCurrency,
            onValueChange = {targetCurrency = it},
            label = {Text("Target Currency")}
        )
        OutlinedTextField(
            value = amount,
            onValueChange = {amount = it},
            label = {Text("Amount")}
        )
        Button(
            onClick = {}
        ) {
            Text("Get Rate")
        }

        if (result.isNotEmpty()){
            Text(
                text = "Result: $result $targetCurrency",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }



    }
}
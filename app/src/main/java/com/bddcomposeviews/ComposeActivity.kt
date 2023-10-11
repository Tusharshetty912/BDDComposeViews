package com.bddcomposeviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier.semantics {  }){
    var username by remember {
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Login Screen", textAlign = TextAlign.Center)
        TextField(
            value = username, onValueChange = {username = it}, modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .testTag("emailTextField"),
            label = { Text(text = "Email")},
        )
        TextField(
            value = password, onValueChange = {password = it}, modifier = Modifier
                .padding(horizontal = 16.dp)
                .testTag("passwordTextField"),
            label = { Text(text = "Password")}
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Button(onClick = {  }, modifier = Modifier.testTag("loginButton")) {
            Text(text = "Submit")
        }
    }
}




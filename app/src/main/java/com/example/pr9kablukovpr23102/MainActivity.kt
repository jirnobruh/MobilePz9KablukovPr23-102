package com.example.pr9kablukovpr23102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.pr9kablukovpr23102.ui.theme.Pr9KablukovPr23102Theme

@OptIn(ExperimentalTvMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pr9KablukovPr23102Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoginScreen { login, password ->
                        // Здесь можно обработать нажатие "go"
                        // Например: перейти на следующий экран или показать Toast (на TV обычно логика навигации)
                        // Пока просто выводим в лог (или оставляем пустым)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
    val focusManager = LocalFocusManager.current

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "KARAOKE",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("login") },
            modifier = Modifier
                .width(700.dp)
                .focusable()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .width(700.dp)
                .focusable()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                focusManager.clearFocus(force = true)
                onLogin(login, password)
            },
            modifier = Modifier
                .width(300.dp)
                .focusable()
        ) {
            Text(text = "go")
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Preview(showBackground = true, widthDp = 1280, heightDp = 720)
@Composable
fun LoginScreenPreview() {
    Pr9KablukovPr23102Theme {
        Surface {
            LoginScreen { _, _ -> }
        }
    }
}

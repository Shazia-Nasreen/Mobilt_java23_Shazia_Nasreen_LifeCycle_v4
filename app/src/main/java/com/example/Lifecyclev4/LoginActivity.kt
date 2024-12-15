package com.example.Lifecyclev4

import android.os.Bundle


import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput = findViewById<EditText>(R.id.editTextUsername)
        val passwordInput = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Autoinloggning
        if (sharedPreferences.getBoolean("loggedIn", false)) {
            navigateToForm()
        }

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Kontrollera inloggning
            if (username == "admin" && password == "1234") {
                sharedPreferences.edit().putBoolean("loggedIn", true).apply()
                navigateToForm()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    private fun navigateToForm() {
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
        finish()
    }
}

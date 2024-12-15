package com.example.Lifecyclev4



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val usernameInput = findViewById<EditText>(R.id.editTextNewUsername)
        val passwordInput = findViewById<EditText>(R.id.editTextNewPassword)
        val registerButton = findViewById<Button>(R.id.buttonSubmitRegistration)

        registerButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotEmpty() && password.length >= 4) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

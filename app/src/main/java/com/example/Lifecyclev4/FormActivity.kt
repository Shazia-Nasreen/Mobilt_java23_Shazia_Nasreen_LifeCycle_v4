package com.example.Lifecyclev4

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val ageInput = findViewById<EditText>(R.id.editTextAge)
        val emailInput = findViewById<EditText>(R.id.editTextEmail)
        val hasLicenseCheck = findViewById<CheckBox>(R.id.checkBoxLicense)
        val submitButton = findViewById<Button>(R.id.buttonSubmitForm)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val logoutButton = findViewById<Button>(R.id.buttonLogout) // Add reference to the logout button

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Handle form submission
        submitButton.setOnClickListener {
            val age = ageInput.text.toString()
            val email = emailInput.text.toString()
            val hasLicense = hasLicenseCheck.isChecked
            val selectedGender = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)?.text.toString()

            // Simple validation for the form data
            if (age.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sharedPreferences.edit().apply {
                putString("age", age)
                putString("email", email)
                putBoolean("hasLicense", hasLicense)
                putString("gender", selectedGender)
                apply()
            }

            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()
        }

        // Handle logout
        logoutButton.setOnClickListener {
            // Set loggedIn to false to log out
            sharedPreferences.edit().putBoolean("loggedIn", false).apply()

            // Redirect to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Close FormActivity so the user can't go back to it
        }
    }
}

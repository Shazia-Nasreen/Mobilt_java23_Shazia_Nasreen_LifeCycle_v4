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

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Spara formulärdata
        submitButton.setOnClickListener {
            val age = ageInput.text.toString()
            val email = emailInput.text.toString()
            val hasLicense = hasLicenseCheck.isChecked
            val selectedGender = findViewById<RadioButton>(
                radioGroup.checkedRadioButtonId
            )?.text.toString()

            sharedPreferences.edit().apply {
                putString("age", age)
                putString("email", email)
                putBoolean("hasLicense", hasLicense)
                putString("gender", selectedGender)
                apply()
            }

            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()
        }
    }
}

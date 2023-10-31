package edu.farmingdale.alrajab.bcs421.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.farmingdale.alrajab.bcs421.R

class SharedPreferencesActivity : AppCompatActivity() {
    private lateinit var fNameEditText: EditText
    private lateinit var lNameEditText: EditText
    private lateinit var saveBtn: Button
    private lateinit var readBtn: Button
    private lateinit var resultTextView: TextView

    private val sharedPreferencesFileName = "user_data"
    private val fNameKey = "first_name"
    private val lNameKey = "last_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        fNameEditText = findViewById(R.id.editTextFName)
        lNameEditText = findViewById(R.id.editTextLName)
        saveBtn = findViewById(R.id.saveBtn)
        readBtn = findViewById(R.id.readBtn)
        resultTextView = findViewById(R.id.resultTextView)

        saveBtn.setOnClickListener { saveData() }
        readBtn.setOnClickListener { readData() }
    }

    private fun saveData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val firstName = fNameEditText.text.toString()
        val lastName = lNameEditText.text.toString()

        editor.putString(fNameKey, firstName)
        editor.putString(lNameKey, lastName)
        editor.apply()

        resultTextView.text = "Data saved successfully."
    }

    private fun readData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        val firstName = sharedPreferences.getString(fNameKey, "")
        val lastName = sharedPreferences.getString(lNameKey, "")

        resultTextView.text = "First Name: $firstName\nLast Name: $lastName"
    }
}
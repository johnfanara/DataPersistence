package edu.farmingdale.alrajab.bcs421.database

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import edu.farmingdale.alrajab.bcs421.databinding.ActivityDatabaseBinding
import kotlin.random.Random

class DatabaseActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityDatabaseBinding

    private lateinit var dbHelper:NameRepository

    // ToDO: Database link to be completed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper= NameRepository.getInstance(this)

        binding.readData.setOnClickListener { readData() }
        binding.writeData.setOnClickListener { writeData() }


    }

    private fun writeData() {
        val firstName = binding.editTextFName.text.toString()
        val lastName = binding.editTextLName.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
            dbHelper.addUser(User(0, firstName, lastName)) // 0 is the auto-generated UID
            Toast.makeText(this, "Data saved successfully.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please enter both first and last name.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readData() {
        val userData = dbHelper.getAll()
        val dataText = StringBuilder()

        for (user in userData) {
            dataText.append("First Name: ${user.firstName}, Last Name: ${user.lastName}\n")
        }

        // Update the TextView to display the data
        binding.displayTextView.text = dataText.toString()

    }


}
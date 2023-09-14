package com.example.simplecounter

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat


class MainActivity : ComponentActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        // Set the color to a specific color
        val color = ContextCompat.getColor(this, R.color.purple_500)

        // Apply the color filter to the button background
        button.background.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)

        val textView = findViewById<TextView>(R.id.textView)

        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            // Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()

            if (counter >= 100) {
                // Show upgrade button and set onClickListener
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    // Update original button to add 2 instead of 1
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    // Hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }

            }
        }
    }
}

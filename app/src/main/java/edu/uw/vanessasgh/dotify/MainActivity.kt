package edu.uw.vanessasgh.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import edu.uw.vanessasgh.dotify.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val randomNumber = Random.nextInt(1000, 10000)
    private val name = "example_name"
    private lateinit var currentName: TextView
    private lateinit var editName: EditText
    private var currentNumber = randomNumber
    private lateinit var currentPlayNumber: TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        //set random number for the number of plays
        currentPlayNumber = findViewById<TextView>(R.id.numPlays)
        currentPlayNumber.text = getString(R.string.num_plays_txt, randomNumber)

        //initialize the username
        currentName = findViewById<TextView>(R.id.username_view)
        currentName.text = name
        editName = findViewById<EditText>(R.id.username_edit)
        editName.setText(currentName.text)

        // if the change user button is pressed - make it invisible
        with(binding) {
            changeUserBtn.setOnClickListener {
                binding.userLayout.visibility = View.INVISIBLE
                binding.userChangeLayout.visibility = View.VISIBLE

                editName.setText(currentName.text)
            }
        }

        binding.applyUserBtn.setOnClickListener {
            val currentNameText = editName.getText().toString()
            if(currentNameText == "") {
                Toast.makeText(this, "The username cannot be a null", Toast.LENGTH_SHORT).show()
            } else {
                currentName.text = currentNameText
                binding.userChangeLayout.visibility = View.INVISIBLE
                binding.userLayout.visibility = View.VISIBLE
            }
        }

    }

    fun prevClicked(view: View) {
        Toast.makeText(this, "Skipping to previous track", Toast.LENGTH_SHORT).show()
    }

    fun nextClicked(view: View) {
        Toast.makeText(this, "Skipping to next track", Toast.LENGTH_SHORT).show()
    }

    fun playClicked(view: View) {
        val currentNum = currentNumber + 1
        currentNumber = currentNum
        currentPlayNumber.text = getString(R.string.num_plays_txt, currentNumber)
    }

}
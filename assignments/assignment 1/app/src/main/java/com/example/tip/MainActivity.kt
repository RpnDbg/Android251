package com.example.tip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val billAmount = binding.editTextNumber.text.toString().toDoubleOrNull()

        if (billAmount == null) {
            // Handle case when no amount is entered
            binding.textViewTipAmount.text = "YOU MUST ENTER A BILL AMOUNT"
            return
        }

        val tip10Percent = (billAmount * 1.10)
        val tip15Percent = (billAmount * 1.15)
        val tip20Percent = (billAmount * 1.20)
        val result = """
            Tips calculated as follows:
            10% = $tip10Percent
            15% = $tip15Percent
            20% = $tip20Percent
        """.trimIndent()

        binding.textViewTipAmount.text = result
    }
}

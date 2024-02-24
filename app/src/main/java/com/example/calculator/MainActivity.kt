package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //variable setup
    var digitOnScreen = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonSetup()
        functionalButton()

    }

    private fun buttonSetup(){
        binding.btnOne.setOnClickListener {
            appendDigitOnScreen("1")
        }

        binding.btnTwo.setOnClickListener {
            appendDigitOnScreen("2")
        }

        binding.btnThree.setOnClickListener {
            appendDigitOnScreen("3")
        }

        binding.btnFour.setOnClickListener {
            appendDigitOnScreen("4")
        }

        binding.btnFive.setOnClickListener {
            appendDigitOnScreen("5")
        }

        binding.btnSix.setOnClickListener {
            appendDigitOnScreen("6")
        }

        binding.btnSeven.setOnClickListener {
            appendDigitOnScreen("7")
        }

        binding.btnEight.setOnClickListener {
            appendDigitOnScreen("8")
        }

        binding.btnNine.setOnClickListener {
            appendDigitOnScreen("9")
        }

        binding.btnZero.setOnClickListener {
            appendDigitOnScreen("0")
        }

        binding.btnComa.setOnClickListener {
            appendDigitOnScreen(",")
        }
    }

    private fun appendDigitOnScreen(digit : String){
        var result = digitOnScreen.append(digit)
        binding.tvOperation.text = result.toString()
    }

    private fun functionalButton(){
        binding.btnClearDigit.setOnClickListener {
            clearPerDigit()
        }

        binding.btnClearAll.setOnClickListener {
            digitOnScreen.clear()
        }
    }

    private fun clearPerDigit(){
        var length = digitOnScreen.length

        digitOnScreen.deleteCharAt(length - 1)
        binding.tvOperation.text = digitOnScreen.toString()
    }
}
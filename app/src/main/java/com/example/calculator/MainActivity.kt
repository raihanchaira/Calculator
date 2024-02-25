package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.helper.MathOperation
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //variable setup
    var digitOnScreen = StringBuilder()
    var operator = ' '
    var leftSide : Double = 0.0
    var rightSide : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAll()

    }

    private fun setupAll(){
        buttonSetup()
        operationalButton()
        functionalButton()
    }

    private fun buttonSetup(){
        binding.btnOne.setOnClickListener {
            appendDigitOnScreen("1")
            binding.tvResult.text = "0"
        }

        binding.btnTwo.setOnClickListener {
            appendDigitOnScreen("2")
            binding.tvResult.text = "0"
        }

        binding.btnThree.setOnClickListener {
            appendDigitOnScreen("3")
            binding.tvResult.text = "0"
        }

        binding.btnFour.setOnClickListener {
            appendDigitOnScreen("4")
            binding.tvResult.text = "0"
        }

        binding.btnFive.setOnClickListener {
            appendDigitOnScreen("5")
            binding.tvResult.text = "0"
        }

        binding.btnSix.setOnClickListener {
            appendDigitOnScreen("6")
            binding.tvResult.text = "0"
        }

        binding.btnSeven.setOnClickListener {
            appendDigitOnScreen("7")
            binding.tvResult.text = "0"
        }

        binding.btnEight.setOnClickListener {
            appendDigitOnScreen("8")
            binding.tvResult.text = "0"
        }

        binding.btnNine.setOnClickListener {
            appendDigitOnScreen("9")
            binding.tvResult.text = "0"
        }

        binding.btnZero.setOnClickListener {
            appendDigitOnScreen("0")
            binding.tvResult.text = "0"
        }

        binding.btnComa.setOnClickListener {
            appendDigitOnScreen(",")
            binding.tvResult.text = "0"
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
            binding.tvOperation.text = ""
            binding.tvResult.text = ""
        }

        binding.btnEqual.setOnClickListener {
            mainOperation()
        }


    }

    private fun clearPerDigit(){
        var length = digitOnScreen.length

        if (length <= 0){
            Toast.makeText(this, "no digit", Toast.LENGTH_SHORT).show()
        }else{
            digitOnScreen.deleteCharAt(length - 1)
            binding.tvOperation.text = digitOnScreen.toString()
        }
    }

    private fun selectOperation(sign : Char){
        operator = sign
        leftSide = digitOnScreen.toString().toDouble()
        digitOnScreen.clear()
        binding.tvResult.text = "0"
    }

    private fun operationalButton(){
        binding.btnPlus.setOnClickListener {
             selectOperation('A')
        }

        binding.btnMinus.setOnClickListener {
             selectOperation('B')
        }

        binding.btnMultiple.setOnClickListener {
             selectOperation('C')
        }

        binding.btnDivided.setOnClickListener {
             selectOperation('D')
        }

    }

    private fun mainOperation(){
        rightSide = digitOnScreen.toString().toDouble()
        digitOnScreen.clear()

        when (operator) {
            'A' -> {
                val sum = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = sum.toString()
                digitOnScreen.append(sum)
            }

            'B' -> {
                val subs = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = subs.toString()
                digitOnScreen.append(subs)
            }

            'C' -> {
                val mulp = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = mulp.toString()
                digitOnScreen.append(mulp)
            }

            'D' -> {
                val div = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = div.toString()
                digitOnScreen.append(div)
            }
        }
    }
}
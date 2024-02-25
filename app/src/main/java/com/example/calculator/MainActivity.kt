package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.helper.MathOperation
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //variable setup
    var currentInput = StringBuilder()
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
        setupNUmericalButton()
        operationalButton()
        functionalButton()
    }

    private fun appendToCurrentInput(digit : String){
        currentInput.append(digit)
    }

    private fun updateOperationView(){
        binding.tvOperation.text = currentInput.toString()
    }

    private fun setupNUmericalButton(){
        var numericalButton = listOf(
            binding.btnZero, binding.btnOne, binding.btnTwo, binding.btnThree,
            binding.btnFour, binding.btnFive, binding.btnSix, binding.btnSeven,
            binding.btnEight, binding.btnNine, binding.btnComa)

        numericalButton.forEach{ button ->
            button.setOnClickListener {
                appendToCurrentInput(button.text.toString())
                updateOperationView()
            }
        }
    }

    private fun functionalButton(){
        binding.btnClearDigit.setOnClickListener {
            clearPerDigit()
        }

        binding.btnClearAll.setOnClickListener {
            currentInput.clear()
            binding.tvOperation.text = ""
            binding.tvResult.text = ""
        }

        binding.btnEqual.setOnClickListener {
            mainOperation()
        }
    }

    private fun clearPerDigit(){
        var length = currentInput.length

        if (length <= 0){
            Toast.makeText(this, "no digit", Toast.LENGTH_SHORT).show()
        }else{
            currentInput.deleteCharAt(length - 1)
            binding.tvOperation.text = currentInput.toString()
        }
    }

    private fun selectOperation(sign : Char){
        operator = sign
        leftSide = currentInput.toString().toDouble()
        currentInput.clear()
        binding.tvResult.text = "0"
    }

    private fun operationalButton(){

        var mapOfOperator = mapOf<Button, Char>(
            binding.btnPlus to '+',
            binding.btnMinus to '-',
            binding.btnMultiple to '*',
            binding.btnDivided to '*'
        )

        mapOfOperator.forEach{ (button, to) ->
            button.setOnClickListener{
                selectOperation(to)
            }
        }
    }

    private fun mainOperation(){
        rightSide = currentInput.toString().toDouble()
        currentInput.clear()

        when (operator) {
            'A' -> {
                val sum = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = sum.toString()
                currentInput.append(sum)
            }

            'B' -> {
                val subs = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = subs.toString()
                currentInput.append(subs)
            }

            'C' -> {
                val mulp = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = mulp.toString()
                currentInput.append(mulp)
            }

            'D' -> {
                val div = MathOperation.addition(leftSide, rightSide)
                binding.tvResult.text = div.toString()
                currentInput.append(div)
            }
        }
    }
}
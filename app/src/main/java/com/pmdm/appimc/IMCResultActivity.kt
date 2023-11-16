package com.pmdm.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class IMCResultActivity : AppCompatActivity() {

    private lateinit var btnReCalculate:AppCompatButton
    private lateinit var tvIMC:TextView
    private lateinit var tvShortDesc:TextView
    private lateinit var tvDescription:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvShortDesc = findViewById(R.id.tvShortDesc)
        btnReCalculate = findViewById(R.id.recalcButton)
        tvDescription = findViewById(R.id.tvDescription)
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            navigate2calculator()
        }
    }

    private fun setResult() {
        var imc = intent.extras?.getString("IMC").orEmpty()
        tvIMC.text = imc
    }

    private fun setTextResult() {
        var imc = intent.extras?.getString("IMC").orEmpty()

        when(imc.toDouble()) {
            in 0.0 .. 18.4 -> tvShortDesc.text = getString(R.string.underweight)
            in 18.5 .. 24.9 -> tvShortDesc.text = getString(R.string.normalWeight)
            in 25.0 .. 29.9 -> tvShortDesc.text = getString(R.string.overweight)
            in 30.0 .. Double.MAX_VALUE -> tvShortDesc.text = getString(R.string.obesity)
            else -> tvShortDesc.text = "Error"
        }
    }

    private fun setDescription() {
        var imc = intent.extras?.getString("IMC").orEmpty()

        when(imc.toDouble()) {
            in 0.0 .. 18.4 -> tvDescription.text = getString(R.string.underweightDesc)
            in 18.5 .. 24.9 -> tvDescription.text = getString(R.string.normalWeightDesc)
            in 25.0 .. 29.9 -> tvDescription.text = getString(R.string.overweightDesc)
            in 30.0 .. Double.MAX_VALUE -> tvDescription.text = getString(R.string.obesityDesc)
            else -> tvDescription.text = "Error"
        }
    }

    private fun navigate2calculator() {
        var intent = Intent(this,IMCCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun initUI() {
        setResult()
        setTextResult()
        setDescription()
    }


}
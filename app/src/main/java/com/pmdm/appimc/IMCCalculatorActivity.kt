package com.pmdm.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class IMCCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initListeners()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
    }

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private var isMale: Boolean = true

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
    }

    private fun initListeners(){
         viewMale.setOnClickListener()

    }

}
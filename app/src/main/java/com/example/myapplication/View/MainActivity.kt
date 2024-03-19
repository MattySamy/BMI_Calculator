package com.example.myapplication.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.Model.Person
import com.example.myapplication.Presenter.CalculateBMIPresenter
import com.example.myapplication.Presenter.ICalculateBMIPresenter
import com.example.myapplication.R

class MainActivity : AppCompatActivity(), CalculateBMIPresenter.View {

    //Name: Mostafa Abdelhamid Abdelmonem
    //Group: G3


    lateinit var calculateAgePresenter: ICalculateBMIPresenter
    lateinit var textViewInfo: TextView
    lateinit var editTextWeight: EditText
    lateinit var editTextHeight: EditText
    lateinit var editTextName: EditText
    lateinit var buttonCalculateBMI: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateAgePresenter = CalculateBMIPresenter(this)

        textViewInfo = findViewById(R.id.textView_your_BMI)
        editTextName =  findViewById(R.id.editText_name)
        editTextWeight = findViewById(R.id.editText_weight)
        editTextHeight = findViewById(R.id.editText_height)
        buttonCalculateBMI = findViewById(R.id.button_calculate_BMI)

        buttonCalculateBMI.setOnClickListener{
            val name = editTextName.text.trim().toString()
            val weight = editTextWeight.text.trim().toString()
            val height = editTextHeight.text.trim().toString()
            calculateAgePresenter.calculateYourBMI(name,height,weight)

        }
    }

    override fun getInfo(person: Person) {
        textViewInfo.text = "${person.name}, Your BMI is ${person.bmiCalc} and You are ${if(person.weightClass == "normal") "Good." else if(person.weightClass == "underweight") "so thin, You need to eat more fats." else "fat, Try to make more exercices."}"
    }
}
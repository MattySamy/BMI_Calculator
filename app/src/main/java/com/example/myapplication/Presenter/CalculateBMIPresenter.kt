package com.example.myapplication.Presenter

import com.example.myapplication.Model.Person
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

class CalculateBMIPresenter(private val view:View): ICalculateBMIPresenter {
    override fun calculateYourBMI(name: String, height: String, weight: String) {
        val BMICalc =  String.format("%.2f",weight.toInt() / height.toDouble().pow(2.0)).toDouble()
        val person = Person(name, BMICalc, "not determined")
        if (BMICalc < 18.5){
            person.weightClass = "underweight"
        }else if (18.5<=BMICalc && BMICalc<25.0){
            person.weightClass = "normal"
        }else if (25.0<=BMICalc && BMICalc<30.0){
            person.weightClass = "overweight"
        }else if(30.0<=BMICalc){
            person.weightClass = "very overweight"
        }
        view.getInfo(person)
    }

    interface View{
        fun getInfo(person: Person)
    }
}
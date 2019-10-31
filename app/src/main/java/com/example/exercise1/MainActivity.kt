package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            //val = value , var = variable
            val car_price = editTextCarPrice.text.toString().toInt()
            if(car_price == 0){
                editTextCarPrice.setError("Please enter your name")
                return@setOnClickListener
            }
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()

            //TODO : continue the calculation here
            val car_loan = car_price - down_payment
            textViewLoan.text = getString(R.string.loan) + "${car_loan}"
            val interest = car_loan * ( interest_rate / 100 ) * loan_period
            //todo find the locale of the user and display the currency sign
            textViewInterest.text = getString(R.string.interest) + "${interest}"
            val monthly_repayment = ( car_loan + interest ) / loan_period / 12
            textViewMonthlyPayment.text = getString(R.string.monthly_payment) + "${monthly_repayment}"
        }
    }

    fun resetInputs(view: View) {
        // TODO : reset all inputs and outputs
        editTextCarPrice.setText(null)
        editTextDownPayment.setText(null)
        editTextLoanPeriod.setText(null)
        editTextInterestRate.setText(null)
        textViewLoan.text = ""
        textViewInterest.text = ""
        textViewMonthlyPayment.text = ""
    }
}

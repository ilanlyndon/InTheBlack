package com.kevinilan.intheblack.ui

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.kevinilan.intheblack.EXPENSE
import com.kevinilan.intheblack.R
import com.kevinilan.intheblack.REVENUE


//TODO make the default choice Expense
class TransactionSpinner(context: Context) {
    val spinnerOptions = arrayOf(context.getString(R.string.expense), context.getString(R.string.revenue))
    val transactionSpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerOptions)
    val transactionSpinner = Spinner(context)
    fun setAdapter(spinnerChoice: SpinnerChoice) {
        transactionSpinner.adapter = transactionSpinnerAdapter
        transactionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> spinnerChoice.expense
                    1 -> spinnerChoice.revenue
                }
            }
        }
    }


}


interface SpinnerChoice {
    val expense: Int
        get() = EXPENSE
    val revenue: Int
        get() = REVENUE
}
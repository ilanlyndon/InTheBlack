package com.kevinilan.intheblack.ui

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.kevinilan.intheblack.EXPENSE
import com.kevinilan.intheblack.R
import com.kevinilan.intheblack.REVENUE

class TransactionSpinner(context: Context) {
    val spinnerOptions = arrayOf(context.getString(R.string.expense), context.getString(R.string.revenue))
    val transactionSpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerOptions)
    val transactionSpinner = Spinner(context)

    fun setAdapter() {
        transactionSpinner.adapter = transactionSpinnerAdapter
        transactionSpinner.setSelection(0)
    }

    fun getTransactionSpinnerSelection(): Int {
        when (transactionSpinner.selectedItemPosition) {
            0 -> return EXPENSE
            1 -> return REVENUE
        }
        return EXPENSE
    }
}
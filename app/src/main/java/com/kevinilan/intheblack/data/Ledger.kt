package com.kevinilan.intheblack.data


data class Ledger(val startingBalance: Double, val transactions: List<Transaction>, val dateRange: Any?) {

    // function that adds up transaction values in our ledger, expenses will be subtracted, revenue added
    fun getBalance(): Double {
        var ledgerBalance: Double = startingBalance
        for (number in transactions) {
            when (number.transactionType) {
                TransactionType.Expense -> ledgerBalance -= number.transactionValue
                TransactionType.Revenue -> ledgerBalance += number.transactionValue
            }
        }
        return ledgerBalance
    }

}



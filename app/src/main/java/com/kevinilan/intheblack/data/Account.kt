package com.kevinilan.intheblack.data

data class account(val startingBalance: Double){


// not sure if this is the correct way to write our array
var balance: MutableList<Double> = ArrayList()

var transactions: MutableList<Transaction> = ArrayList()

// function to add a transaction to our array
fun addTransaction(Transaction: Transaction){
transactions.add(Transaction)
    }

}


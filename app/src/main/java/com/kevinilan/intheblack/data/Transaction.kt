package com.kevinilan.intheblack.data



data class Transaction(val transactionName: String, val transactionValue: Double, val transactionType: TransactionType, val currencyType: String, val transactionMaker: String){
// need to add timestamp to transaction, as well as location


}

enum class TransactionType{
Expense,
Revenue
}

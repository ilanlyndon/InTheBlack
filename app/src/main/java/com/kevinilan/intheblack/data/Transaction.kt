package com.kevinilan.intheblack.data


data class Transaction(
    val transactionName: String?,
    val transactionValue: Double,
    val transactionType: TransactionType,
    val currencyType: String?,
    val transactionMaker: String?,
    val timesOfTransaction: Any?,
    val locationOfTransaction: Any?
)

enum class TransactionType{
Expense,
Revenue
}

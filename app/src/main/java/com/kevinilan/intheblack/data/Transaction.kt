package com.kevinilan.intheblack.data

data class Transaction(val itemName: String, val itemValue: Double, val type: TransactionType){
// need to add timestamp to transaction, as well as location


}

enum class TransactionType{
Expense,
ReOccuring,
Purchase
}

package com.kevinilan.intheblack.utils

import com.google.gson.GsonBuilder
import com.kevinilan.intheblack.data.Budget
import com.kevinilan.intheblack.data.BudgetItem
import com.kevinilan.intheblack.data.Ledger
import com.kevinilan.intheblack.data.Transaction


fun objectToJSON(toJSONObject: Any): Any {
    val gson = GsonBuilder().setPrettyPrinting().create()
    return gson.toJson(toJSONObject)
}

fun transactionFromJSON(fromJSONObject: String): Any {
    val gson = GsonBuilder().setPrettyPrinting().create()

    return gson.fromJson(fromJSONObject, Transaction::class.java)
}

fun ledgerFromJSON(fromJSONObject: String): Any {
    val gson = GsonBuilder().setPrettyPrinting().create()

    return gson.fromJson(fromJSONObject, Ledger::class.java)
}

fun budgetItemFromJSON(fromJSONObject: String): Any {
    val gson = GsonBuilder().setPrettyPrinting().create()

    return gson.fromJson(fromJSONObject, BudgetItem::class.java)
}

fun budgetFromJSON(fromJSONObject: String): Any {
    val gson = GsonBuilder().setPrettyPrinting().create()

    return gson.fromJson(fromJSONObject, Budget::class.java)
}
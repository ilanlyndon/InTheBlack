package com.kevinilan.intheblack.data

data class IntheBlackUser(
    val userName: String,
    val linkedAccounts: List<String>?,
    val budgets: List<Budget>?,
    val ledgers: List<Ledger>?
)
package com.kevinilan.intheblack.data

data class Budget(val budgetName: String, val budgetItems: List<BudgetItem>) {

    // returns the total amount budgeted
    fun totalBudget(): Double {
        var budgetTotal: Double = 0.00

        for (number in budgetItems) {
            budgetTotal += number.budgetItemAllocationWithSubItems()
        }
        return budgetTotal
    }


}
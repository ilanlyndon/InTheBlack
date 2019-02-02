package com.kevinilan.intheblack.data

data class Budget(val budgetName: String) {

    val budgetItems: MutableList<BudgetItem> = ArrayList()

    // function to add a budget item to our array
    fun addBudgetItem(budgetItem: BudgetItem) {
        budgetItems.add(budgetItem)
    }

    // function to remove budget item from our array
    fun removeBudgetItem(budgetItem: BudgetItem) {
        budgetItems.remove(budgetItem)
    }

    // returns the total amount budgeted
    fun totalBudget(): Double {
        var budgetTotal: Double = 0.00

        for (number in budgetItems) {
            budgetTotal += number.budgetItemAllocationWithSubItems()
        }
        return budgetTotal
    }


}
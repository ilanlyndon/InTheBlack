package com.kevinilan.intheblack.data

data class BudgetItem(val budgetItemName: String, val budgetItemAllocation: Double?) {

    // an array of sub items to this budget item, aka if this item is Transportation, sub categories could be: Gas, Public Transportation, Toll Road
    val budgetItemSubItems: MutableList<BudgetItem> = ArrayList()

    // function to add a sub item
    fun addBudgetSubItem(budgetSubItem: BudgetItem) {
        budgetItemSubItems.add(budgetSubItem)
    }

    // function to remove a sub item
    fun removeBudgetSubItem(budgetSubItem: BudgetItem) {
        budgetItemSubItems.remove(budgetSubItem)
    }

    // returns True if the item has sub items - used to determine total allocation of the item
    private fun budgetItemHasSubItems(): Boolean {
        return budgetItemSubItems.size > 0
    }

    // returns the total allocation for the budget item including its sub items
    fun budgetItemAllocationWithSubItems(): Double {
        var sumOfBudgetWithSubItems: Double = budgetItemAllocation ?: 0.00
        if (budgetItemHasSubItems()) {
            for (number in budgetItemSubItems) {
                sumOfBudgetWithSubItems += number.budgetItemAllocation ?: 0.00
            }
        }
        return sumOfBudgetWithSubItems
    }

}
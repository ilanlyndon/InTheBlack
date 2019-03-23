package com.kevinilan.intheblack.data

data class BudgetItem(
    val budgetItemName: String,
    val budgetItemAllocation: Double?,
    val budgetItemSubItems: List<BudgetItem>?
) {

    // returns True if the item has sub items - used to determine total allocation of the item
    private fun budgetItemHasSubItems(): Boolean {
        if (budgetItemSubItems != null) {
            return budgetItemSubItems.isNotEmpty()
        }
        return false
    }

    // returns the total allocation for the budget item including its sub items
    fun budgetItemAllocationWithSubItems(): Double {
        var sumOfBudgetWithSubItems: Double = budgetItemAllocation ?: 0.00
        if (budgetItemHasSubItems()) {
            for (number in budgetItemSubItems.orEmpty()) {
                sumOfBudgetWithSubItems += number.budgetItemAllocation ?: 0.00
            }
        }
        return sumOfBudgetWithSubItems
    }

}
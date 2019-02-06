package com.kevinilan.intheblack.datatest

import com.kevinilan.intheblack.data.*
import org.junit.Test

import org.junit.Assert.*


// Transaction class tests
class TransactionTest{
    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin", null, null)
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira", null, null)
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin", null, null)

    @Test
    fun transaction_Test1(){
    assertEquals(30.50, trans1.transactionValue, 0.00)
    assertEquals("lunch", trans1.transactionName)
    assertEquals(TransactionType.Expense, trans1.transactionType)
        assertEquals("USD", trans1.currencyType)
        assertEquals("Kevin", trans1.transactionMaker)
    }
    @Test
    fun transaction_Test2(){
        assertEquals(75.00, trans2.transactionValue, 0.00)
        assertEquals("dinner", trans2.transactionName)
        assertEquals(TransactionType.Expense, trans2.transactionType)
        assertEquals("NIS", trans2.currencyType)
        assertEquals("Shira", trans2.transactionMaker)
    }

    @Test
    fun transaction_Test3(){
        assertEquals(500.00, trans3.transactionValue, 0.00)
        assertEquals("PayCheck", trans3.transactionName)
        assertEquals(TransactionType.Revenue, trans3.transactionType)
        assertEquals("NIS", trans3.currencyType)
        assertEquals("Kevin", trans3.transactionMaker)
    }
}
class LedgerTest {


    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin", null, null)
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira", null, null)
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin", null, null)
    val ledger1 = Ledger(50.00, listOf(trans1, trans2, trans3))
    @Test
    fun ledgerInstantiatesTest(){
        assertEquals(50.00, ledger1.startingBalance, 0.00)
    }
    @Test
    fun ledgerAddsTransactionsTest(){
        val ledger2 = Ledger(50.00, listOf(trans1))
        assertEquals(1, ledger2.transactions.size)
        assertEquals(30.50, ledger2.transactions[0].transactionValue, 0.00)
    }

    @Test
    fun ledgerDeterminesBalance(){
        assertEquals(3, ledger1.transactions.size)
        assertEquals(444.50, ledger1.getBalance(), 0.00)
    }
}

class BudgetTest {

    val budgetItem2 = BudgetItem("Gas", 50.00, null)
    val budgetItem3 = BudgetItem("Rav Kav", 100.00, null)
    val budgetItem1 = BudgetItem("Transportation", 0.00, listOf(budgetItem2, budgetItem3))

    val budgetItem4 = BudgetItem("Explosives", 1200.00, null)
    val budgetItem5 = BudgetItem("Rent", 5000.00, null)

    val budgetItem7 = BudgetItem("Cowfood", 100.00, null)
    val budgetItem6 = BudgetItem("Cows", 500.00, listOf(budgetItem7))


    @Test
    fun budgetItemSubItems() {

        assertEquals(2, budgetItem1.budgetItemSubItems?.size)
        assertEquals(150.00, budgetItem1.budgetItemAllocationWithSubItems(), 0.00)
    }

    @Test
    fun buildBudget() {
        val budget = Budget("MyBudget", listOf(budgetItem1, budgetItem4, budgetItem5, budgetItem6))


        assertEquals(6950.00, budget.totalBudget(), 0.00)


    }


}

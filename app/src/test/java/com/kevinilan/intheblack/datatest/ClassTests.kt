package com.kevinilan.intheblack.datatest

import com.kevinilan.intheblack.data.*
import com.kevinilan.intheblack.utils.*
import org.junit.Test

import org.junit.Assert.*


// Transaction class tests
class TransactionTest {
    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin", null, null)
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira", null, null)
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin", null, null)

    @Test
    fun transaction_Test1() {
        assertEquals(30.50, trans1.transactionValue, 0.00)
        assertEquals("lunch", trans1.transactionName)
        assertEquals(TransactionType.Expense, trans1.transactionType)
        assertEquals("USD", trans1.currencyType)
        assertEquals("Kevin", trans1.transactionMaker)
    }

    @Test
    fun transaction_Test2() {
        assertEquals(75.00, trans2.transactionValue, 0.00)
        assertEquals("dinner", trans2.transactionName)
        assertEquals(TransactionType.Expense, trans2.transactionType)
        assertEquals("NIS", trans2.currencyType)
        assertEquals("Shira", trans2.transactionMaker)
    }

    @Test
    fun transaction_Test3() {
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
    val ledger1 = Ledger(50.00, listOf(trans1, trans2, trans3), null)
    @Test
    fun ledgerInstantiatesTest() {
        assertEquals(50.00, ledger1.startingBalance, 0.00)
    }

    @Test
    fun ledgerAddsTransactionsTest() {
        val ledger2 = Ledger(50.00, listOf(trans1), null)
        assertEquals(1, ledger2.transactions.size)
        assertEquals(30.50, ledger2.transactions[0].transactionValue, 0.00)
    }

    @Test
    fun ledgerDeterminesBalance() {
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

class UserClassTest() {
    val userName = "BobDaBuilda"
    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin", null, null)
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira", null, null)
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin", null, null)
    val ledger1 = Ledger(50.00, listOf(trans1, trans2, trans3), null)

    val budgetItem2 = BudgetItem("Gas", 50.00, null)
    val budgetItem3 = BudgetItem("Rav Kav", 100.00, null)
    val budgetItem1 = BudgetItem("Transportation", 0.00, listOf(budgetItem2, budgetItem3))

    val budgetItem4 = BudgetItem("Explosives", 1200.00, null)
    val budgetItem5 = BudgetItem("Rent", 5000.00, null)

    val budgetItem7 = BudgetItem("Cowfood", 100.00, null)
    val budgetItem6 = BudgetItem("Cows", 500.00, listOf(budgetItem7))

    val budget1 = Budget("MyBudget", listOf(budgetItem1, budgetItem4, budgetItem5, budgetItem6))

    val userBob = IntheBlackUser(userName, null, listOf(budget1), listOf(ledger1))


    @Test
    fun nameTest() {
        assertEquals("BobDaBuilda", userBob.userName)
    }

    @Test
    fun linkedAccountsTest() {
        assertEquals(null, userBob.linkedAccounts)
    }

    @Test
    fun budgetTest() {
        assertEquals(
            Budget("MyBudget", listOf(budgetItem1, budgetItem4, budgetItem5, budgetItem6)),
            userBob.budgets!![0]
        )
    }

    @Test
    fun ledgerTest() {
        assertEquals(Ledger(50.00, listOf(trans1, trans2, trans3), null), userBob.ledgers!![0])
    }

    @Test
    fun fullUserTest() {
        assertEquals(IntheBlackUser("BobDaBuilda", null, listOf(budget1), listOf(ledger1)), userBob)
    }
}


class JsonConversionTests() {

    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin", null, null)
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira", null, null)
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin", null, null)
    val ledger1 = Ledger(50.00, listOf(trans1, trans2, trans3), null)

    val budgetItem2 = BudgetItem("Gas", 50.00, null)
    val budgetItem3 = BudgetItem("Rav Kav", 100.00, null)
    val budgetItem1 = BudgetItem("Transportation", 0.00, listOf(budgetItem2, budgetItem3))

    val budgetItem4 = BudgetItem("Explosives", 1200.00, null)
    val budgetItem5 = BudgetItem("Rent", 5000.00, null)

    val budgetItem7 = BudgetItem("Cowfood", 100.00, null)
    val budgetItem6 = BudgetItem("Cows", 500.00, listOf(budgetItem7))

    val budget1 = Budget("MyBudget", listOf(budgetItem1, budgetItem4, budgetItem5, budgetItem6))

    val transactionToJSON = objectToJSON(trans1)
    val ledgerToJSON = objectToJSON(ledger1)
    val budgetItemToJSON = objectToJSON(budgetItem1)
    val budgetToJSON = objectToJSON(budget1)

    @Test
    fun testJSONRetreival() {


        val transFromJSON1 = transactionFromJSON(transactionToJSON.toString())
        val ledgerFromJSON1 = ledgerFromJSON(ledgerToJSON.toString())
        val budgetFromJSON1 = budgetFromJSON(budgetToJSON.toString())
        val budgetItemFromJSON1 = budgetItemFromJSON(budgetItemToJSON.toString())

        assertEquals(transFromJSON1, trans1)
        assertEquals(ledgerFromJSON1, ledger1)
        assertEquals(budgetItemFromJSON1, budgetItem1)
        assertEquals(budgetFromJSON1, budget1)

    }


    @Test
    fun testJSONConversion() {
        assertEquals(
            "{\n" +
                    "  \"transactionName\": \"lunch\",\n" +
                    "  \"transactionValue\": 30.5,\n" +
                    "  \"transactionType\": \"Expense\",\n" +
                    "  \"currencyType\": \"USD\",\n" +
                    "  \"transactionMaker\": \"Kevin\"\n" +
                    "}", transactionToJSON
        )

        assertEquals(
            "{\n" +
                    "  \"startingBalance\": 50.0,\n" +
                    "  \"transactions\": [\n" +
                    "    {\n" +
                    "      \"transactionName\": \"lunch\",\n" +
                    "      \"transactionValue\": 30.5,\n" +
                    "      \"transactionType\": \"Expense\",\n" +
                    "      \"currencyType\": \"USD\",\n" +
                    "      \"transactionMaker\": \"Kevin\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"transactionName\": \"dinner\",\n" +
                    "      \"transactionValue\": 75.0,\n" +
                    "      \"transactionType\": \"Expense\",\n" +
                    "      \"currencyType\": \"NIS\",\n" +
                    "      \"transactionMaker\": \"Shira\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"transactionName\": \"PayCheck\",\n" +
                    "      \"transactionValue\": 500.0,\n" +
                    "      \"transactionType\": \"Revenue\",\n" +
                    "      \"currencyType\": \"NIS\",\n" +
                    "      \"transactionMaker\": \"Kevin\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}", ledgerToJSON
        )
        assertEquals(
            "{\n" +
                    "  \"budgetItemName\": \"Transportation\",\n" +
                    "  \"budgetItemAllocation\": 0.0,\n" +
                    "  \"budgetItemSubItems\": [\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Gas\",\n" +
                    "      \"budgetItemAllocation\": 50.0\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Rav Kav\",\n" +
                    "      \"budgetItemAllocation\": 100.0\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}", budgetItemToJSON
        )
        assertEquals(
            "{\n" +
                    "  \"budgetName\": \"MyBudget\",\n" +
                    "  \"budgetItems\": [\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Transportation\",\n" +
                    "      \"budgetItemAllocation\": 0.0,\n" +
                    "      \"budgetItemSubItems\": [\n" +
                    "        {\n" +
                    "          \"budgetItemName\": \"Gas\",\n" +
                    "          \"budgetItemAllocation\": 50.0\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"budgetItemName\": \"Rav Kav\",\n" +
                    "          \"budgetItemAllocation\": 100.0\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Explosives\",\n" +
                    "      \"budgetItemAllocation\": 1200.0\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Rent\",\n" +
                    "      \"budgetItemAllocation\": 5000.0\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"budgetItemName\": \"Cows\",\n" +
                    "      \"budgetItemAllocation\": 500.0,\n" +
                    "      \"budgetItemSubItems\": [\n" +
                    "        {\n" +
                    "          \"budgetItemName\": \"Cowfood\",\n" +
                    "          \"budgetItemAllocation\": 100.0\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}", budgetToJSON
        )


    }


}
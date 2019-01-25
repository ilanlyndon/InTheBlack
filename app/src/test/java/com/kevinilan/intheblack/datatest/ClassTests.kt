package com.kevinilan.intheblack.datatest

import com.kevinilan.intheblack.data.Ledger
import com.kevinilan.intheblack.data.Transaction
import com.kevinilan.intheblack.data.TransactionType
import org.junit.Test

import org.junit.Assert.*


// Transaction class tests
class TransactionTest{
   val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin")
   val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira")
   val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin")

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


    val trans1 = Transaction("lunch", 30.50, TransactionType.Expense, "USD", "Kevin")
    val trans2 = Transaction("dinner", 75.00, TransactionType.Expense, "NIS", "Shira")
    val trans3 = Transaction("PayCheck", 500.00, TransactionType.Revenue, "NIS", "Kevin")
    val ledger1 = Ledger(50.00)
    @Test
    fun ledgerInstantiatesTest(){
        assertEquals(50.00, ledger1.startingBalance, 0.00)
    }
    @Test
    fun ledgerAddsTransactionsTest(){
        ledger1.addTransaction(trans1)
        assertEquals(1, ledger1.transactions.size)
        assertEquals(30.50, ledger1.transactions[0].transactionValue, 0.00)
    }

    @Test
    fun ledgerDeterminesBalance(){
        ledger1.addTransaction(trans1)
        ledger1.addTransaction(trans2)
        ledger1.addTransaction(trans3)
        assertEquals(3, ledger1.transactions.size)
        assertEquals(444.50, ledger1.getBalance(), 0.00)
    }
}



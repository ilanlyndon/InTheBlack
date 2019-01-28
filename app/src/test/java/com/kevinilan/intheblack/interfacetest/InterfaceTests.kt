package com.kevinilan.intheblack.interfacetest

import com.kevinilan.intheblack.EXPENSE
import com.kevinilan.intheblack.REVENUE
import com.kevinilan.intheblack.ui.SpinnerChoice
import org.junit.Test

import org.junit.Assert.*


class InterfaceTests {


    class SpinnerInterface : SpinnerChoice {
        @Test
        fun getExpense() {
            assertEquals(EXPENSE, expense)
        }

        @Test
        fun getRevenue() {
            assertEquals(REVENUE, revenue)
        }
    }


}
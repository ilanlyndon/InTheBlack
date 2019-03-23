package com.kevinilan.intheblack.ui.ui.ledger

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.kevinilan.intheblack.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.ledger_fragment.*


class LedgerFragment : Fragment() {

    val currentBalanceTextView: TextView = ledger_view_current_balance_display
    val datePeriodTextView: TextView = ledger_view_time_period_indicator
    val ledgerRecycler: RecyclerView = ledger_view_recyclerView
    val ledgerAddTransactionButton: Button = ledger_view_add_button

    companion object {
        fun newInstance() = LedgerFragment()

    }

    private lateinit var viewModel: LedgerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.ledger_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LedgerViewModel::class.java)


        // TODO: Use the ViewModel
    }

}

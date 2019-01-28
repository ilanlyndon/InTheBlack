package com.kevinilan.intheblack.ui.ui.ledger

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kevinilan.intheblack.R


class LedgerFragment : Fragment() {

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

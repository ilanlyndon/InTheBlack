package com.kevinilan.intheblack.ui.ui.ledger

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kevinilan.intheblack.data.Ledger

// this class is a wrappper for handling data interaction between the UI and the data source
class LedgerViewModel : ViewModel(), LifecycleObserver {


    private var liveLedger: LiveData<Ledger>? = null

    // repository placeholder
    // private var ledgerRepository:


    fun initializeLiveLedger(): LiveData<Ledger>? {
        if (liveLedger == null) {
            liveLedger = MutableLiveData<Ledger>()
            // get from repository here
            //  liveLedger =

        }

        return liveLedger
    }



}

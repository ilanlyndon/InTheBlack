package com.kevinilan.intheblack.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kevinilan.intheblack.R
import com.kevinilan.intheblack.ui.ui.ledger.LedgerFragment

class Ledger : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ledger_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LedgerFragment.newInstance())
                .commitNow()
        }
    }

}

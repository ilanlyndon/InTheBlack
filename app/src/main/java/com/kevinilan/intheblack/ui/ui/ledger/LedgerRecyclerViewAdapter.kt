package com.kevinilan.intheblack.ui.ui.ledger

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kevinilan.intheblack.R
import com.kevinilan.intheblack.data.Transaction


import com.kevinilan.intheblack.ui.ui.ledger.LedgerDisplayFragment.OnListFragmentInteractionListener
import com.kevinilan.intheblack.ui.ui.ledger.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_ledger.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class LedgerRecyclerViewAdapter(
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<LedgerRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    //todo need a method to get this value from viewmodel
    private lateinit var mValues: List<Transaction>
    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Transaction
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_ledger, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.transactionName
        holder.mContentView.text = item.transactionValue.toString()

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}

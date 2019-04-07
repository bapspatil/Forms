package com.bapspatil.forms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bapspatil.forms.R
import com.bapspatil.forms.model.RowsItem

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class RowsAdapter(private val rows: ArrayList<RowsItem>) : RecyclerView.Adapter<RowsAdapter.RowViewHolder>() {

    private lateinit var mContext: Context

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RowViewHolder {
        mContext = viewGroup.context
        return RowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_section, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: RowViewHolder, position: Int) {

    }

    override fun getItemCount() = rows.size
}
package com.bapspatil.forms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bapspatil.forms.R
import com.bapspatil.forms.model.RowsItem
import kotlinx.android.synthetic.main.item_row.view.*

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class RowsAdapter(private val rows: ArrayList<RowsItem?>?) : RecyclerView.Adapter<RowsAdapter.RowViewHolder>() {

    private lateinit var mContext: Context

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RowViewHolder {
        mContext = viewGroup.context
        return RowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_row, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: RowViewHolder, position: Int) {
        val row = rows?.get(position)

        var visibilityFlag = false

        if (row?.hidden != null && row.hidden!!) {
            visibilityFlag = false
        } else if (row?.visibleConditions != null && row.visibleConditions!!.isNotEmpty()) {
            row.visibleConditions!!.forEach { visibleCondition ->
                for (key in visibleCondition.keys) {
                    rows?.forEach { mRow ->
                        visibilityFlag = mRow?.key?.equals(key)!! && mRow.value?.equals(visibleCondition[key])!!
                    }
                }
            }
        }

        // Hide row
        if (!visibilityFlag) {
            viewHolder.itemView.visibility = View.GONE
        }
        // Show row
        else {
            viewHolder.itemView.visibility = View.VISIBLE
            // Row title
            if (row?.title != null) {
                viewHolder.itemView.tvRowTitle.text = row.title
                viewHolder.itemView.tvRowTitle.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.tvRowTitle.visibility = View.GONE
            }
            // Row subtitle
            if (row?.subtitle != null) {
                viewHolder.itemView.tvRowSubtitle.text = row.subtitle
                viewHolder.itemView.tvRowSubtitle.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.tvRowSubtitle.visibility = View.GONE
            }
            // Row info
            if (row?.info != null) {
                viewHolder.itemView.tvRowInfo.text = row.info
                viewHolder.itemView.tvRowInfo.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.tvRowInfo.visibility = View.GONE
            }
        }
    }

    override fun getItemCount() = rows?.size ?: 0
}
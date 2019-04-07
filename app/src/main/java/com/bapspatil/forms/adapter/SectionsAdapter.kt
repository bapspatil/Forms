package com.bapspatil.forms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bapspatil.forms.R
import com.bapspatil.forms.model.SectionsItem
import kotlinx.android.synthetic.main.item_section.view.*

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class SectionsAdapter(private val sections: ArrayList<SectionsItem?>?) : RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    private lateinit var mContext: Context

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SectionViewHolder {
        mContext = viewGroup.context
        return SectionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_section, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: SectionViewHolder, position: Int) {
        val section = sections?.get(position)
        // Hide the section
        if (section?.hidden != null && section.hidden) {
            viewHolder.itemView.visibility = View.GONE
        }
        // Show the section
        else {
            viewHolder.itemView.visibility = View.VISIBLE
            // Section title
            if (section?.title != null) {
                viewHolder.itemView.tvSectionTitle.text = section.title
                viewHolder.itemView.tvSectionTitle.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.tvSectionTitle.visibility = View.GONE
            }
            // Section footer
            if (section?.footer != null) {
                viewHolder.itemView.tvSectionFooter.text = section.footer
                viewHolder.itemView.tvSectionFooter.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.tvSectionFooter.visibility = View.GONE
            }
            // Section rows
            if (section?.rows != null) {
                viewHolder.itemView.rvRows.adapter = RowsAdapter(section.rows)
                viewHolder.itemView.rvRows.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
                viewHolder.itemView.rvRows.visibility = View.VISIBLE
            } else {
                viewHolder.itemView.rvRows.visibility = View.GONE
            }
        }
    }

    override fun getItemCount() = sections?.size ?: 0
}
package com.bapspatil.forms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bapspatil.forms.R
import com.bapspatil.forms.model.SectionsItem

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class SectionsAdapter(private val sections: ArrayList<SectionsItem>) : RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    private lateinit var mContext: Context

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SectionViewHolder {
        mContext = viewGroup.context
        return SectionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_section, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: SectionViewHolder, position: Int) {

    }

    override fun getItemCount() = sections.size
}
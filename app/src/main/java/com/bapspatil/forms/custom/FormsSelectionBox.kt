package com.bapspatil.forms.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.bapspatil.forms.R
import kotlinx.android.synthetic.main.forms_selection_box.view.*

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class FormsSelectionBox : LinearLayout, View.OnClickListener {

    var optionSelected: Int? = FOR_SALE
    private var listener: FormsSelectionBox.SelectionBoxListener? = null

    constructor(ctx: Context?) : super(ctx) {
        initView(ctx, null, 0)
    }

    constructor(ctx: Context?, attrs: AttributeSet?) : super(ctx, attrs) {
        initView(ctx, attrs, 0)
    }

    constructor(ctx: Context?, attrs: AttributeSet?, defStyle: Int) : super(ctx, attrs, defStyle) {
        initView(ctx, attrs, defStyle)
    }

    private fun initView(ctx: Context?, attrs: AttributeSet?, defStyle: Int) {
        View.inflate(ctx, R.layout.forms_selection_box, this)
        this.tvFsbForSale.setOnClickListener(this)
        this.tvFsbForRent.setOnClickListener(this)
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.FormsSelectionBox, defStyle, 0)
            optionSelected = attributes.getInt(R.styleable.FormsSelectionBox_fsb_defaultOption, FOR_SALE)
            attributes.recycle()
        }
        updateUI(ctx)
    }

    private fun updateUI(ctx: Context?) {
        when (optionSelected) {
            FOR_SALE -> {
                tvFsbForRent.setTextColor(ContextCompat.getColor(ctx!!, R.color.md_grey_800))
                imgFsbForRent.visibility = View.GONE

                tvFsbForSale.setTextColor(ContextCompat.getColor(ctx, R.color.md_green_700))
                imgFsbForSale.visibility = View.VISIBLE
            }
            FOR_RENT -> {
                tvFsbForSale.setTextColor(ContextCompat.getColor(ctx!!, R.color.md_grey_800))
                imgFsbForSale.visibility = View.GONE

                tvFsbForRent.setTextColor(ContextCompat.getColor(ctx, R.color.md_green_700))
                imgFsbForRent.visibility = View.VISIBLE
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvFsbForSale -> {
                tvFsbForRent.setTextColor(ContextCompat.getColor(v.context, R.color.md_grey_800))
                imgFsbForRent.visibility = View.GONE

                tvFsbForSale.setTextColor(ContextCompat.getColor(v.context, R.color.md_green_700))
                imgFsbForSale.visibility = View.VISIBLE

                optionSelected = FOR_SALE
                listener?.onOptionSelected(FOR_SALE)
            }
            R.id.tvFsbForRent -> {
                tvFsbForSale.setTextColor(ContextCompat.getColor(v.context, R.color.md_grey_800))
                imgFsbForSale.visibility = View.GONE

                tvFsbForRent.setTextColor(ContextCompat.getColor(v.context, R.color.md_green_700))
                imgFsbForRent.visibility = View.VISIBLE

                optionSelected = FOR_RENT
                listener?.onOptionSelected(FOR_RENT)
            }
        }
    }

    inline fun setSelectionBoxListener(crossinline onOptionSelected: (option: Int) -> Unit) {
        object : SelectionBoxListener {
            override fun onOptionSelected(option: Int) {
                onOptionSelected(option)
            }
        }
    }

    interface SelectionBoxListener {
        fun onOptionSelected(option: Int)
    }

    companion object {
        const val FOR_SALE = 0
        const val FOR_RENT = 1
    }
}
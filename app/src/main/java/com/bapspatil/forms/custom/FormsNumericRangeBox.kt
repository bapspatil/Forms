package com.bapspatil.forms.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.bapspatil.forms.R
import kotlinx.android.synthetic.main.forms_numeric_range_box.view.*

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class FormsNumericRangeBox : LinearLayout, View.OnClickListener {

    var postfix: String? = null
    var prefix: String? = null
    var maxValue: Int? = null
    var minValue: Int? = null
    var maxTitle: String? = null
    var minTitle: String? = null
    var title: String? = null
    var subtitle: String? = null

    private var listener: FormsNumericRangeBox.SelectionBoxListener? = null

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
        View.inflate(ctx, R.layout.forms_numeric_range_box, this)
        fnrbMinMaxTextView.setOnClickListener(this)
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.FormsSelectionBox, defStyle, 0)
            postfix = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_postfix)
            prefix = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_prefix)
            maxValue = attributes.getInt(R.styleable.FormsNumericRangeBox_fnrb_maxValue, -1)
            minValue = attributes.getInt(R.styleable.FormsNumericRangeBox_fnrb_minValue, -1)
            maxTitle = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_maxTitle)
            minTitle = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_minTitle)
            title = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_title)
            subtitle = attributes.getString(R.styleable.FormsNumericRangeBox_fnrb_subtitle)
            attributes.recycle()
        }
        updateUI(ctx)
    }

    private fun updateUI(ctx: Context?) {
        if (title != null)
            fnrbTitleTextView.text = title
        if (subtitle != null)
            fnrbSubtitleTextView.text = subtitle

        if (maxTitle != null)
            fnrbMaxTitleTextView.text = maxTitle
        if (minTitle != null)
            fnrbMinTitleTextView.text = minTitle

        var maxString = "Any"
        if (maxValue != -1) {
            if (postfix != null) {
                maxString = "$maxValue$postfix"
            }
            if (prefix != null) {
                maxString = "$prefix$maxValue"
            }
        }
        var minString = "Any"
        if (minValue != -1) {
            if (postfix != null) {
                minString = "$minValue$postfix"
            }
            if (prefix != null) {
                minString = "$prefix$minValue"
            }
        }
        fnrbMinMaxTextView.text = "$minString - $maxString"
    }

    override fun onClick(v: View?) {

    }

    fun setSelectionBoxListener(selectionBoxListener: SelectionBoxListener): FormsNumericRangeBox {
        listener = selectionBoxListener
        return this
    }

    inline fun setSelectionBoxListener(crossinline onOptionSelected: (option: Int) -> Unit): FormsNumericRangeBox {
        object : SelectionBoxListener {
            override fun onOptionSelected(option: Int) {
                onOptionSelected(option)
            }
        }
        return this@FormsNumericRangeBox
    }

    interface SelectionBoxListener {
        fun onOptionSelected(option: Int)
    }
}
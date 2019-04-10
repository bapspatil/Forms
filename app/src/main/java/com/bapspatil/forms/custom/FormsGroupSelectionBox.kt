package com.bapspatil.forms.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.bapspatil.forms.R
import com.bapspatil.forms.model.OptionsItem
import kotlinx.android.synthetic.main.forms_group_selection_box.view.*
import kotlinx.android.synthetic.main.forms_group_selection_item.view.*

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class FormsGroupSelectionBox : LinearLayout, View.OnClickListener {

    var numberOfOptions: Int = DEFAULT_NUMBER_OF_OPTIONS
    private var listener: FormsGroupSelectionBox.SelectionBoxListener? = null

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
        View.inflate(ctx, R.layout.forms_group_selection_box, this)
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.FormsGroupSelectionBox, defStyle, 0)
            attributes.recycle()
        }
        // updateUI(ctx)
    }

    private fun updateUI(ctx: Context?) {
        val defaultSelectedTextView = radioGroupFsbRentalType[0].findViewById(R.id.fgsbRadioButtonTextView) as TextView
        defaultSelectedTextView.setBackgroundResource(R.drawable.group_item_selected_bg)
        defaultSelectedTextView.setTextColor(ContextCompat.getColor(radioGroupFsbRentalType.context, R.color.md_blue_700))
    }

    override fun onClick(v: View?) {
        for (i in 0..(radioGroupFsbRentalType.childCount - 1)) {
            val unselectedTextView = radioGroupFsbRentalType[i].findViewById(R.id.fgsbRadioButtonTextView) as TextView
            unselectedTextView.setBackgroundResource(R.drawable.group_item_unselected_bg)
            unselectedTextView.setTextColor(ContextCompat.getColor(radioGroupFsbRentalType.context, R.color.md_grey_700))
        }
        val selectedTextView = v as TextView
        selectedTextView.setBackgroundResource(R.drawable.group_item_selected_bg)
        selectedTextView.setTextColor(ContextCompat.getColor(radioGroupFsbRentalType.context, R.color.md_blue_700))
        val optionSelectedLabel = selectedTextView.text.toString()
        val optionSelectedValue = selectedTextView.contentDescription.toString()

        listener?.onOptionSelected(optionSelectedLabel, optionSelectedValue)
    }

    fun addOption(optionsItem: OptionsItem) {
        radioGroupFsbRentalType.addView(
            LayoutInflater.from(this@FormsGroupSelectionBox.context).inflate(R.layout.forms_group_selection_item, null).apply {
                numberOfOptions++
                id = numberOfOptions++
                fgsbRadioButtonTextView.text = optionsItem.label
                fgsbRadioButtonTextView.contentDescription = optionsItem.value
                fgsbRadioButtonTextView.setOnClickListener(this@FormsGroupSelectionBox)
            }
        )
        updateUI(radioGroupFsbRentalType.context)
    }

    fun addOptions(optionsItems: ArrayList<OptionsItem>) {
        optionsItems.forEach { optionsItem ->
            radioGroupFsbRentalType.addView(
                LayoutInflater.from(this@FormsGroupSelectionBox.context).inflate(R.layout.forms_group_selection_item, null).apply {
                    numberOfOptions++
                    id = numberOfOptions++
                    fgsbRadioButtonTextView.text = optionsItem.label
                    fgsbRadioButtonTextView.contentDescription = optionsItem.value
                    fgsbRadioButtonTextView.setOnClickListener(this@FormsGroupSelectionBox)
                }
            )
        }
        updateUI(radioGroupFsbRentalType.context)
    }

    fun setSelectionBoxListener(selectionBoxListener: SelectionBoxListener): FormsGroupSelectionBox {
        listener = selectionBoxListener
        return this
    }

    inline fun setSelectionBoxListener(crossinline onOptionSelected: (optionLabel: String, optionValue: String) -> Unit): FormsGroupSelectionBox {
        object : SelectionBoxListener {
            override fun onOptionSelected(optionLabel: String, optionValue: String) {
                onOptionSelected(optionLabel, optionValue)
            }
        }
        return this@FormsGroupSelectionBox
    }

    interface SelectionBoxListener {
        fun onOptionSelected(optionLabel: String, optionValue: String)
    }

    companion object {
        const val DEFAULT_NUMBER_OF_OPTIONS = 0
    }
}
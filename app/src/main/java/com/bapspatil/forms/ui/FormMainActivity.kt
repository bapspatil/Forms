package com.bapspatil.forms.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bapspatil.forms.R
import com.bapspatil.forms.custom.FormsGroupSelectionBox
import com.bapspatil.forms.custom.FormsSelectionBox
import com.bapspatil.forms.model.MainPage
import com.bapspatil.forms.model.OptionsItem
import com.bapspatil.forms.model.RowsItem
import com.bapspatil.forms.model.SectionsItem
import kotlinx.android.synthetic.main.activity_form_main.*

class FormMainActivity : AppCompatActivity() {

    lateinit var mainPageModel: MainPage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_main)

        mainPageModel = MainPage(
            title = "Filter",
            key = "main_page",
            sections = arrayListOf(
                SectionsItem(rows = arrayListOf(RowsItem(type = "selection", value = "sale", key = "listing_type"))),
                SectionsItem(rows = arrayListOf(
                    RowsItem(type = "group_selection", value = "unit", key = "rental_type")
                ))
            )
        )

        selectionBox.setSelectionBoxListener(object : FormsSelectionBox.SelectionBoxListener {
            override fun onOptionSelected(option: Int) {
                when (option) {
                    FormsSelectionBox.FOR_SALE -> {
                        mainPageModel.sections?.get(0)?.rows?.get(0)?.value = "sale"
                        updateUiForRentalTypeRow("sale")
                    }
                    FormsSelectionBox.FOR_RENT -> {
                        mainPageModel.sections?.get(0)?.rows?.get(0)?.value = "rent"
                        updateUiForRentalTypeRow("rent")
                    }
                }
            }
        })

        rentalTypeGroupSelectionBox.addOptions(
            arrayListOf(
                OptionsItem(
                    "Entire Home",
                    "unit"
                ),
                OptionsItem(
                    "Room",
                    "room"
                )
            )
        )
        rentalTypeGroupSelectionBox.setSelectionBoxListener(object : FormsGroupSelectionBox.SelectionBoxListener {
            override fun onOptionSelected(optionLabel: String, optionValue: String) {
                mainPageModel.sections?.get(1)?.rows?.get(0)?.value = optionValue
            }
        })

    }

    fun updateUiForRentalTypeRow(listingType: String) {
        if (listingType == "sale") {
            rentalTypeTitleTextView.visibility = View.GONE
            rentalTypeGroupSelectionBox.visibility = View.GONE
        } else if (listingType == "rent") {
            rentalTypeTitleTextView.visibility = View.VISIBLE
            rentalTypeGroupSelectionBox.visibility = View.VISIBLE
        }
    }
}

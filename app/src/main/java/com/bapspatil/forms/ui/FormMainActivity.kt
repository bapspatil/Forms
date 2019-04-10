package com.bapspatil.forms.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bapspatil.forms.R
import com.bapspatil.forms.custom.FormsSelectionBox
import kotlinx.android.synthetic.main.activity_form_main.*

class FormMainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_main)

        selectionBox.setSelectionBoxListener(object : FormsSelectionBox.SelectionBoxListener {
            override fun onOptionSelected(option: Int) {
                // TODO: Set the model data here.
            }
        })
    }
}

package com.bapspatil.forms.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bapspatil.forms.R
import kotlinx.android.synthetic.main.activity_form_main.*

class FormMainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_main)

        selectionBox.setSelectionBoxListener { option ->
            // TODO: Set data to model here
        }
    }
}

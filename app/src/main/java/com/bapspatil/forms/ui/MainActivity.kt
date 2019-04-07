package com.bapspatil.forms.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bapspatil.forms.FormsApp
import com.bapspatil.forms.R
import com.bapspatil.forms.adapter.SectionsAdapter
import com.bapspatil.forms.model.FormModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = FormsApp.formJsonService.getForm()
        call.enqueue(object : Callback<FormModel> {
            override fun onFailure(call: Call<FormModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error fetching details!", Toast.LENGTH_LONG).show()
                Log.d(MainActivity.TAG, t.message)
            }

            override fun onResponse(call: Call<FormModel>, response: Response<FormModel>) {
                if (response != null) {
                    // Page title
                    val pageTitle = response.body()?.form?.pages?.mainPage?.title
                    if (pageTitle != null && pageTitle.isNotEmpty()) {
                        tvPageTitle.text = pageTitle
                    }

                    // Page sections
                    val sections = response.body()?.form?.pages?.mainPage?.sections
                    if (sections != null && sections.isNotEmpty()) {
                        rvSections.adapter = SectionsAdapter(sections)
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}

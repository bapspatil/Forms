package com.bapspatil.forms.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bapspatil.forms.FormsApp
import com.bapspatil.forms.R
import com.bapspatil.forms.model.FormModel
import com.bapspatil.forms.util.FormConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val call = FormsApp.formJsonService.getForm()
        call.enqueue(object : Callback<FormModel> {
            override fun onFailure(call: Call<FormModel>, t: Throwable) {
                Toast.makeText(this@SplashActivity, "Error fetching details!", Toast.LENGTH_LONG).show()
                Log.d(TAG, t.message)
            }

            override fun onResponse(call: Call<FormModel>, response: Response<FormModel>) {
                if (response != null) {
                    val entryPage = response.body()?.form?.entryPage
                    when (entryPage) {
                        FormConstants.MAIN_PAGE -> {
                            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        }
                        FormConstants.MORE_FILTERS_PAGE -> {
                            startActivity(Intent(this@SplashActivity, MoreFiltersActivity::class.java))
                        }
                        FormConstants.PROPERTY_TYPE_PAGE -> {
                            startActivity(Intent(this@SplashActivity, PropertyTypeActivity::class.java))
                        }
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "SplashActivity"
    }
}

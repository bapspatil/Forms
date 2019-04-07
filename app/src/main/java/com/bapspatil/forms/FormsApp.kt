package com.bapspatil.forms

import android.app.Application
import com.bapspatil.forms.network.FormJsonService

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

class FormsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        formJsonService = FormJsonService.create()
    }

    companion object {
        lateinit var formJsonService: FormJsonService
    }
}
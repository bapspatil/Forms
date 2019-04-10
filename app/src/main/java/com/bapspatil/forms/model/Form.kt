package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Form(

	@SerializedName("pages")
    @Expose
	var pages: Pages? = null,

	@SerializedName("entry_page")
    @Expose
	var entryPage: String? = null
)
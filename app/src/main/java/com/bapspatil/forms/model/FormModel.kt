package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FormModel(

	@SerializedName("form")
	@Expose
	var form: Form? = null
)
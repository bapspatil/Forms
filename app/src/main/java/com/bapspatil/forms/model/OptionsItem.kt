package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OptionsItem(

	@SerializedName("label")
	@Expose
	val label: String? = null,

	@SerializedName("value")
	@Expose
	val value: String? = null
)
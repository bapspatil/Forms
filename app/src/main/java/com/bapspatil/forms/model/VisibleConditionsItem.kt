package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VisibleConditionsItem(

	@SerializedName("listing_type")
	@Expose
	val listingType: String? = null,

	@SerializedName("main_category")
	@Expose
	val mainCategory: String? = null
)
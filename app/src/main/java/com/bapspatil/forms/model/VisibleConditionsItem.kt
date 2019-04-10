package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VisibleConditionsItem(

	@SerializedName("listing_type")
	@Expose
	var listingType: String? = null,

	@SerializedName("main_category")
	@Expose
	var mainCategory: String? = null
)
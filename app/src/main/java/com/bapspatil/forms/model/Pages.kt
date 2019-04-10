package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pages(

	@SerializedName("property_type_page")
	@Expose
	var propertyTypePage: PropertyTypePage? = null,

	@SerializedName("main_page")
	@Expose
	var mainPage: MainPage? = null,

	@SerializedName("more_filters_page")
	@Expose
	var moreFiltersPage: MoreFiltersPage? = null
)
package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainPage(

	@SerializedName("title")
	@Expose
	var title: String? = null,

	@SerializedName("sections")
	@Expose
	var sections: ArrayList<SectionsItem?>? = null,

	@SerializedName("key")
	@Expose
	var key: String? = null
)
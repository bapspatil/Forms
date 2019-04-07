package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PropertyTypePage(

	@SerializedName("title")
	@Expose
	val title: String? = null,

	@SerializedName("sections")
	@Expose
	val sections: List<SectionsItem?>? = null,

	@SerializedName("key")
	@Expose
	val key: String? = null
)
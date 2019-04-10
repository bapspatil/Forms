package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SectionsItem(

	@SerializedName("visible_conditions")
	@Expose
	var visibleConditions: ArrayList<HashMap<String, String>>? = null,

	@SerializedName("hidden")
	@Expose
	var hidden: Boolean? = null,

	@SerializedName("footer")
	@Expose
	var footer: String? = null,

	@SerializedName("rows")
	@Expose
	var rows: ArrayList<RowsItem?>? = null,

	@SerializedName("title")
	@Expose
	var title: String? = null
)
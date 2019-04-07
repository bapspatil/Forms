package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SectionsItem(

	@SerializedName("visible_conditions")
	@Expose
	val visibleConditions: ArrayList<HashMap<String, String>>? = null,

	@SerializedName("hidden")
	@Expose
	val hidden: Boolean? = null,

	@SerializedName("footer")
	@Expose
	val footer: String? = null,

	@SerializedName("rows")
	@Expose
	val rows: List<RowsItem?>? = null,

	@SerializedName("title")
	@Expose
	val title: String? = null
)
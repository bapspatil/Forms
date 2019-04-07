package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RowsItem(

	@SerializedName("visible_conditions")
	@Expose
	val visibleConditions: ArrayList<HashMap<String, String>>? = null,

	@SerializedName("hidden")
	@Expose
	val hidden: Boolean? = null,

	@SerializedName("subtitle")
	@Expose
	val subtitle: String? = null,

	@SerializedName("title")
	@Expose
	val title: String? = null,

	@SerializedName("type")
	@Expose
	val type: String? = null,

	@SerializedName("listing_attribute")
	@Expose
	val listingAttribute: String? = null,

	@SerializedName("value")
	@Expose
	val value: Any? = null,

	@SerializedName("key")
	@Expose
	val key: String? = null,

	@SerializedName("info")
	@Expose
	val info: String? = null
)
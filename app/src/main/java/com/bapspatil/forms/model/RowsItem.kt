package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RowsItem(

	@SerializedName("visible_conditions")
	@Expose
	val visibleConditions: Any? = null,

	@SerializedName("hidden")
	@Expose
	val hidden: Any? = null,

	@SerializedName("subtitle")
	@Expose
	val subtitle: Any? = null,

	@SerializedName("title")
	@Expose
	val title: String? = null,

	@SerializedName("type")
	@Expose
	val type: String? = null,

	@SerializedName("listing_attribute")
	@Expose
	val listingAttribute: Any? = null,

	@SerializedName("value")
	@Expose
	val value: String? = null,

	@SerializedName("key")
	@Expose
	val key: String? = null,

	@SerializedName("info")
	@Expose
	val info: Any? = null
)
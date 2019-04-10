package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RowsItem(

	@SerializedName("visible_conditions")
	@Expose
	var visibleConditions: ArrayList<HashMap<String, String>>? = null,

	@SerializedName("hidden")
	@Expose
	var hidden: Boolean? = null,

	@SerializedName("subtitle")
	@Expose
	var subtitle: String? = null,

	@SerializedName("title")
	@Expose
	var title: String? = null,

	@SerializedName("type")
	@Expose
	var type: String? = null,

	@SerializedName("listing_attribute")
	@Expose
	var listingAttribute: String? = null,

	@SerializedName("value")
	@Expose
	var value: Any? = null,

	@SerializedName("key")
	@Expose
	var key: String? = null,

	@SerializedName("info")
	@Expose
	var info: String? = null
)
package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupsItem(

	@SerializedName("values")
	@Expose
	var values: ArrayList<String?>? = null
)
package com.bapspatil.forms.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupsItem(

	@SerializedName("values")
	@Expose
	val values: ArrayList<String?>? = null
)
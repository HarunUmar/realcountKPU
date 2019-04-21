package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName


data class Jokowi(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("percent")
	val percent: Double? = null
)
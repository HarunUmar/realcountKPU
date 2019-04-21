package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName

data class Progress(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("proses")
	val proses: Int? = null,

	@field:SerializedName("percent")
	val percent: Double? = null
)
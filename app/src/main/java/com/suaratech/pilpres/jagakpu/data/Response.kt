package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName


data class Response(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("results")
	val results: Results? = null
)
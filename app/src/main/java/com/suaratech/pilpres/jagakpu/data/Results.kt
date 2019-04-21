package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName


data class Results(

		@field:SerializedName("prabowo")
		val prabowo: Prabowo? = null,

		@field:SerializedName("progress")
	val progress: Progress? = null,

		@field:SerializedName("details")
	val details: List<DetailsItem?>? = null,

		@field:SerializedName("jokowi")
	val jokowi: Jokowi? = null,

		@field:SerializedName("version")
	val version: String? = null
)
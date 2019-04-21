package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName


data class Count(

		@field:SerializedName("prabowo")
	val prabowo: Prabowo? = null,

		@field:SerializedName("jokowi")
	val jokowi: Jokowi? = null
)
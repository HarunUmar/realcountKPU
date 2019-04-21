package com.suaratech.pilpres.jagakpu.data


import com.google.gson.annotations.SerializedName


data class DetailsItem(

		@field:SerializedName("count")
	val count: Count? = null,

		@field:SerializedName("wilayah")
	val wilayah: String? = null
)
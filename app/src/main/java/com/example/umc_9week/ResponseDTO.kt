package com.example.umc_9week

import com.google.gson.annotations.SerializedName

//응답 DTO
data class ResponseDTO(
    @SerializedName("PageNo")
    val PageNo: Int,
    @SerializedName("numOfRows")
    val numOfRows: Int,
    @SerializedName("item")
    val item: MutableList<Faq_item>
)

data class Faq_item(
    @SerializedName("FAQ_ID")
    val faqID: String,
    @SerializedName("TITLE")
    val title: String
)

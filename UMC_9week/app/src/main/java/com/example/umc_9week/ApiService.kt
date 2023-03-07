package com.example.umc_9week

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object{
        private const val authKey ="mRmiaekybBvjgN0UjRrbfWREcpVo99S6yBza1pkNg6Xx7GNVraOe5s4x0krvPOjVCOKQubH7QLuHeby3g3OvZQ=="
    }

    @GET("getDetail")
    fun getDetail(
        @Query("PageNo")
        PageNo: Int = 1,
        @Query("numOfRows")
        numOfRows: Int = 10,
        @Query("serviceKey")
        serviceKey: String = authKey
    ):Call<ResponseDTO>
}
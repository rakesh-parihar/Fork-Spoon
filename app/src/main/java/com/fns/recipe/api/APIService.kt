package com.fns.recipe.api

import com.fns.recipe.api.model.ResponseModel
import com.fns.recipe.util.SPACE_ID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("spaces/$SPACE_ID/entries")
    fun getRecipes(@Query("access_token") token: String, @Query("content_type") content_type: String): Call<ResponseModel>

}
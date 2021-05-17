package edu.uw.vanessasgh.dotify.repository

import edu.uw.vanessasgh.dotify.model.Profile
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class DataRepository {
    private val userService = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserService::class.java)

    suspend fun getUserInfo(): Profile = userService.getUserInfo()
}

interface UserService {
    @GET("echeeUW/codesnippets/master/user_info.json")
    suspend fun getUserInfo(): Profile
}
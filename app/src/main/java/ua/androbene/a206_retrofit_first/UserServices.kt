package ua.androbene.a206_retrofit_first

import retrofit2.http.GET

interface UserServices {
    @GET("users")
    suspend fun getUsers(): List<User>
}


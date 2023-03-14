package ua.androbene.a206_retrofit_first.retrofit_GetNames

import retrofit2.http.GET
import ua.androbene.a206_retrofit_first.User

interface UserServices {
    @GET("users")
    suspend fun getUsers(): List<User>
}


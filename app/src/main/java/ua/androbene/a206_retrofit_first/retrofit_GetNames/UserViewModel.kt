package ua.androbene.a206_retrofit_first.retrofit_GetNames

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.androbene.a206_retrofit_first.User

class UserViewModel : ViewModel() {
    val users = MutableLiveData<List<User>>()
    val message = MutableLiveData<String?>()
    private val userServices: UserServices = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(UserServices::class.java)

    init {
        viewModelScope.launch {
            try {
                message.postValue("Loading...")
                delay(777) // for clarity
                val data = userServices.getUsers()
                users.postValue(data)
                message.postValue(null)
            } catch (ex: Exception) {
                Log.d("mylog", "During get data the next problem has occurred: \n\t --->>>   $ex")
                message.postValue("Server encountered error.")
            }
        }
    }
}

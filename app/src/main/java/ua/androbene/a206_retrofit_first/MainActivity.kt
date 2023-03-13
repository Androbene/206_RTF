package ua.androbene.a206_retrofit_first

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ua.androbene.a206_retrofit_first.databinding.ActivityMainBinding

// *************************************************************************************************************
// sample from here: https://medium.com/canopas/android-reactive-programming-with-coroutines-and-mvvm-74cd4117df3a
// data from here: https://jsonplaceholder.typicode.com/users

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val model: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.usersList.adapter = UserAdapter().apply {
            model.users.observe(this@MainActivity) {
                this.users = it
            }
        }
        model.message.observe(this) {
            binding.message.text = it
        }
    }
}
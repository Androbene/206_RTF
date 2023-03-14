package ua.androbene.a206_retrofit_first.retrofit_GetNames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import ua.androbene.a206_retrofit_first.UserAdapter
import ua.androbene.a206_retrofit_first.base.BaseFragment
import ua.androbene.a206_retrofit_first.databinding.FragmentRetrofitGetNamesBinding

// *************************************************************************************************************
// sample from here: https://medium.com/canopas/android-reactive-programming-with-coroutines-and-mvvm-74cd4117df3a
// data from here: https://jsonplaceholder.typicode.com/users

class RetrofitGetNamesFrag : BaseFragment<FragmentRetrofitGetNamesBinding>() {

    private val model: UserViewModel by viewModels()

    override fun inflateFrag(inflater: LayoutInflater): FragmentRetrofitGetNamesBinding =
        FragmentRetrofitGetNamesBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usersList.adapter = UserAdapter().apply {
            model.users.observe(viewLifecycleOwner) {
                this.users = it
            }
        }
        model.message.observe(viewLifecycleOwner) {
            binding.message.text = it
        }
    }

}
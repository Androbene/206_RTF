package ua.androbene.a206_retrofit_first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import ua.androbene.a206_retrofit_first.base.BaseFragment
import ua.androbene.a206_retrofit_first.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun inflateFrag(inflater: LayoutInflater): FragmentMainBinding =
        FragmentMainBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btn1.setOnClickListener { findNavController().navigate(R.id.retrofitGetNamesFrag) }
        }
    }

}
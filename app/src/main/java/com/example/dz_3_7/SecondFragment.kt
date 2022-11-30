package com.example.dz_3_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dz_3_7.databinding.ActivityMainBinding
import com.example.dz_3_7.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var position = arguments?.getInt("POSITION")
        var heroList = arguments?.getSerializable("HERO_LIST") as ArrayList<Hero>

        binding.tvNameDetail.text = heroList[position!!].name
        binding.tvStatusDetail.text = heroList[position!!].status
        Glide.with(binding.ivAvatarDetail).load(heroList[position].image).into(binding.ivAvatarDetail)

    }
}
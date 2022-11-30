package com.example.dz_3_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dz_3_7.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var  heroAdapter: HeroAdapter
    private var heroList = arrayListOf<Hero>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroList.clear()
        loadData()

        heroAdapter = HeroAdapter(heroList, this::onClick)
       binding.rvHero.adapter = heroAdapter
    }

    private fun onClick(position:Int){
        val bundleHero = Bundle()
        bundleHero.putSerializable("HERO_LIST", heroList)
        bundleHero.putInt("POSITION", position)

        findNavController().navigate(R.id.secondFragment, bundleHero)
    }

    private fun loadData() {
        heroList.add(Hero("Милиодас", "alive", "https://kartinkin.net/uploads/posts/2021-07/1625625683_13-kartinkin-com-p-meliodas-art-art-krasivo-13.jpg"))
        heroList.add(Hero("Бан ", "alive", "https://pibig.info/uploads/posts/2022-05/1653352170_13-pibig-info-p-ban-sem-smertnikh-grekhov-art-krasivo-14.jpg"))
        heroList.add(Hero("Эсканор", "alive", "https://damion.club/uploads/posts/2022-09/1664329554_4-damion-club-p-grekh-gordinya-art-vkontakte-4.jpg"))
        heroList.add(Hero("Диана ", "alive", "http://pm1.narvii.com/6394/1a599fe7407c64281f28e1bc74a0f10286b96a74_00.jpg"))
        heroList.add(Hero("Кинг", "alive", "https://pm1.narvii.com/6395/1a786d10ab27d7e7be1db2f3c190ea0167366c54_hq.jpg"))
        heroList.add(Hero("Мерлин", "alive", "https://img.niadd.com/manga3/56/10026999/100217371/3508741_2020120416362.jpg"))
        heroList.add(Hero("Гаутер", "alive", "https://img.wattpad.com/cover/274084605-256-k179488.jpg"))
        heroList.add(Hero("Элизабет", "alive", "https://i.pinimg.com/736x/a7/e3/ed/a7e3edfe6a2959ff423fa24c1cd1a182.jpg"))
        heroList.add(Hero("Команда", "alive", "https://damion.club/uploads/posts/2022-09/1664286230_1-damion-club-p-sem-smertnikh-grekhov-art-krasivo-2.jpg"))

    }
}
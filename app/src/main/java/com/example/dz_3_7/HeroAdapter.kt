package com.example.dz_3_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.dz_3_7.databinding.ItemHeroBinding

class HeroAdapter(private var heroList: List<Hero> ,val onCLick:(position: Int) -> Unit) : Adapter<HeroAdapter.HeroViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroList[position])
    }

    override fun getItemCount(): Int = heroList.size

    inner class HeroViewHolder(private val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(hero:Hero){

            itemView.setOnClickListener{
                onCLick(adapterPosition)
            }

            binding.tvName.text = hero.name
            binding.tvStatus.text = hero.status

            Glide.with(binding.ivAvatar).load(hero.image).into(binding.ivAvatar)
        }
    }
}
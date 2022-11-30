package com.example.dz_3_7

import java.io.Serializable

data class Hero(
    val name:String? = null,
    val status:String? = null,
    val image:String? = null,
) : Serializable

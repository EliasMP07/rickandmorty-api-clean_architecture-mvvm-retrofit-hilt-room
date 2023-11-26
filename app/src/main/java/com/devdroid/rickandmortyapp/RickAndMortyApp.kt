package com.devdroid.rickandmortyapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RickAndMortyApp: Application() {

    companion object{
        private var instancia: RickAndMortyApp? = null

        fun getContext(): Context {
            return instancia!!.applicationContext
        }
    }

    init {
        instancia = this
    }
}
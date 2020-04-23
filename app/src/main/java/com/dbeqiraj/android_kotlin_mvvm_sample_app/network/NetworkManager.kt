package com.dbeqiraj.android_kotlin_mvvm_sample_app.network

internal class NetworkManager {

    private object Instance {
        val INSTANCE = NetworkManager()
    }

    companion object {
        val instance: NetworkManager by lazy { Instance.INSTANCE }
    }

}
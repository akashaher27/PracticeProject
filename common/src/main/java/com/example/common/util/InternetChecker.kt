package com.example.common.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class InternetChecker(context: Context) : LiveData<InternetChecker.InternetState>() {

    private var connectivityManager: ConnectivityManager =
        context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    private var validNetwork: MutableSet<Network> = HashSet()

    override fun onActive() {
        super.onActive()
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun checkValidNetwork() {
        if (validNetwork.size > 0) {
            postValue(InternetState.CONNECTED)
        } else {
            postValue(InternetState.DISCONNECTED)
        }

    }

    private var networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
            val hasInternet =
                networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            if (hasInternet == true) {
                validNetwork.add(network)
            }
            checkValidNetwork()
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            validNetwork.remove(network)
            checkValidNetwork()
        }
    }

    enum class InternetState {
        CONNECTED,
        DISCONNECTED
    }
}
package com.example.network.retrofit

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator() : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        return null
    }

}
package com.dmw.android.wakeupappdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        val TYPE_INTENT = "type"
        val URL_INTENT = "url"
        val NAME_INTENT = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent.data != null) {
            val uri = intent.data
            tvScheme.text = uri?.scheme ?: "no scheme"
            tvHost.text = uri?.host ?: "no host"
            tvAuthority.text = uri?.authority ?: "no authority"

            val type = uri.getQueryParameter(TYPE_INTENT)
            val url = uri.getQueryParameter(URL_INTENT)
            val name = uri.getQueryParameter(NAME_INTENT)

            tvParams.text = "type=$type,url=$url,name=$name"

        }
    }
}

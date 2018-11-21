package com.dmw.android.wakeupappdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {

        val TYPE_INTENT = "type"
        val URL_INTENT = "url"
        val NAME_INTENT = "name"

        fun launch(context: Context) {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

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

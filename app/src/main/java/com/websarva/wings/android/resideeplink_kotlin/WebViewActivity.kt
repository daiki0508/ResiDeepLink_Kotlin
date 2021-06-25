package com.websarva.wings.android.resideeplink_kotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val allowList = resources.getStringArray(R.array.allow_url_list)

        val webView = findViewById<WebView>(R.id.webView)
        val uri = intent.data
        val query = Uri.parse(uri?.getQueryParameter("data"))

        for (url: String in allowList){
            if (query.scheme.equals("https") && query.host.equals(url)){
                webView.loadUrl(query.toString())
            }else{
                Toast.makeText(this, "指定されたURLはリストにありません。", Toast.LENGTH_LONG).show()
            }
        }
    }
}
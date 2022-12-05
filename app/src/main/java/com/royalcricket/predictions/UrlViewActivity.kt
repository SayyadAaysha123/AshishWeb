package com.royalcricket.predictions

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.royalcricket.predictions.databinding.ActivityUrlViewBinding

class UrlViewActivity : AppCompatActivity() {


    lateinit var binding: ActivityUrlViewBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        binding = ActivityUrlViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        binding.webView.webViewClient == WebViewClient()

        // this will load the url of the website
        binding.webView.loadUrl("https://ambanibook.guru")
//        binding.webView.loadUrl("https://ambanibook365.asia")
        // this will enable the javascript settings, it can also allow xss vulnerabilities
        binding.webView.settings.javaScriptEnabled

        // if you want to enable zoom feature
        binding.webView.settings.setSupportZoom(true)
    }
}
package io.taly.example

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import io.taly.example.databinding.ActivityCmsWebViewBinding
import io.taly.sdk.utils.SetProgressBarColor

class CmsWebViewActivity : AppCompatActivity() {

    companion object {
        const val WEB_URL = "web_url"
    }

    private lateinit var binding: ActivityCmsWebViewBinding

    private var webUrl: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCmsWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webUrl = intent.getStringExtra(WEB_URL)

        inti()
        initWebView()
    }

    private fun inti() {
        val color = ContextCompat.getColor(this, R.color.progressColor)
        SetProgressBarColor.apply(binding.loader, color)

        binding.backButton.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.clearCache(true)
        binding.webView.clearHistory()
        binding.webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        binding.webView.settings.allowFileAccess = false
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.loader.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.loader.visibility = View.GONE
            }
        }

        val loadWebUrl = webUrl ?: "https://taly.io/home"
        binding.webView.loadUrl(loadWebUrl)
    }
}
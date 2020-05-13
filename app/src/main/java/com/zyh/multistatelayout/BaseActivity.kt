package com.zyh.multistatelayout

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onCreateActivity(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    abstract fun onCreateActivity(savedInstanceState: Bundle?)

    fun showLoading() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_LOADING)
    }

    fun showWaitLoading() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_WAIT_LOADING)
    }

    fun showFail(onFailClickListener: MultiStateLayout.OnFailClickListener) {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_FAIL, onFailClickListener)
    }

    fun showEmpty() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_EMPTY)
    }

    fun hide() {
        multiStateLayout?.setStatus(MultiStateLayout.STATUS_HIDE)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.fontScale != 1f) resources
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        var resources = super.getResources()
        val newConfig = resources.configuration
        val displayMetrics = resources.displayMetrics
        if (newConfig.fontScale != 1f) {
            newConfig.fontScale = 1f
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                val configurationContext = createConfigurationContext(newConfig)
                resources = configurationContext.resources
                displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale
            } else {
                resources.updateConfiguration(newConfig, displayMetrics)
            }
        }
        return resources
    }

}
package com.zyh.multistatelayout
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager


/**
 * 网络状态工具类
 */
object NetStatusUtils {

    fun isNetworkConnected(): Boolean {
        val mConnectivityManager = App.context
            .getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val mNetworkInfo = mConnectivityManager.activeNetworkInfo
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable
        }
        return false
    }

}
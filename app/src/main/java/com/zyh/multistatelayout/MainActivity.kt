package com.zyh.multistatelayout

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        btnLoading.setOnClickListener {
            showLoading()
        }
        btnEmpty.setOnClickListener {
            showEmpty()
        }
        btnFail.setOnClickListener {
            showFail(object : MultiStateLayout.OnFailClickListener {
                override fun click() {
                    Toast.makeText(this@MainActivity,"点击了",Toast.LENGTH_SHORT).show()
                }
            })
        }
        btnWaitLoading.setOnClickListener {
            showWaitLoading()
        }
        btnHide.setOnClickListener {
            multiStateLayout.setStatus(MultiStateLayout.STATUS_HIDE)
        }
    }
}

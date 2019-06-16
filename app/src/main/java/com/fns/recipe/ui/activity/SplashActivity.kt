package com.fns.recipe.ui.activity

import android.os.Bundle
import android.os.Handler
import com.fns.recipe.R
import com.fns.recipe.base.BaseActivity
import com.fns.recipe.util.SPLASH_DELAY

class SplashActivity : BaseActivity() {

    override fun getContentView(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        /**
         * Delayed launch
         */
        Handler().postDelayed({
            launchActivity(ListActivity(), true)
        }, SPLASH_DELAY)
    }
}
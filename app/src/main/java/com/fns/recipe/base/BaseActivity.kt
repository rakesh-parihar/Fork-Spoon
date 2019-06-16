package com.fns.recipe.base

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import androidx.core.view.ViewCompat
import androidx.core.app.ActivityOptionsCompat




abstract class BaseActivity : AppCompatActivity() {

    private val LOGTAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(getContentView())
    }

    protected abstract fun getContentView(): Int


    /**
     * Launchs Activity
     */
    fun launchActivity(activity: AppCompatActivity, doFinish: Boolean = false, bundle: Bundle? = null) {
        var intent = Intent(this@BaseActivity, activity::class.java)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)


        if (doFinish)
            finish()

    }

    /**
     * Checks connectivity
     */
    fun isConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    /**
     * Method to display toast
     */
    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    /**
     * Injecting custom fonts
     */
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

}
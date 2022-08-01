package com.example.shoppingbuddy.activties

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import com.example.shoppingbuddy.R
import kotlinx.android.synthetic.main.activtiy_splash.*

class splashactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtiy_splash)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                val mIntent = Intent(this@splashactivity, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            },2500
        )
        //val typeface: Typeface = Typeface.createFromAsset(assets, "Montserrat-Bold.ttf")
        //tv_app_name.typeface = typeface
    }
}

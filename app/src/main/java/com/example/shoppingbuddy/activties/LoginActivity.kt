package com.example.shoppingbuddy.activties

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowInsets
import android.view.WindowManager
import com.example.shoppingbuddy.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        tv_register.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        tv_forgot_password.setOnClickListener{
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener{
            validateRegisterDetails()
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateRegisterDetails():Boolean{
        return when{
            TextUtils.isEmpty(et_login_mail.text.toString().trim{it <= ' '})->{
                showErrorSnackbar("Please Enter correct E-mail",true)
                false
            }
            TextUtils.isEmpty(et_password.text.toString().trim{it <= ' '})->{
                showErrorSnackbar("Please Enter Password",true)
                false
            }
            else ->{
                showErrorSnackbar("Login Success",false)
                true
            }

        }
    }
}


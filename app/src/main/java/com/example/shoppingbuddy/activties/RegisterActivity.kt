package com.example.shoppingbuddy.activties

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingbuddy.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
       tv_login.setOnClickListener{
           val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
           startActivity(intent)
       }
        btn_register.setOnClickListener{
            validateRegisterDetails()
        }
    }
    private fun setupActionBar(){
        setSupportActionBar(toolbar_register_activity)
        val actionBar=supportActionBar
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        }
        toolbar_register_activity.setNavigationOnClickListener{onBackPressed()}

    }
    private fun validateRegisterDetails():Boolean{
        return when{
            TextUtils.isEmpty(et_first_name.text.toString().trim{it <= ' '})->{
                showErrorSnackbar(resources.getString(R.string.err_msg_enter_first_name),true)
                false
            }
            TextUtils.isEmpty(et_last_name.text.toString().trim{it <= ' '})->{
                showErrorSnackbar(resources.getString(R.string.err_msg_enter_last_name),true)
                false
            }
            TextUtils.isEmpty(et_email.text.toString().trim{it <= ' '})->{
                showErrorSnackbar(resources.getString(R.string.err_msg_enter_email),true)
                false
            }
            TextUtils.isEmpty(et_password.text.toString().trim{it <= ' '})->{
                showErrorSnackbar(resources.getString(R.string.err_msg_enter_password),true)
                false
            }
            TextUtils.isEmpty(et_confirm_password.text.toString().trim{it <= ' '})->{
                showErrorSnackbar(resources.getString(R.string.err_msg_enter_confirm_password),true)
                false
            }
            et_password.text.toString().trim{it <= ' '} != et_confirm_password.text.toString().trim{it <= ' '}->{
                showErrorSnackbar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch),true)
                false
            }
            !cb_terms_and_conditions.isChecked->{
                showErrorSnackbar(resources.getString(R.string.err_msg_i_agree_terms),true)
                false
            }
            else ->{
                showErrorSnackbar("Your details are valid",false)
                true
            }

        }
    }
}



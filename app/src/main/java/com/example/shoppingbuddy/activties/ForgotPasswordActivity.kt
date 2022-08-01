package com.example.shoppingbuddy.activties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.shoppingbuddy.R
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.et_password

class ForgotPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        btn_submit.setOnClickListener {
            validateRegisterDetails()
        }
    }
    private fun setupActionBar(){
        setSupportActionBar(toolbar_register_activity)
        val actionBar = supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        }
    }
    private fun validateRegisterDetails():Boolean{
        return when{
            TextUtils.isEmpty(et_forgot_mail.text.toString().trim{it <= ' '})->{
                showErrorSnackbar("Please Enter E-mail ID",true)
                false
            }

            else ->{
                showErrorSnackbar("E-mail Send for Re-setting password",false)
                true
            }

        }
    }
}
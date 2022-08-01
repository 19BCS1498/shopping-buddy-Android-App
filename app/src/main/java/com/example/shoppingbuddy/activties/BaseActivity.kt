package com.example.shoppingbuddy.activties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.shoppingbuddy.R
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {

    fun showErrorSnackbar(message:String, errorMessage:Boolean){
        val snackBar = Snackbar.make(findViewById(android.R.id.content),message,Snackbar.LENGTH_LONG)
        val snackBarview = snackBar.view

        if(errorMessage){
            snackBarview.setBackgroundColor(
                ContextCompat.getColor(this@BaseActivity,R.color.colorSnackBarerror)
            )
        }
        else{
            snackBarview.setBackgroundColor(
                ContextCompat.getColor(this@BaseActivity,R.color.colorSnackBarSuccess)
            )
        }
     snackBar.show()
    }
}
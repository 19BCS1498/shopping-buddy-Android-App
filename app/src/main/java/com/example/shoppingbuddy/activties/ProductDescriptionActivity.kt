package com.example.shoppingbuddy.activties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.shoppingbuddy.R
import com.example.shoppingbuddy.activties.fragments.CartFragment
import com.example.shoppingbuddy.activties.fragments.WishlistFragment
import kotlinx.android.synthetic.main.activity_product_description.*

class ProductDescriptionActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)
        btn_addtoWishlist.setOnClickListener{
            Toast.makeText(applicationContext,"Item Added to WishList",Toast.LENGTH_SHORT).show()
        }
    }
}
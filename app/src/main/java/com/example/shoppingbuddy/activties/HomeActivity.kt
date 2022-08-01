package com.example.shoppingbuddy.activties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.shoppingbuddy.R
import com.example.shoppingbuddy.activties.fragments.*
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var drawerLayout : DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem: MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawer_layout)
        coordinatorLayout = findViewById(R.id.coordinator_layout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame_menu)
        navigationView = findViewById(R.id.navigation_view)
        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@HomeActivity,
            drawerLayout, R.string.open_drawer,R.string.close_drawer )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked = false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId){
                R.id.menu_orders->{
                   supportFragmentManager.beginTransaction()
                       .replace(R.id.frame_menu,OrderFragment())
                       .addToBackStack("My Order")
                       .commit()
                    supportActionBar?.title="My Orders"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_wish_list->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,WishlistFragment())
                        .addToBackStack("Wishlist")
                        .commit()
                    supportActionBar?.title="Wishlist"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_cart->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,CartFragment())
                        .addToBackStack("Cart")
                        .commit()
                    supportActionBar?.title="Cart"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_account_settings->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,MyAccountFragment())
                        .addToBackStack("My Account")
                        .commit()
                    supportActionBar?.title="My Account"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_help_centre->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,Help_CentreFragment())
                        .addToBackStack("Help Centre")
                        .commit()
                    supportActionBar?.title="Help Centre"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_about_us->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,AboutUsFragment())
                        .addToBackStack("About Us")
                        .commit()
                    supportActionBar?.title="About Us"
                    drawerLayout.closeDrawers()
                }
                R.id.menu_home->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_menu,HomeFragment())
                        .addToBackStack("Home")
                        .commit()
                    supportActionBar?.title="Home"
                    drawerLayout.closeDrawers()
                }

            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.shoppingbuddy.activties.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingbuddy.R
import com.example.shoppingbuddy.activties.ProductDescriptionActivity
import com.example.shoppingbuddy.activties.models.Products

class HomeRecyclerAdapter(val context:Context,val itemList:ArrayList<Products>):RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
    class HomeViewHolder(view:View):RecyclerView.ViewHolder(view){
        val productName:TextView=view.findViewById(R.id.txt_recycle_view_product_name)
        val productCompany:TextView=view.findViewById(R.id.txt_recycle_view_company_name)
        val productPrice:TextView=view.findViewById(R.id.txt_product_price)
        val productRating:TextView=view.findViewById(R.id.txt_product_rating)
        val productImage:ImageView=view.findViewById(R.id.imgv_recycle_view_img)
        val llcontent:LinearLayout=view.findViewById(R.id.ll_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_view_single_product,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val productData = itemList[position]
        holder.productName.text=productData.productName
        holder.productCompany.text=productData.productCompany
        holder.productPrice.text=productData.productPrice
        holder.productRating.text=productData.productRating
        holder.productImage.setImageResource(productData.productImage)
        holder.llcontent.setOnClickListener{
            val intent=Intent(context,ProductDescriptionActivity::class.java)
            intent.putExtra("productName", holder.productName.text.toString())
            intent.putExtra("productCompany", holder.productCompany.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
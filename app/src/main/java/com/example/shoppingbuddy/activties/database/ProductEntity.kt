package com.example.shoppingbuddy.activties.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntity(
    @PrimaryKey val productName:String,
    @ColumnInfo(name = "product_company") val productCompany:String,
    @ColumnInfo(name = "product_price")val productPrice:String,
    @ColumnInfo(name = "product_rating")val productRating:String,
    @ColumnInfo(name = "product_desc")val productDesc:String,
    @ColumnInfo(name = "product_img")val productImage:Int
)



package com.example.shoppingbuddy.activties.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDAO {
    @Insert
    fun insertProduct(productEntity: ProductEntity)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM products")
    fun getAllProducts():List<ProductEntity>

   // @Query("SELECT * FROM products WHERE productName=productName")
   // fun getProductbyName(product_name:String):ProductEntity
}
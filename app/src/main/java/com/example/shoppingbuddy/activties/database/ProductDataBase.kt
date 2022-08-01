package com.example.shoppingbuddy.activties.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class],version = 1)
abstract class ProductDataBase:RoomDatabase() {
    //abstract fun Product_dao():ProductDAO
}
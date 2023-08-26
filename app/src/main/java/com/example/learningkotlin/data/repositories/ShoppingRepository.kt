package com.example.learningkotlin.data.repositories

import com.example.learningkotlin.data.db.ShoppingDB
import com.example.learningkotlin.data.db.entities.ShoppingItem

class ShoppingRepository (
    private val db: ShoppingDB
){
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}
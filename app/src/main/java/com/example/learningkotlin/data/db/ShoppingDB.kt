package com.example.learningkotlin.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learningkotlin.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDB : RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDB(context).also { instance = it }
        }

        private fun createDB(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDB::class.java, "ShoppingDB.db").build()
    }
}
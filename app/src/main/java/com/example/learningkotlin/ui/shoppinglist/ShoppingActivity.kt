package com.example.learningkotlin.ui.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.learningkotlin.R
import com.example.learningkotlin.data.db.ShoppingDB
import com.example.learningkotlin.data.repositories.ShoppingRepository


class ShoppingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDB(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]
    }
}

package com.example.myapplication;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

private lateinit var viewModel: MyViewModel
private lateinit var compositeView: MyCompositeView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        compositeView = findViewById(R.id.myCompositeView)

        // Passing ViewModel to the composite view
        compositeView.setViewModel(viewModel)
        }
        }

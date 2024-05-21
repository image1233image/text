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

        // Simulating data change
        viewModel.textValue = "Hello, World!"
        viewModel.isChecked = true

        // Binding ViewModel to CompositeView
        compositeView.bind(viewModel)
        }
        }

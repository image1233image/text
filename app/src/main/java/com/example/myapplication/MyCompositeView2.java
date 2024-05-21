package com.example.myapplication;

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible

class MyCompositeView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

private val textView: TextView
private val checkBox: CheckBox
private var viewModel: MyViewModel? = null

        init {
        inflate(context, R.layout.my_composite_view, this)
        orientation = VERTICAL
        textView = findViewById(R.id.textView)
        checkBox = findViewById(R.id.checkBox)
        }

        fun setViewModel(viewModel: MyViewModel) {
        this.viewModel = viewModel
        updateUI()
        }

private fun updateUI() {
        viewModel?.let { vm ->
        textView.text = vm.textValue
        checkBox.isChecked = vm.isChecked
        checkBox.isVisible = vm.textValue.isNotEmpty() // Only show checkbox if text is not empty
        }
        }
        }

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

        init {
        inflate(context, R.layout.my_composite_view, this)
        orientation = VERTICAL
        textView = findViewById(R.id.textView)
        checkBox = findViewById(R.id.checkBox)
        }

        fun bind(viewModel: MyViewModel) {
        textView.text = viewModel.textValue
        checkBox.isChecked = viewModel.isChecked
        checkBox.isVisible = viewModel.textValue.isNotEmpty() // Only show checkbox if text is not empty
        }
        }

package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomCompositeViewModel viewModel = new ViewModelProvider(this).get(CustomCompositeViewModel.class);

        CustomCompositeView customCompositeView = findViewById(R.id.custom_composite_view);

        // 使用Data Binding来绑定ViewModel
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }
}

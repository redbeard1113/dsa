package com.example.loginscreen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginscreen1.adapter.CustomAdapter
import com.example.loginscreen1.databinding.ActivityResultBinding
import com.example.loginscreen1.viewmodel.ItemsViewModel

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_foreground, "Item " + i))
        }

        val recyclerView  = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            adapter.addItem(ItemsViewModel(R.drawable.ic_launcher_foreground, "Item New"))
        }
    }
}

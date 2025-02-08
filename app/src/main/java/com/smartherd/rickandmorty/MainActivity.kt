package com.smartherd.rickandmorty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.rickandmorty.adapter.CharacterAdapter
import com.smartherd.rickandmorty.databinding.ActivityMainBinding
import com.smartherd.rickandmorty.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        adapter = CharacterAdapter(mutableListOf()) // Start with an empty list
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Fetch data
        viewModel.fetchCharacters()

        // Observe LiveData and update adapter dynamically
        viewModel.characters.observe(this) { characters ->
            adapter.updateData(characters)
        }
    }
}

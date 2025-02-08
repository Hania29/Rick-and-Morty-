package com.smartherd.rickandmorty

import android.content.Intent
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

        adapter = CharacterAdapter(mutableListOf()) { character ->
            val intent = Intent(this, CharacterDetailActivity::class.java)
            intent.putExtra("CHARACTER_ID", character.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.fetchCharacters()

        viewModel.characters.observe(this) { characters ->
            adapter.updateData(characters)
        }
    }
}


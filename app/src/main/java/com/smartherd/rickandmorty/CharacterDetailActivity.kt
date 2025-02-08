package com.smartherd.rickandmorty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.smartherd.rickandmorty.databinding.ActivityCharacterDetailBinding
import com.smartherd.rickandmorty.viewmodel.CharacterDetailViewModel

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterId = intent.getIntExtra("CHARACTER_ID", -1)

        if (characterId != -1) {
            viewModel.fetchCharacterDetails(characterId)
        }

        viewModel.character.observe(this) { character ->
            binding.characterName.text = character.name
            binding.characterStatus.text = "Status: ${character.status}"
            binding.characterSpecies.text = "Species: ${character.species}"
            binding.characterLocation.text = "Location: ${character.location.name}"

            Glide.with(this)
                .load(character.image)
                .into(binding.characterImage)
        }
    }
}

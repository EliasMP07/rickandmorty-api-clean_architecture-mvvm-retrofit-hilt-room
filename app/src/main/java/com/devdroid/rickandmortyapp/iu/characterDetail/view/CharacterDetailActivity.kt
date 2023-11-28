package com.devdroid.rickandmortyapp.iu.characterDetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.devdroid.rickandmortyapp.R
import com.devdroid.rickandmortyapp.databinding.ActivityCharacterDetailBinding
import com.devdroid.rickandmortyapp.domain.model.CharacterItem
import com.devdroid.rickandmortyapp.iu.characterDetail.viewModel.CharacterDetailViewModel
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterDetailBinding

    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initIU()
        characterDetailViewModel.getCharacter(args.id)
    }

    private fun initIU() {
        initListeners()
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                characterDetailViewModel.state.observe(this@CharacterDetailActivity){
                    when(it){
                        is ResponseStatus.Error -> error(it.message)
                        is ResponseStatus.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is ResponseStatus.Success -> {
                            binding.progressBar.visibility = View.GONE
                            successState(it)
                        }
                    }
                }
            }
        }
    }

    private fun successState(it: ResponseStatus.Success<CharacterItem>) {
        Toast.makeText(this,"${it.data.name}",Toast.LENGTH_SHORT).show()

        Glide.with(this)
            .load(it.data.image)
            .circleCrop()
            .into(binding.imgCharacter)

        binding.apply {
            imgStatusCharacter.background = when (it.data.status) {
                "Alive" -> ContextCompat.getDrawable(applicationContext, R.drawable.ic_live)
                "Dead" -> ContextCompat.getDrawable(applicationContext, R.drawable.ic_dead)
                else -> {
                    ContextCompat.getDrawable(applicationContext, R.drawable.ic_unknown)
                }
            }
            tvSpecieCharacter.text = it.data.species
            tvStatusCharacter.text = it.data.status
            tvGenderCharacter.text = it.data.gender
            imgGenderCharacter.background = when (it.data.gender) {
                "Female" -> ContextCompat.getDrawable(applicationContext, R.drawable.ic_female)
                "Male" -> ContextCompat.getDrawable(applicationContext, R.drawable.ic_male)
                else -> {
                    ContextCompat.getDrawable(applicationContext, R.drawable.ic_gender_unknown)
                }
            }
            tvLocationCharacter.text = it.data.location?.name

            tvOriginCharacter.text = it.data.origin?.name
            tvNameCharacter.text = it.data.name
        }
    }

    private fun initListeners() {
         binding.ivBack.setOnClickListener { onBackPressed() }
    }


}
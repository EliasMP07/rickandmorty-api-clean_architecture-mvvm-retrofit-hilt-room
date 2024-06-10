package com.devdroid.rickandmortyapp.iu.characterFav.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.rickandmortyapp.R
import com.devdroid.rickandmortyapp.databinding.FragmentFavoriteCharacterBinding
import com.devdroid.rickandmortyapp.iu.Character.view.CharacterFragmentDirections
import com.devdroid.rickandmortyapp.iu.Character.view.adapter.CharacterAdapter
import com.devdroid.rickandmortyapp.iu.characterFav.view.adapter.FavoriteCharacterAdapter
import com.devdroid.rickandmortyapp.iu.characterFav.viewModel.FavoriteCharacterViewModel
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteCharacterFragment : Fragment() {


    private var _binding: FragmentFavoriteCharacterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoriteCharacterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentFavoriteCharacterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initIU()
    }

    private fun initIU() {
        initList()
        initIUState()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllFavoriteCharacter()

    }
    private fun initIUState() {

        viewModel.listCharacter.observe(viewLifecycleOwner){
            (binding.rvCharacterFavorite.adapter as FavoriteCharacterAdapter).submitList(it)
        }


        viewModel.stateList.observe(viewLifecycleOwner){
            when(it){
                is ResponseStatus.Error -> error(it.message)
                is ResponseStatus.Loading -> binding.progressBar.visibility = View.VISIBLE
                is ResponseStatus.Success -> binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun initList() {
        binding.rvCharacterFavorite.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = FavoriteCharacterAdapter(onItemSelected = {
                findNavController().navigate(
                    FavoriteCharacterFragmentDirections.actionFavoriteCharacterFragmentToCharacterDetailActivity(it.id!!)
                )
            })
        }

    }

}
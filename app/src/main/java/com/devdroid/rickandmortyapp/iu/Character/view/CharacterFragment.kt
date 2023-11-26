package com.devdroid.rickandmortyapp.iu.Character.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.rickandmortyapp.R
import com.devdroid.rickandmortyapp.databinding.FragmentCharacterBinding
import com.devdroid.rickandmortyapp.iu.Character.view.adapter.CharacterAdapter
import com.devdroid.rickandmortyapp.iu.Character.viewModel.CharacterViewModel
import com.devdroid.rickandmortyapp.iu.utils.ResponseStatus
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val viewModel : CharacterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         initIU()
    }

    private fun initIU() {
        initList()
        initIUState()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllCharacter()

    }
    private fun initIUState() {

        viewModel.listCharacter.observe(viewLifecycleOwner){
            (binding.rvCharacter.adapter as CharacterAdapter).submitList(it)
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


        binding.rvCharacter.apply {

            layoutManager = LinearLayoutManager(requireContext())
            adapter = CharacterAdapter()
        }

    }


}
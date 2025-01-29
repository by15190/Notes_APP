package com.example.notesapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.ui.adapter.noteadapter
import com.example.notesapp.viewmodel.notesviewmodel

class HomeFragment : Fragment(
    R.layout.fragment_home
) {

    lateinit var binding: FragmentHomeBinding
    val viewmodel: notesviewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        /// viewmodel to get all notes
        viewmodel.getallnotes().observe(viewLifecycleOwner, { noteslist ->
            binding.rvAllnotes.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rvAllnotes.adapter = noteadapter(requireContext(), noteslist)

        })

        // add notes button
        binding.addnotesbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createFragment3)
        }

        return binding.root
    }


}
package com.example.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation

import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentCreateBinding
import com.example.notesapp.model.entity
import com.example.notesapp.viewmodel.notesviewmodel

class CreateFragment : Fragment() {

    lateinit var binding: FragmentCreateBinding
    val viewmodel: notesviewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)


        binding.savenotebtn.setOnClickListener {
            createnote(it) /// it is the view or context
        }


        return binding.root
    }

    private fun createnote(it: View?) {
        val title = binding.savenotetitle.text.toString()
        val content = binding.savenotecontent.text.toString()

        val note = entity(null, title, content)
        viewmodel.addnote(note)

        Toast.makeText(context, "Note createc successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createFragment_to_homeFragment)


    }


}
package com.example.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentEditBinding
import com.example.notesapp.model.entity
import com.example.notesapp.viewmodel.notesviewmodel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.getValue

class EditFragment : Fragment(R.layout.fragment_edit) {

    val notes by navArgs<EditFragmentArgs>() // get data from home fragment
    lateinit var binding: FragmentEditBinding
    val viewmodel: notesviewmodel by viewModels() // view model instance
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(layoutInflater, container, false)

        // menu
        setHasOptionsMenu(true)

        // set data to view
        binding.edittitle.setText(notes.data.title)
        binding.editcontent.setText(notes.data.content)

        // save data to database
        binding.editsavenotebtn.setOnClickListener {
            updatenote(it)
        }

        return binding.root
    }

    private fun updatenote(view: View) {

        val title = binding.edittitle.text.toString()
        val content = binding.editcontent.text.toString()

        val data = entity(id = notes.data.id, title = title, content = content)


        viewmodel.updatenotes(data)
        Toast.makeText(context, "note updated successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).navigate(R.id.action_editFragment_to_homeFragment)

    }

    //// show the delete btn
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /// when the delete button is clicked /// get the delete dialog
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(R.layout.delete_dialog)
            bottomSheetDialog.show()

            val bottomsheet_yes = bottomSheetDialog.findViewById<TextView>(R.id.dialog_yes)
            val bottomsheet_no = bottomSheetDialog.findViewById<TextView>(R.id.dialog_no)

            // click the no option
            bottomsheet_no?.setOnClickListener {
                bottomSheetDialog.dismiss() /// dismiss the dialog
            }


            // click the yes option
            bottomsheet_yes?.setOnClickListener {
                val id = notes.data.id /// id of note
                viewmodel.deletenotes(id!!)
                bottomSheetDialog.dismiss() /// dismiss the dialog
                // now go to the home page
                Navigation.findNavController(it).navigate(R.id.action_editFragment_to_homeFragment)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
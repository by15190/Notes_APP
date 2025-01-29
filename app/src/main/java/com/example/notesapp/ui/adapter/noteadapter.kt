package com.example.notesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.model.entity
import com.example.notesapp.ui.fragments.HomeFragment
import com.example.notesapp.ui.fragments.HomeFragmentDirections


class noteadapter(val context: Context, val noteslist: List<entity>) :
    RecyclerView.Adapter<noteadapter.noteviewholder>() {

    override fun onCreateViewHolder(
        // create view holder means create view for rv
        parent: ViewGroup,
        viewType: Int,
    ): noteviewholder {
        val view = ItemNotesBinding.inflate(LayoutInflater.from(context), parent, false)
        return noteviewholder(view)
    }

    override fun onBindViewHolder(
        // bind data with view holder means set data to view
        holder: noteviewholder,
        position: Int,
    ) {
        val data = noteslist[position]
        holder.binding.notetitle.text = data.title.toString()
        holder.binding.notecontent.text = data.content.toString()

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditFragment3(data)
            Navigation.findNavController(it).navigate(action)
        }


    }


    override fun getItemCount(): Int { // get the no of item in rv
        return noteslist.size
    }

    class noteviewholder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
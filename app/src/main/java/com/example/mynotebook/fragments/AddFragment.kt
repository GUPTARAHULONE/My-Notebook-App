package com.example.mynotebook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mynotebook.viewmodel.NoteBookViewModel
import com.example.mynotebook.R
import com.example.mynotebook.model.NoteBook
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: NoteBookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel= ViewModelProvider(this)[NoteBookViewModel::class.java]
        return inflater.inflate(R.layout.fragment_add, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        navController= Navigation.findNavController(view)

        val title=view.findViewById<EditText>(R.id.add_title)
        val desc=view.findViewById<EditText>(R.id.add_desc)

        val button=view.findViewById<FloatingActionButton>(R.id.check_notebook)


        button.setOnClickListener {

            if(title.text.trim().toString().isEmpty()) return@setOnClickListener

            val notebook=NoteBook(title.text.trim().toString(),desc.text.trim().toString())
            saveInDb(notebook)

            navController.navigate(R.id.action_addFragment_to_mainFragment)
        }
    }
    fun saveInDb(noteBook: NoteBook){
        context?.let { viewModel.insert(it,noteBook) }
    }
}
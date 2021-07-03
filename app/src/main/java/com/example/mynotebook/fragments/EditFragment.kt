package com.example.mynotebook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mynotebook.R
import com.example.mynotebook.model.NoteBook
import com.example.mynotebook.viewmodel.NoteBookViewModel


class EditFragment : Fragment() {

    lateinit var navController: NavController

    lateinit var viewModels:NoteBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModels= ViewModelProvider(this)[NoteBookViewModel::class.java]

        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController= Navigation.findNavController(view)
        val notebook:NoteBook= requireArguments().get("note_book") as NoteBook

        val title=view.findViewById<EditText>(R.id.edit_title)
        val desc=view.findViewById<EditText>(R.id.edit_desc)

        title.setText(notebook.title.toString())
        desc.setText(notebook.desc.toString())

        val button=view.findViewById<ImageView>(R.id.save_instance)

        button.setOnClickListener {
            notebook.title = title.text.trim().toString()
            notebook.desc = desc.text.trim().toString()

            updateNoteBook(notebook)
        }

    }

    fun updateNoteBook(noteBook: NoteBook){

        if(noteBook.title.trim().isEmpty()) {
            Toast.makeText(requireContext(),"Title must not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        context?.let { viewModels.insert(it,noteBook) }
        navController.navigate(R.id.action_editFragment_to_mainFragment)
    }


}
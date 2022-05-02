package com.example.sqlroomkotlin.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.sqlroomkotlin.APP
import com.example.sqlroomkotlin.R
import com.example.sqlroomkotlin.databinding.FragmentAddNoteBinding
import com.example.sqlroomkotlin.model.NoteModel

class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.addNote.setOnClickListener {
            if (binding.etAddTitle.text.isNotEmpty()){
                val title = binding.etAddTitle.text.toString()
                if (binding.etAddDesc.text.isNotEmpty()){
                    val description = binding.etAddDesc.text.toString()
                    viewModel.insert(NoteModel(title = title, description = description)){}
                    APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
                }else{
                    Toast.makeText(APP, "Enter a description", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(APP, "Enter a title", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}
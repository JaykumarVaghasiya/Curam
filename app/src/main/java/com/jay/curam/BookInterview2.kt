package com.jay.curam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jay.curam.databinding.DialogSucessBinding


class BookInterview2(private val context: Context) : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_interview2, container, false)
        communicator = activity as Communicator
        val button = view.findViewById<MaterialButton>(R.id.btConfirm)

        button.setOnClickListener {
            showDialog()
        }

        return view
    }
    private fun showDialog() {
        val inflater = LayoutInflater.from(context)
        val dialogBinding = DialogSucessBinding.inflate(inflater)
        val builder = MaterialAlertDialogBuilder(context)
        builder.setView(dialogBinding.root)
        val dialog = builder.create()

        dialogBinding.btGotIT.setOnClickListener {
            communicator.cancel()
            dialog.dismiss()
        }
        dialog.show()
    }
}


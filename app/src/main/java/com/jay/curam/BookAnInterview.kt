package com.jay.curam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton


class BookAnInterview(private val context: Context) : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_an_interview, container, false)
        communicator = activity as Communicator
        val button = view.findViewById<MaterialButton>(R.id.btConfirmandProceed)
        setupButtonListeners(context,view, R.id.decisionLayout, R.id.tvyes1, R.id.tvno1)
        setupButtonListeners(context,view, R.id.decisionLayout1, R.id.tvyes1, R.id.tvno1)
        setupButtonListeners(context,view, R.id.decisionLayout2, R.id.tvyes1, R.id.tvno1)
        setupButtonListeners(context,view, R.id.decisionLayout3, R.id.tvyes1, R.id.tvno1)

        button.setOnClickListener {
            communicator.updateProgressBar(100)
            communicator.navigateToFragment2()

        }
        return view
    }
    private fun setupButtonListeners(
        context: Context,
        view: View,
        includedLayoutId: Int,
        yesButtonId: Int,
        noButtonId: Int
    ) {
        val includedLayout: View = view.findViewById(includedLayoutId)
        val yesButton: MaterialButton = includedLayout.findViewById(yesButtonId)
        val noButton: MaterialButton = includedLayout.findViewById(noButtonId)

        yesButton.setOnClickListener {
            // Change the background color of the buttons for this set
            yesButton.backgroundTintList = getColorStateList(context,R.color.green_200)
            noButton.backgroundTintList = getColorStateList(context,R.color.gray_300)
        }
        noButton.setOnClickListener {
            yesButton.backgroundTintList = getColorStateList(context,R.color.gray_300)
            noButton.backgroundTintList = getColorStateList(context,R.color.green_200)
        }
    }
}
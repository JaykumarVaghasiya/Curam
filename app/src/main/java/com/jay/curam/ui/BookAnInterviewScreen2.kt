package com.jay.curam.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jay.curam.R
import com.jay.curam.databinding.ActivityBookAnInterviewScreen2Binding
import com.jay.curam.databinding.DialogSucessBinding

class BookAnInterviewScreen2 : AppCompatActivity() {
    lateinit var binding: ActivityBookAnInterviewScreen2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBookAnInterviewScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btConfirm.setOnClickListener {
            openConfirmationDialog()
        }
        binding.topAppBar.setNavigationOnClickListener {
        setResult(RESULT_CANCELED)
            finish()
        }
        binding.topAppBar.setOnMenuItemClickListener { menuItem->
            when(menuItem.itemId){
                R.id.cancel ->{
                    setResult(RESULT_CANCELED)
                    finish()
                    true
                }
                else ->false
            }
        }
    }

    private fun openConfirmationDialog() {
        val dialogBinding=DialogSucessBinding.inflate(layoutInflater)
        val builder= MaterialAlertDialogBuilder(this)
        builder.setView(dialogBinding.root)
        val dialog = builder.create()
        dialogBinding.btGotIT.setOnClickListener {
            setResult(RESULT_OK)
            finish()
            dialog.dismiss()
        }
        dialog.show()
    }
}
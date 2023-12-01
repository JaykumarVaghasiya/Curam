package com.jay.curam.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textview.MaterialTextView
import com.jay.curam.R
import com.jay.curam.databinding.ActivityBookAnInterviewBinding

class BookAnInterview : AppCompatActivity() {

    lateinit var binding: ActivityBookAnInterviewBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                finish()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBookAnInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btConfirmandProceed.setOnClickListener {
            val intent=Intent(this,BookAnInterviewScreen2::class.java)
            launcher.launch(intent)
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem->
            when(menuItem.itemId){
            R.id.cancel->{
                finish()
                true
            }
                else->false
            }
        }

    }

}
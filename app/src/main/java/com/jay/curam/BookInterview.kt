package com.jay.curam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jay.curam.databinding.ActivityBookInterviewBinding
import com.jay.curam.databinding.DialogSucessBinding

class BookInterview : AppCompatActivity(),Communicator {

    private lateinit var binding: ActivityBookInterviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBookInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(BookAnInterview(this))

        updateProgressBar(50)

        binding.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.cancel ->{
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun navigateToFragment2() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, BookInterview2(this))
            .addToBackStack(null)
            .commit()
    }

    override fun cancel() {
        finish()
    }

    override fun updateProgressBar(progress: Int) {
        binding.linearProgressIndicator.progress = progress
    }


}
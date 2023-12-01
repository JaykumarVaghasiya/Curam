package com.jay.curam.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.curam.R
import com.jay.curam.adapters.JobsAdapter
import com.jay.curam.databinding.ActivityMainBinding
import com.jay.curam.entity.Jobs

class MainActivity : AppCompatActivity(),JobsAdapter.OnJobListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var jobsAdapter: JobsAdapter
    private val jobsList = listOf(
        Jobs("Hourly ongoing care required in London", "London", 1),
        Jobs("Live-in ongoing care required in Bristol", "Bristol", 2),
        Jobs("Hourly ongoing care required in London", "London", 6),
        Jobs("Overnight ongoing care required in Vauxhall", "London", 4),
        Jobs("Hourly New care required in London", "London", 0),
        Jobs("Hourly ongoing care required in London", "London", 3),
        Jobs("Hourly ongoing care required in London", "London", 2),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvJobs.layoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        jobsAdapter = JobsAdapter(this, jobsList,this)
        binding.rvJobs.adapter = jobsAdapter
        binding.rvJobs.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

//        val headerViewListAdapter=binding.navView.getHeaderView(0)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.tvMenu.setOnClickListener {
                binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        binding.btBookInterview.setOnClickListener {
            val intent=Intent(this,BookAnInterview::class.java)
            startActivity(intent)
        }
    }

    override fun onJobClicked(jobs: Jobs) {
        Toast.makeText(this,jobs.jobName,Toast.LENGTH_SHORT).show()
    }
}
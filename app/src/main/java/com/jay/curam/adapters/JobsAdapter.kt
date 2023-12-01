package com.jay.curam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.jay.curam.R
import com.jay.curam.entity.Jobs


class JobsAdapter(
    private val context: Context,
    private val jobsList: List<Jobs>,
    private val jobOnClickListener: OnJobListener
) :
    RecyclerView.Adapter<JobsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val jobName: MaterialTextView = itemView.findViewById(R.id.tvJobName)
        private val jobLocation: MaterialTextView = itemView.findViewById(R.id.tvJobLocation)
        private val jobDistance: MaterialTextView = itemView.findViewById(R.id.tvJobDistance)
        fun bind(jobs: Jobs) {

            jobName.text = jobs.jobName
            jobDistance.text = "|    Circa:${jobs.jobDistance} Miles"
            jobLocation.text = jobs.jobLocation
            itemView.setOnClickListener {
                jobOnClickListener.onJobClicked(jobs)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jobs_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jobsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobs = jobsList[position]
        holder.bind(jobs)
    }

    interface OnJobListener {
        fun onJobClicked(jobs: Jobs)
    }
}
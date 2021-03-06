package com.mungomash.workouthelper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mungomash.workouthelper.R
import com.mungomash.workouthelper.model.Exercise
import com.mungomash.workouthelper.model.Workout


class SingleWorkoutAdapter(private val context: Context, private val exercises: List<Exercise>): RecyclerView.Adapter<SingleWorkoutAdapter.SingleWorkoutViewHolder>() {

    class SingleWorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.exercise_name)
        val duration: TextView = view.findViewById(R.id.duration_text)
        val rest: TextView = view.findViewById(R.id.rest_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleWorkoutViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_card, parent, false)

        return SingleWorkoutViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SingleWorkoutViewHolder, position: Int) {
        val item = exercises[position]
        holder.title.text = item.name
        holder.duration.text = (item.duration / 1000).toString() + "s"
        holder.rest.text = "Rest: " + (item.prep / 1000).toString() + "s"
    }

    override fun getItemCount() = exercises.size
}
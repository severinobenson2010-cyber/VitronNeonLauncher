package com.vitron.neonlauncher

import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(
    private val apps: List<ResolveInfo>,
    private val pm: PackageManager,
    private val onClick: (ResolveInfo) -> Unit
) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
           .inflate(android.R.layout.simple_list_item_2, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps[position]
        holder.bind(app)
    }

    override fun getItemCount(): Int = apps.size

    inner class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = ImageView(itemView.context)
        private val label: TextView = TextView(itemView.context)

        init {
            itemView.setOnClickListener {
                onClick(apps[adapterPosition])
            }
        }

        fun bind(app: ResolveInfo) {
            label.text = app.loadLabel(pm)
            icon.setImageDrawable(app.loadIcon(pm))
        }
    }
}

package com.example.prsencemanager

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StagiaireAdapter(
    private val context: Context,
    private val stagiaires: List<Stagiaire>,
    private val onPresenceChanged: () -> Unit
) : RecyclerView.Adapter<StagiaireAdapter.StagiaireViewHolder>() {

    class StagiaireViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNom: TextView = itemView.findViewById(R.id.txtNomStagiaire)
        val btnPresent: TextView = itemView.findViewById(R.id.btnPresent)
        val btnAbsent: TextView = itemView.findViewById(R.id.btnAbsent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StagiaireViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_stagiaire_presence, parent, false)
        return StagiaireViewHolder(view)
    }

    override fun onBindViewHolder(holder: StagiaireViewHolder, position: Int) {
        val stagiaire = stagiaires[position]
        holder.txtNom.text = stagiaire.nom

        if (stagiaire.isPresent) {
            // Selected Present
            holder.btnPresent.setBackgroundResource(R.drawable.bg_present_selected)
            holder.btnPresent.setTextColor(Color.parseColor("#16A34A"))

            holder.btnAbsent.setBackgroundResource(R.drawable.bg_toggle_unselected)
            holder.btnAbsent.setTextColor(Color.parseColor("#94A3B8"))
        } else {
            // Selected Absent
            holder.btnPresent.setBackgroundResource(R.drawable.bg_toggle_unselected)
            holder.btnPresent.setTextColor(Color.parseColor("#94A3B8"))

            holder.btnAbsent.setBackgroundResource(R.drawable.bg_absent_selected)
            holder.btnAbsent.setTextColor(Color.parseColor("#DC2626"))
        }

        holder.btnPresent.setOnClickListener {
            stagiaire.isPresent = true
            notifyItemChanged(position)
            onPresenceChanged()
        }

        holder.btnAbsent.setOnClickListener {
            stagiaire.isPresent = false
            notifyItemChanged(position)
            onPresenceChanged()
        }
    }

    override fun getItemCount(): Int = stagiaires.size
}

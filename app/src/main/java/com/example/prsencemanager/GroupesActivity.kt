package com.example.prsencemanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class GroupeItem(val nom: String, val effectif: String)

class GroupesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupes)

        val groupes = listOf(
            GroupeItem("DEV101", "28 Stagiaires — Développement Digital"),
            GroupeItem("DEV102", "30 Stagiaires — Développement Digital"),
            GroupeItem("DEV201", "25 Stagiaires — Option Applications Mobiles"),
            GroupeItem("DEV202", "27 Stagiaires — Option Web Fullstack"),
            GroupeItem("GE101", "32 Stagiaires — Gestion des Entreprises"),
            GroupeItem("ID101", "26 Stagiaires — Infrastructure Digitale")
        )

        val listView = findViewById<ListView>(R.id.listGroupes)

        val adapter = object : BaseAdapter() {
            override fun getCount(): Int = groupes.size
            override fun getItem(position: Int): Any = groupes[position]
            override fun getItemId(position: Int): Long = position.toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = convertView ?: LayoutInflater.from(this@GroupesActivity)
                    .inflate(R.layout.item_groupe, parent, false)

                val groupe = groupes[position]
                val txtNom = view.findViewById<TextView>(R.id.txtNomGroupe)
                val txtInfo = view.findViewById<TextView>(R.id.txtInfoGroupe)

                txtNom.text = groupe.nom
                txtInfo.text = groupe.effectif

                return view
            }
        }

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val groupeSelectionne = groupes[position]
            Toast.makeText(
                this,
                "Groupe ${groupeSelectionne.nom} sélectionné (${groupeSelectionne.effectif})",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

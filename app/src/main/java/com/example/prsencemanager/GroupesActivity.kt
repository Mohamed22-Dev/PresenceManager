package com.example.prsencemanager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
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
            GroupeItem("DEVAM201", "28 Stagiaires — Développement Digital"),
            GroupeItem("DEVAM202", "30 Stagiaires — Option Applications Mobiles"),
            GroupeItem("DEVAM203", "25 Stagiaires — Option Applications Mobiles"),
            GroupeItem("DEVAM204", "27 Stagiaires — Option Web Fullstack"),
            GroupeItem("GE101", "32 Stagiaires — Gestion des Entreprises"),
            GroupeItem("ID101", "26 Stagiaires — Infrastructure Digitale")
        )

        val listView = findViewById<ListView>(R.id.lvGroupes)
        val btnArrayAdapter = findViewById<Button>(R.id.btnArrayAdapter)
        val btnBaseAdapter = findViewById<Button>(R.id.btnBaseAdapter)

        // 1. BaseAdapter personnalisé
        val customBaseAdapter = object : BaseAdapter() {
            override fun getCount(): Int = groupes.size
            override fun getItem(position: Int): Any = groupes[position]
            override fun getItemId(position: Int): Long = position.toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = convertView ?: LayoutInflater.from(this@GroupesActivity)
                    .inflate(R.layout.item_groupe, parent, false)

                val groupe = groupes[position]
                val txtNom = view.findViewById<TextView>(R.id.txtNomGroupe)
                val txtInfo = view.findViewById<TextView>(R.id.txtEffectif)

                txtNom.text = groupe.nom
                txtInfo.text = groupe.effectif

                return view
            }
        }

        // 2. ArrayAdapter simple
        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1,
            groupes.map { "${it.nom}\n${it.effectif}" }
        )

        // Affichage par défaut avec BaseAdapter
        listView.adapter = customBaseAdapter

        // Clic sur le bouton Bleu (ArrayAdapter)
        btnArrayAdapter.setOnClickListener {
            listView.adapter = arrayAdapter
            Toast.makeText(this, "Affichage activé avec : ArrayAdapter", Toast.LENGTH_SHORT).show()
        }

        // Clic sur le bouton Vert (BaseAdapter)
        btnBaseAdapter.setOnClickListener {
            listView.adapter = customBaseAdapter
            Toast.makeText(this, "Affichage activé avec : BaseAdapter", Toast.LENGTH_SHORT).show()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val groupeSelectionne = groupes[position]
            if (groupeSelectionne.nom.contains("202", ignoreCase = true)) {
                startActivity(Intent(this, AppelActivity::class.java))
            } else {
                Toast.makeText(
                    this,
                    "Groupe ${groupeSelectionne.nom} sélectionné (${groupeSelectionne.effectif})",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

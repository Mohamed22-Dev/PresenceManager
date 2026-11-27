package com.example.prsencemanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppelActivity : AppCompatActivity() {

    private lateinit var stagiairesList: List<Stagiaire>
    private lateinit var adapter: StagiaireAdapter
    private lateinit var txtBadgePresents: TextView
    private lateinit var txtBadgeAbsents: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appel)

        // Trainees list from mock-up
        stagiairesList = listOf(
            Stagiaire("ABKHICH ABDELBADIAE", isPresent = true),
            Stagiaire("AFARIATE HANAN", isPresent = true),
            Stagiaire("BELGHMAN ABDELGHAFOUR", isPresent = true),
            Stagiaire("BEN MASSAOUD AHMED ADAM", isPresent = true),
            Stagiaire("BENAZZOUZA ILIAS", isPresent = true),
            Stagiaire("BOUDAHYR ZAKARIA", isPresent = true),
            Stagiaire("BOUHAMIDI FARAH", isPresent = true),
            Stagiaire("EL OTMANI HAFSA", isPresent = true),
            Stagiaire("EL YAAKOUBI AYMEN", isPresent = false),
            Stagiaire("ELFERGANI LAMYAA", isPresent = false),
            Stagiaire("ELHAIRCHE MOHAMED", isPresent = false),
            Stagiaire("ESSADEK HIBATALLAH", isPresent = false),
            Stagiaire("HMIDATE MEHDI", isPresent = false),
            Stagiaire("KHALIL YOUSSEF", isPresent = false),
            Stagiaire("MAHMOUDI OUSSAMA", isPresent = false),
            Stagiaire("ZIANI FATIMA", isPresent = false)
        )

        txtBadgePresents = findViewById(R.id.txtBadgePresents)
        txtBadgeAbsents = findViewById(R.id.txtBadgeAbsents)
        val btnTousPresents = findViewById<TextView>(R.id.btnTousPresents)
        val btnAnnuler = findViewById<Button>(R.id.btnAnnulerAppel)
        val btnValider = findViewById<Button>(R.id.btnValiderAppel)
        val rvStagiaires = findViewById<RecyclerView>(R.id.rvStagiaires)

        rvStagiaires.layoutManager = LinearLayoutManager(this)
        adapter = StagiaireAdapter(this, stagiairesList) {
            updateBadges()
        }
        rvStagiaires.adapter = adapter

        updateBadges()

        // Button Tous présents
        btnTousPresents.setOnClickListener {
            stagiairesList.forEach { it.isPresent = true }
            adapter.notifyDataSetChanged()
            updateBadges()
            Toast.makeText(this, "Tous les stagiaires sont marqués présents", Toast.LENGTH_SHORT).show()
        }

        // Button Annuler
        btnAnnuler.setOnClickListener {
            finish()
        }

        // Button Valider l'appel
        btnValider.setOnClickListener {
            val presentsCount = stagiairesList.count { it.isPresent }
            val absentsCount = stagiairesList.count { !it.isPresent }

            AlertDialog.Builder(this)
                .setTitle("Validation de l'appel")
                .setMessage("Séance 22 · DEVOAM202\n\nPrésents : $presentsCount\nAbsents : $absentsCount")
                .setPositiveButton("OK") { _, _ ->
                    finish()
                }
                .show()
        }
    }

    private fun updateBadges() {
        val presentsCount = stagiairesList.count { it.isPresent }
        val absentsCount = stagiairesList.count { !it.isPresent }

        txtBadgePresents.text = "Présents : $presentsCount"
        txtBadgeAbsents.text = "Absents : $absentsCount"
    }
}

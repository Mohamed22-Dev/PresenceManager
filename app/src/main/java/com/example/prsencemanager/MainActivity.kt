package com.example.prsencemanager

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Étape 3 : Clic simple pour ouvrir DashboardActivity
        val btnCommencer = findViewById<Button>(R.id.btnCommencer)
        btnCommencer.setOnClickListener {
            val intention = Intent(this, DashboardActivity::class.java)
            startActivity(intention)
        }

        // Étape 8 : Clic sur le texte de version footer
        findViewById<TextView>(R.id.txtFooter).setOnClickListener {
            afficherInfosDeveloppeur()
        }
    }

    // Étape 8 : Méthode d'affichage des infos développeur
    private fun afficherInfosDeveloppeur() {
        val dialogue = AlertDialog.Builder(this)
            .setTitle("Informations du développeur")
            .setMessage(
                "Application : PrésenceManager\n" +
                        "Version : 1.0\n" +
                        "Développeur : Mohamed el HAIRCHE\n" +
                        "GitHub : https://github.com/Mohamed22-Dev/PresenceManager"
            )
            .setPositiveButton("OK", null)
            .show()

        dialogue.findViewById<TextView>(android.R.id.message)?.let { texte ->
            Linkify.addLinks(texte, Linkify.WEB_URLS)
            texte.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}
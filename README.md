# PrésenceManager 📱

## 📌 Description
PrésenceManager est une application Android destinée à faciliter la gestion des présences des stagiaires.
Ce projet regroupe les travaux pratiques **TP01**, **TP02** et **TP03** du module M203 (Développement Mobile).

---

## 🎯 Objectifs du TP03 — Gestion des événements
Implémentation et programmation des événements utilisateur en Kotlin :
- **Clic simple (`OnClickListener`)** pour la navigation entre les activités.
- **Appui long (`OnLongClickListener`)** pour afficher des informations d'aide (Toast).
- **Double-clic (`GestureDetector` / `onDoubleTap`)** pour afficher la boîte de dialogue "À propos".
- **Lien hypertexte interactif (`Linkify`)** pour affichage des informations du développeur.

---

## 🛠️ Technologies utilisées
- **Langage** : Kotlin
- **UI** : XML Layouts (ConstraintLayout, GridLayout, LinearLayout)
- **Android SDK** : Intent, GestureDetector, AlertDialog, Linkify, Toast

---

## 📱 Événements et Fonctionnalités

### 1. Navigation (Clic simple)
- **Écran d’accueil (`MainActivity`)** : Clic sur `btnCommencer` → ouvre `DashboardActivity`.
- **Tableau de bord (`DashboardActivity`)** :
  - Clic sur `cardGroupes` → ouvre `GroupesActivity`.
  - Clic sur `cardAppel` → ouvre `AppelActivity`.
  - Clic sur `cardHistorique` → ouvre `HistoriqueActivity`.
  - Clic sur `cardStatistiques` → ouvre `StatistiquesActivity`.

### 2. Appui long (`setOnLongClickListener`)
- **Carte Groupes** : Affiche un Toast `"Groupes : sélectionner ou consulter les groupes"`.
- **Carte Faire l'appel** : Affiche un Toast `"Faire l'appel : démarrer une séance"`.

### 3. Double-clic (`onDoubleTap`)
- Double-clic rapide sur l'image de profil `imgProfil` → Ouvre une boîte de dialogue **AlertDialog** avec le titre *"À propos de PrésenceManager"*.

### 4. Informations du développeur
- Clic sur `"PrésenceManager - Version 1.0"` (écran d'accueil et tableau de bord) → Ouvre une boîte de dialogue avec le nom du développeur et un lien GitHub cliquable.

---

## 📸 Captures d'écran (TP03)

| Tableau de bord | Page de destination (Clic simple) |
| :---: | :---: |
| ![Tableau de bord](screenshots/dashboard.png) | ![Page Destination](screenshots/groupes.png) |

| Dialogue Double-clic (Profil) | Dialogue Développeur (Version 1.0) |
| :---: | :---: |
| ![A propos](screenshots/dialogue_apropos.png) | ![Infos Développeur](screenshots/dialogue_developpeur.png) |

---

## 👨‍💻 Auteur
- **Développeur** : Mohamed el HAIRCHE
- **Version** : 1.0

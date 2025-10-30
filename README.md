# Jeu d’Échecs en Java (Console)

Jeu d’échecs jouable entièrement dans le terminal, développé en Java avec une architecture orientée objet pour gérer l’échiquier, les pièces et la logique du jeu.

## Fonctionnalités

- **Jeu à deux joueurs** : Blanc vs Noir, avec alternance automatique des tours.  
- **Affichage console** : L’échiquier est mis à jour après chaque coup.  
- **Déplacements complets** : Tous les mouvements de pièces sont gérés (Pion, Tour, Cavalier, Fou, Dame, Roi), avec validation des obstacles et règles de déplacement.  
- **Détection d’échec et fin de partie** : La logique fonctionne dans la majorité des cas, mais certaines situations (échec particulier ou pat) ne sont pas encore parfaitement gérées.  
- **Historique des coups** : Liste complète des mouvements joués.

## Utilisation

**Prérequis** : JDK 8 ou supérieur.

**Compilation et exécution** :  
```bash
javac projet_echecs_java/*.java
cd projet_echecs_java
java JeuEchec
```

Suivez les instructions dans la console pour saisir les noms des joueurs et jouer à tour de rôle en entrant les coordonnées des pièces (ex: e2 → e4).
Structure du projet

    JeuEchec.java : Classe principale avec la boucle de jeu.

    Partie.java : Logique globale de la partie, gestion des joueurs et des coups.

    Echiquier.java : Grille 2D représentant l’échiquier et gestion des déplacements.

    Joueur.java : Représentation des joueurs et de leurs pièces.

    Case.java : Une case de l’échiquier (coordonnées et pièce).

    Piece.java (abstraite) et Roi, Dame, Tour, Fou, Cavalier, Pion : Gestion des mouvements spécifiques à chaque pièce.

Auteurs

    Saif-eddine ALJANE

    Ouways VELLORE SHERIEF

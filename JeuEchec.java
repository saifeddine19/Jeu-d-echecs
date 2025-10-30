import java.util.ArrayList;
// Fait par Ouways et Saif-Eddine
public class JeuEchec {
    public static void main(String[] args) {
        // Initialisation de l'échiquier et des joueurs
        Echiquier echiquier = new Echiquier();
        Joueur joueurBlanc = new Joueur();
        Joueur joueurNoir = new Joueur();
        Partie partie = new Partie(joueurBlanc, joueurNoir, echiquier, new ArrayList<>());
        partie.demarrerPartie(); // Placement des pièces et noms des joueurs
    
        Joueur joueurCourant = partie.getJoueurCourant();
    
        // Boucle principale de jeu
        while (true) {
            echiquier.afficheEchiquier();
            partie.afficherCoupJouee();
            System.out.println("liste des piece du Joueur :" + joueurCourant.getCouleurJoueur());
            System.out.println(joueurCourant.afficherPieceJoueur());
            System.out.println("\n Tour de : " + joueurCourant.getNom() + " (" + joueurCourant.getCouleurJoueur() + ")");
    
            // Choix de la pièce à jouer
            Piece pieceChoisie = null;
            while (pieceChoisie == null) {
                pieceChoisie = partie.choixPiece(echiquier, joueurCourant);
                if (pieceChoisie == null) {
                    System.out.println(" Aucune pièce valide choisie. Réessayez.");
                }
            }
    
            // Choix de la case destination
            Case destination = null;
            while (destination == null) {
                destination = echiquier.choixCase();
                if (destination == null) {
                    System.out.println(" Case destination invalide. Réessayez.");
                }
            }
    
            Case caseDepart = pieceChoisie.getCasePiece();
    
            // Vérifie que le déplacement est autorisé
            if (pieceChoisie.deplacement(destination) && partie.coupValide(caseDepart, destination, echiquier)) {
                Case caseRoi = echiquier.getCaseRoi(joueurCourant);
    
                // Vérifie que le roi n'est pas en échec après le coup
                if (!partie.echec(caseRoi, echiquier, joueurCourant)) {
                    echiquier.deplacerPiece(pieceChoisie, destination, partie);
                    partie.enregistrerCoup(caseDepart, destination, joueurCourant);
                    partie.afficherCoupJouee();
    
                    // Si la partie est terminée (échec et mat ou pat), on arrête la boucle
                    if (partie.partieFinie(echiquier)) {
                        System.out.println("Fin de la partie !");
                        break;
                    }
    
                    // Passage au joueur suivant
                    partie.alternerJoueur();
                    joueurCourant = partie.getJoueurCourant();
                } else {
                    System.out.println("Ce coup laisse votre roi en échec !");
                }
            }
        }
    
        // Dernier affichage une fois la boucle terminée
        echiquier.afficheEchiquier();
        partie.afficherCoupJouee();
    } 
}
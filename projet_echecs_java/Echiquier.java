import java.util.ArrayList;
import java.util.Scanner;
// Fait par Saif-Eddine
public class Echiquier {
    private Case[][] plateau ;
    
// Constructeur par defaut initialise le plateau avec ses case 
public Echiquier () {
        this.plateau= new Case[8][8]; // création du plateau 

        String[] lettre = {"a", "b", "c", "d", "e", "f", "g", "h"};

        for (int colonne=0;colonne<8;colonne++){
            for (int ligne=0;ligne<8;ligne++){
                String nomCase=lettre[colonne]+(8 - ligne);
                plateau[ligne][colonne]= new Case(nomCase,ligne,colonne);
                
            }
        }
        
    }

//getter  
public Case[][] getPlateau(){
        return plateau;
    }

//setter
public void setPlateau(Case[][] p){
    this.plateau=p;
}

/*le Joueur saisie une chaine de caractère de format "lettre minuscule"+"chiffre"(ex:"e4") 
et la methode  retourne la case  qui correspond.*/
public Case choixCase(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir la case ou vous voulez vous  deplacer(ex : e4) :\n");
        String caseDepart=scanner.nextLine();

        for(int ligne=0;ligne<8;ligne++){
            for(int colonne=0;colonne<8;colonne++){
                Case caseTester = this.getPlateau()[ligne][colonne];
                
                if((caseTester.getNomCase().equals(caseDepart))){
                
                        return caseTester;
                }
            }
        } 
        
        return null ;
    }
//
public void deplacerPiece(Piece p, Case destination,Partie partie) {
    if(!(p == null)){
        //On recupère la case de depart de la piece
        Case caseDepart=p.getCasePiece();
        // On retire la piece de la case de depart
        caseDepart.setPiece(null);
        
        if(!(destination == null)){
            if(!(destination.estVide())&&!(p.equals(destination.getPiece().getcouleurPiece()))){
                //si la case n'est pas vide on capture la piece
                p.setCasePiece(destination);
                destination.setPiece(p);

            } else {p.setCasePiece(destination);
                    destination.setPiece(p);}

        } System.out.println("la case choisie  existe");
        return;

    } 
    return;
}   
// Affiche l'état actuel de l'échiquier avec les pièces placées
public void afficheEchiquier(){
    System.out.println("Echiquier courant de la partie :");
    
    // Affichage des lettres des colonnes
    System.out.println("  a   b   c   d   e   f   g   h");
    System.out.println(" +---+---+---+---+---+---+---+---+");

    for (int ligne = 0; ligne < 8; ligne++) {
        // Affiche le numéro de la ligne à gauche
        System.out.print((8 - ligne) + "|");

        for (int colonne = 0; colonne < 8; colonne++) {
            // Récupère la pièce sur la case courante
            Piece piece = this.getPlateau()[ligne][colonne].getPiece();
            String symbole;

            // Utilise le symbole de la pièce ou un espace vide
            if (piece != null) {
                symbole = piece.getSymbolePiece();
            } else {
                symbole = " ";
            }

            // Affiche la case avec la pièce ou vide
            System.out.print(" " + symbole + " |");
        }

        // Affiche le numéro de la ligne à droite
        System.out.println(" " + (8 - ligne));
        System.out.println(" +---+---+---+---+---+---+---+---+");
    }

    // Affichage final des lettres des colonnes
    System.out.println("  a   b   c   d   e   f   g   h");
}

// retourne la Case ou se trouve le Roi du joueur passer en paramètre
public Case getCaseRoi(Joueur joueurCourant){
        ArrayList<Piece> listePiece=joueurCourant.getPieceJoueur();
        for(int i=0;i<listePiece.size();i++){
            Piece piece=listePiece.get(i);
            if(piece instanceof Roi){
                return piece.getCasePiece();
            }
        } return null;
        
    }
}
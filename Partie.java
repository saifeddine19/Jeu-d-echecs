import java.util.ArrayList;
import java.util.Scanner;

// Fait par Ouways et Saif-eddine
public class Partie {

    private Joueur joueurBlanc ;
    private Joueur joueurNoir ;
    private Joueur joueurCourant;
    private Echiquier echiquier ;
    private ArrayList<String> coupJouee;

//Constructeur par defaut
public Partie() {
        this.joueurBlanc = new Joueur();
        this.joueurNoir = new Joueur();
        this.echiquier = new Echiquier();
        this.coupJouee = new ArrayList<String>();
        this.joueurCourant=joueurBlanc;//car le Joueur blanc commence

    }

// Constructeur champs à champs
public Partie(Joueur Jb ,Joueur Jn,Echiquier plt ,ArrayList<String> coup ){
        this.joueurBlanc=Jb;
        this.joueurNoir=Jn;
        this.echiquier=plt; 
        this.coupJouee=coup; 
        this.joueurCourant=Jb;
    }

// getter
public Echiquier getEchiquier(){
        return echiquier;
    }

public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }
    
public Joueur getJoueurNoir() {
        return joueurNoir;
    }

public ArrayList<String> getCoupJouee (){
        return coupJouee ;
    }

public Joueur getJoueurCourant(){
        return joueurCourant;
    }

public Joueur getJoueurAdverse(){
        if(this.getJoueurCourant().equals(this.getJoueurBlanc())){
            return this.joueurNoir;
        } else{return this.joueurBlanc;}
    }    
    
    //setter
public void setJoueurBlanc(Joueur joueurBlanc) {
        this.joueurBlanc = joueurBlanc;
    }
    
public void setJoueurNoir(Joueur joueurNoir) {
        this.joueurNoir = joueurNoir;
    }
    
public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }
    
public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }
    
public void setCoupJouee(ArrayList<String> coupJouee) {
        this.coupJouee = coupJouee;
    }
      

// initialise l'echiquier , place les piece , initialise les joueur
public void demarrerPartie(){
        Echiquier plateaujeu=this.getEchiquier();

        //---- Création et placement des Pièce Blanche dans leur case par defaut ----//
        
        // Pions blanc :
        for(int i=0;i<8;i++){
            Case casePlacement = plateaujeu.getPlateau()[6][i];
            Piece piece =new Pion(casePlacement,"blanc",plateaujeu);
            casePlacement.setPiece(piece);
            joueurBlanc.ajouterPiece(piece);
        }

        // Tours blanc :
        Case casePlacementTour1 = plateaujeu.getPlateau()[7][0];
        Case casePlacementTour2 = plateaujeu.getPlateau()[7][7];

        Piece Tour1=new Tour(casePlacementTour1, "blanc",plateaujeu);
        Piece Tour2=new Tour(casePlacementTour2, "blanc",plateaujeu);

        casePlacementTour1.setPiece(Tour1);
        casePlacementTour2.setPiece(Tour2);
        
        joueurBlanc.ajouterPiece(Tour1);
        joueurBlanc.ajouterPiece(Tour2);


        // Cavalier blanc :
        Case casePlacementCavalier1 = plateaujeu.getPlateau()[7][1];
        Case casePlacementCavalier2 = plateaujeu.getPlateau()[7][6];

        Piece Cavalier1 = new Cavalier(casePlacementCavalier1,"blanc",plateaujeu);
        Piece Cavalier2 = new Cavalier(casePlacementCavalier2,"blanc",plateaujeu);

        casePlacementCavalier1.setPiece(Cavalier1);
        casePlacementCavalier2.setPiece(Cavalier2);

        joueurBlanc.ajouterPiece(Cavalier1);
        joueurBlanc.ajouterPiece(Cavalier2);

        // Fou blanc :
        Case casePlacementFou1 = plateaujeu.getPlateau()[7][2];
        Case casePlacementFou2 = plateaujeu.getPlateau()[7][5];

        Piece Fou1 = new Fou(casePlacementFou1,"blanc",plateaujeu);
        Piece Fou2 = new Fou(casePlacementFou2,"blanc",plateaujeu);

        casePlacementFou1.setPiece(Fou1);
        casePlacementFou2.setPiece(Fou2);

        joueurBlanc.ajouterPiece(Fou1);
        joueurBlanc.ajouterPiece(Fou2);

        // Dame blanche :
        Case casePlacementDame = plateaujeu.getPlateau()[7][3];

        Piece Dame = new Dame(casePlacementDame,"blanc",plateaujeu);

        casePlacementDame.setPiece(Dame);

        joueurBlanc.ajouterPiece(Dame);

        // Roi blanc :
        Case casePlacementRoi = plateaujeu.getPlateau()[7][4];

        Piece Roi = new Roi(casePlacementRoi,"blanc",plateaujeu);

        casePlacementRoi.setPiece(Roi);

        joueurBlanc.ajouterPiece(Roi);


        //---- Création et placement des Pièce Noir dans leur case par defaut ----//
        
        // Pions noir :
        for(int i=0;i<8;i++){
            Case casePlacement = plateaujeu.getPlateau()[1][i];
            Piece PionN = new Pion(casePlacement,"noir",plateaujeu);
            casePlacement.setPiece(PionN);
            joueurNoir.ajouterPiece(PionN);
            
        }

        // Tours noir :
        Case casePlacementTour1Noir = plateaujeu.getPlateau()[0][0];
        Case casePlacementTour2Noir = plateaujeu.getPlateau()[0][7];

        Piece Tour1Noir = new Tour(casePlacementTour1Noir, "noir",plateaujeu);
        Piece Tour2Noir = new Tour(casePlacementTour2Noir, "noir",plateaujeu);
        
        casePlacementTour1Noir.setPiece(Tour1Noir);
        casePlacementTour2Noir.setPiece(Tour2Noir);

        joueurNoir.ajouterPiece(Tour1Noir);
        joueurNoir.ajouterPiece(Tour2Noir);

        // Cavalier noir :
        Case casePlacementCavalier1Noir = plateaujeu.getPlateau()[0][1];
        Case casePlacementCavalier2Noir = plateaujeu.getPlateau()[0][6];

        Piece Cavalier1N = new Cavalier(casePlacementCavalier1Noir,"noir",plateaujeu);
        Piece Cavalier2N = new Cavalier(casePlacementCavalier2Noir,"noir",plateaujeu);
        
        casePlacementCavalier1Noir.setPiece(Cavalier1N);
        casePlacementCavalier2Noir.setPiece(Cavalier2N);

        joueurNoir.ajouterPiece(Cavalier1N);
        joueurNoir.ajouterPiece(Cavalier2N);

        // Fou noir :
        Case casePlacementFou1Noir = plateaujeu.getPlateau()[0][2];
        Case casePlacementFou2Noir = plateaujeu.getPlateau()[0][5];

        Piece Fou1N = new Fou(casePlacementFou1Noir,"noir",plateaujeu);
        Piece Fou2N = new Fou(casePlacementFou2Noir,"noir",plateaujeu);

        casePlacementFou1Noir.setPiece(Fou1N);
        casePlacementFou2Noir.setPiece(Fou2N);

        joueurNoir.ajouterPiece(Fou1N);
        joueurNoir.ajouterPiece(Fou2N);

        // Dame noir :
        Case casePlacementDameNoir = plateaujeu.getPlateau()[0][3];

        Piece DameN = new Dame(casePlacementDameNoir,"noir",plateaujeu);

        casePlacementDameNoir.setPiece(DameN);

        joueurNoir.ajouterPiece(DameN);

        // Roi noir :
        Case casePlacementRoiNoir = plateaujeu.getPlateau()[0][4];

        Piece RoiN =new Roi(casePlacementRoiNoir,"noir",plateaujeu);

        casePlacementRoiNoir.setPiece(RoiN);

        joueurNoir.ajouterPiece(RoiN);

        //---- Initialisation des joueurs ----//

        Scanner scanner = new Scanner(System.in);

        System.out.println("Joueur blanc saisisez votre nom :\n");
        String nomSasieJoueurBlanc= scanner.nextLine();
        this.getJoueurBlanc().setNom(nomSasieJoueurBlanc);
        this.getJoueurBlanc().setcouleurJoueur("blanc");
        

        System.out.println("Joueur Noir saisisez votre nom :\n");
        String nomSasieJoueurNoir= scanner.nextLine();
        this.getJoueurNoir().setNom(nomSasieJoueurNoir);
        this.getJoueurNoir().setcouleurJoueur("noir");
        
    }

// verifie si lors du deplacement d'une il y a un obstacle sur le chemin
public boolean coupValide(Case caseDepart, Case caseArrivee, Echiquier plateau) {
        Piece pieceDeplacee = caseDepart.getPiece();
    
        // Le cavalier et le pion gèrent leurs propres collisions, on suppose le déplacement valide
        if (pieceDeplacee instanceof Cavalier || pieceDeplacee instanceof Pion) {
            return true;
        }
    
        if (pieceDeplacee.deplacement(caseArrivee)) {
            int ligneDepart = caseDepart.getLignes();
            int colonneDepart = caseDepart.getColonnes();
            int ligneArrivee = caseArrivee.getLignes();
            int colonneArrivee = caseArrivee.getColonnes();
    
             // Compare les colonnes, renvoie 1 si arrivee > depart, -1 si <, 0 si égal
            int directionLigne = Integer.compare(ligneArrivee, ligneDepart); 
            int directionColonne = Integer.compare(colonneArrivee, colonneDepart); 
    
            int ligne = ligneDepart + directionLigne;
            int colonne = colonneDepart + directionColonne;
    
            // Tant qu'on n'a pas atteint la case d'arrivée
            while (ligne != ligneArrivee || colonne != colonneArrivee) {
                Case caseAverifier = plateau.getPlateau()[ligne][colonne];
    
                if (!caseAverifier.estVide()) {
                    return false; // obstacle trouvé
                }
    
                ligne += directionLigne;
                colonne += directionColonne;
            }
    
            return true; // chemin libre
        }
    
        return false; // déplacement interdit
    }
     
// Verifie si le Roi du joueur passer en paramètre
public boolean echec(Case caseRoi, Echiquier echiquier,Joueur joueurCourant) {
    Piece roi = echiquier.getCaseRoi(joueurCourant).getPiece();
    String couleurRoi = roi.getcouleurPiece();

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            // On parcours chaque de l'echequier
            Case caseRetourne = echiquier.getPlateau()[i][j];
            // Si la caseretournée n'est pas vide
            if (!(caseRetourne.estVide())) {
                // on verifie que la piece a une couleur differente du roi et que le deplacement est valide
                Piece piece = caseRetourne.getPiece();
                if (!piece.getcouleurPiece().equals(couleurRoi)) {
                    if (piece.deplacement(caseRoi) && this.coupValide(caseRetourne, caseRoi, echiquier)) {
                        return true;
                    }
                }
            }
        }
    } return false ; }

/* Verifie si le roi du Joueur passé en paramètre est en situation de pat
(le roi n'est pas en echec mais il ne lu reste aucun coup legale)
   */ 
public boolean pat(Case caseRoi, Joueur joueurCourant, Echiquier echiquier) {
    String couleurRoi=caseRoi.getPiece().getcouleurPiece();
    String couleurJoueur=joueurCourant.getCouleurJoueur();
    if(couleurJoueur.equals(couleurRoi)){

        // Si le roi est en echec il n'y a pas de situation de pat    
        if (this.echec(caseRoi, echiquier,joueurCourant) ) {
                return false;
        }
        // liste des piece du joueur
        ArrayList<Piece> listePieces = joueurCourant.getPieceJoueur();
        for (int index = 0; index < listePieces.size(); index++) {
            Piece piece = listePieces.get(index);
            Case casePiece = piece.getCasePiece();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Case caseArrivee = echiquier.getPlateau()[i][j];
                    if (piece.deplacement(caseArrivee)) {
                        if (coupValide(casePiece, caseArrivee, echiquier)) {
                            return false;
                        }
                    }
                }
            }
        }return true;

    } return false;
}

// enregitre une chaine de caractère qui permet de voir les anciens coups (e2 --> e4) 
public void enregistrerCoup(Case caseDepart,Case caseArrivee ,Joueur joueurCourant){
        String nomCaseDepart = caseDepart.getNomCase();
        String nomCaseArrivee= caseArrivee.getNomCase();
        String nomJoueur=joueurCourant.getNom();
        String couleurJoueur=joueurCourant.getCouleurJoueur();

        ArrayList<String> listeCoup=this.getCoupJouee();

        String coup = nomJoueur+"("+couleurJoueur+")"+" : "+nomCaseDepart+" --> "+nomCaseArrivee ;

        listeCoup.add(coup);
    }

// affiche les coups enregistrer
public String afficherCoupJouee(){
        ArrayList<String> listeCoup=this.getCoupJouee();
        String coupJouer ="Liste des coup joués :\n";
        
        for(int i=0;i<listeCoup.size();i++){
            // on fait +1 pour commencer a 1
            coupJouer +=(i+1) +". "+ listeCoup.get(i)+"\n";
        }

        return coupJouer ;
    } 

/*le Joueur saisie une chaine de caractère de format "lettre minuscule"+"chiffre"(ex:"e4") 
et la methode  retourne la piece qui correspond.*/
public Piece choixPiece(Echiquier echiquier,Joueur joueurCourant){
        String couleurJoueur=joueurCourant.getCouleurJoueur();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir la case de la pièce que vous voulez deplacer(ex : e4) :\n");
        String caseDepart=scanner.nextLine();

        for(int ligne=0;ligne<8;ligne++){
            for(int colonne=0;colonne<8;colonne++){
                Case caseTester = echiquier.getPlateau()[ligne][colonne];
                Piece pieceTester=caseTester.getPiece();
                if((caseTester.getNomCase().equals(caseDepart))){
                
                        return pieceTester;
                }
            }
        } 
        
        return null ;
 
}

/*Permet de voir si la partie est fini ou non elle détecte l'echec et mat ou le pat.
 (Methode qui ne fonctionne pas voir pdf)*/
public boolean partieFinie(Echiquier echiquier) {
    Joueur joueurAdverse = this.getJoueurAdverse();
    Case caseRoi = echiquier.getCaseRoi(joueurAdverse);

    ArrayList<Piece> piecesAdverses = joueurAdverse.getPieceJoueur();
    for (int i = 0; i < piecesAdverses.size(); i++) {
        Piece piece = piecesAdverses.get(i);
        Case caseDepart = piece.getCasePiece();

        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                Case caseArrivee = echiquier.getPlateau()[ligne][colonne];

                if (piece.deplacement(caseArrivee) && coupValide(caseDepart, caseArrivee, echiquier)) {
                    // Simule le déplacement
                    Piece pieceCapturee = caseArrivee.getPiece();
                    caseDepart.setPiece(null);
                    caseArrivee.setPiece(piece);
                    piece.setCasePiece(caseArrivee);

                    boolean roiEnEchec = echec(caseRoi, echiquier, joueurAdverse);

                    // Annule le déplacement
                    caseArrivee.setPiece(pieceCapturee);
                    caseDepart.setPiece(piece);
                    piece.setCasePiece(caseDepart);

                    if (!roiEnEchec) {
                        return false; // Le joueur adverse peut encore jouer
                    }
                }
            }
        }
    }

    // Aucun coup ne permet d’échapper à l’échec => échec et mat ou pat
    if (echec(caseRoi, echiquier, joueurAdverse)) {
        System.out.println("Échec et mat !");
    } else {
        System.out.println("Pat !");
    }
    return true;
}

/*Permet d'alterner entre le joueur blanc et noir */
public void alternerJoueur() {
    if (joueurCourant.equals(joueurBlanc)) {
        joueurCourant = joueurNoir;
    } else {
        joueurCourant = joueurBlanc;
    }
}
}
    



        

        
        
            


 
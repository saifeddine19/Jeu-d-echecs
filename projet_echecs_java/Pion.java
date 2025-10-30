// Fait par Saif-Eddine et ouways
public class Pion extends Piece {
    
    public Pion(){
        super();
    } 
    
    public Pion(Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    public boolean deplacement(Case caseArriver) {
        // le joueur ne peut pas se deplacer sur la case ou il se trouve au depart
        if(caseArriver.equals(this.getCasePiece())){
            return false ;
        }
        
        // On récupère les cordonnées 
        int ligneDepart = this.getCasePiece().getLignes();
        int colonneDepart = this.getCasePiece().getColonnes();

        int ligneArrivee = caseArriver.getLignes();
        int colonneArrivee = caseArriver.getColonnes();

        // Calcule de la distance entre la case d'arriver et de depart
        int distanceLigne= ligneArrivee-ligneDepart ;

        // Si le pion est blanc
        if(this.getcouleurPiece().equals("blanc")){
            /*Les blanc se déplace vers le haut du plateau tout en se situant vers le bas du plateau ,
            d'ou le -1 ou le -2 */
            
            // Vérifie si les déplacement qui sont seulement de 1 case sont possible
            if(colonneDepart == colonneArrivee && distanceLigne == -1 && caseArriver.estVide()) {
                return true;
            }

            /* Vérifie si le cas particulier de deplacement de 2 case sont possible , true 
            si le pion se trouve sur la ligne 6 du plateau (equivaut a la ligne 7 de l'echequier) */
            if((colonneDepart == colonneArrivee) && (ligneDepart == 6) && (distanceLigne == -2)){
                // Vérification qu'in n'y a aucune piece sur le chemin
                Echiquier plateau=this.getEchiquierPiece();
                Case caseMilieu = plateau.getPlateau()[ligneDepart - 1][colonneDepart];
            if(caseMilieu.estVide() && caseArriver.estVide()){
                return true;
            }
            } 

            // deplacement en diagonale :
            if (!caseArriver.estVide()){
            // on récupère la couleur de la piece dans une variable pour plus visibilité
            String couleurPiece=caseArriver.getPiece().getcouleurPiece();
                
            // calcule des distance entre les coordonée de la case de depart et d'arriver
            int distanceColonne = Math.abs(colonneArrivee-colonneDepart);
            
            /*Vérifie si il est possible de se déplacer vers l'avant en diagonale 
            (lorsque la case n'est pas vide et que la piece se trouvant sur la case est de couleur noir )*/
            
            if (!caseArriver.estVide() &&
                couleurPiece.equals("noir") &&
                distanceColonne == 1 &&
                distanceLigne == -1)  {return true;}  
            } 
        }
        // Si le pion est noir
        else {
            /* Ici ,les noir se déplace vers le bas  du plateau tout en se situant vers le haut du plateau ,
            d'ou le 1 ou le 2 */ 

            // Vérifie si les déplacement qui sont seulement de 1 case sont possible
            if(colonneDepart == colonneArrivee && ligneArrivee-ligneDepart == 1 && caseArriver.estVide()) {
                return true;
            }

             /* Vérifie si le cas particulier de deplacement de 2 case sont possible , 
             true si le pion se trouve sur la ligne 1 du plateau (equivaut a la ligne 2 de l'echequier) */
             if((colonneDepart == colonneArrivee) && (ligneDepart == 1) && (ligneArrivee-ligneDepart == 2)){
                // Vérification qu'in n'y a aucune piece sur le chemin
                Echiquier plateau=this.getEchiquierPiece();
                Case caseMilieu = plateau.getPlateau()[ligneDepart + 1][colonneDepart];
                if(caseMilieu.estVide() && caseArriver.estVide()){
                    return true;
            }
            } 

            // deplacement en diagonale :
            if (!caseArriver.estVide()){
            // on récupère la couleur de la piece dans une variable pour plus visibilité
            String couleurPiece=caseArriver.getPiece().getcouleurPiece();
                
            // calcule des distance entre les coordonée de la case de depart et d'arriver
            int distanceColonne = Math.abs(colonneArrivee-colonneDepart);
            
            /*Vérifie si il est possible de se déplacer vers l'avant en diagonale 
            (lorsque la case n'est pas vide et que la piece se trouvant sur la case est de couleur noir )*/
            
            if (!caseArriver.estVide() &&
                couleurPiece.equals("blanc") &&
                distanceColonne == 1 &&
                distanceLigne == 1)  {return true;}

            }
    }
    return false;
} 

public String getSymbolePiece(){
    String couleurPiece = this.getcouleurPiece();
    String symbole="";

    if(couleurPiece.equals("blanc")){
        symbole = "P";
    } else {symbole="p";}

    return symbole;
}
}

 

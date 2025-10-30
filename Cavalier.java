// Fait par Saif-eddine
public class Cavalier extends Piece {
    public Cavalier (){
        super();
    }

    public Cavalier (Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    public boolean deplacement(Case caseArriver) {
        
        // le joueur ne peut pas se deplacer sur la case ou il se trouve au depart
        if(caseArriver.equals(this.getCasePiece())){
            return false ;
        }
        
        // coordonnées de la case de depart
        int ligneDepart=this.getCasePiece().getLignes();
        int colonneDepart=this.getCasePiece().getColonnes();

        // coordonnées de la case d'arriver
        int ligneArriver=caseArriver.getLignes();
        int colonneArriver=caseArriver.getColonnes();
        
        // Calcule la distance entre la case de départ et la case d'arrivée

        int distanceLigne= Math.abs(ligneArriver-ligneDepart);
        int distanceColonne=Math.abs(colonneArriver-colonneDepart);

        //Vérifie que l'on se déplace d'une ligne et de deux colonnes ou de deux lignes et d'une colonne 
        if((distanceLigne == 1 && distanceColonne == 2) || (distanceLigne == 2 && distanceColonne == 1)){
            return true;
        } else { return false ;}
    }

    public String getSymbolePiece(){
        String couleurPiece = this.getcouleurPiece();
        String symbole="";

        if(couleurPiece.equals("blanc")){
            symbole = "C";
        } else {symbole="c";}

        return symbole;

    }

}

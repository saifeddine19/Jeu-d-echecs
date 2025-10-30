// Fait par Saif-Eddine 
public class Roi extends Piece {
    
    public Roi(){
        super();
    }

    public Roi(Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    public boolean deplacement(Case caseArriver){
        
        // le joueur ne peut pas se deplacer sur la case ou il se trouve au depart
        if(caseArriver.equals(this.getCasePiece())){
            return false ;
        }
        int ligneArriver = caseArriver.getLignes();
        int colonneArriver = caseArriver.getColonnes();

        int ligneDepart = this.getCasePiece().getLignes();
        int colonneDepart = this.getCasePiece().getColonnes();

        int distanceColonne = Math.abs(colonneArriver-colonneDepart);
        int distanceLigne = Math.abs(ligneArriver-ligneDepart);

        if (distanceColonne <= 1 && distanceLigne <= 1)
        {return true;
        } else {return false;}
    }

    public String getSymbolePiece(){
        String couleurPiece = this.getcouleurPiece();
        String symbole="";

        if(couleurPiece.equals("blanc")){
            symbole = "R";
        } else {symbole="r";}

        return symbole;
    }
}

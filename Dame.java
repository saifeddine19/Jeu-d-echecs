// Fait par Saif-eddine
public class Dame extends Piece {
    public Dame (){
        super();
    }

    public Dame (Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    public boolean deplacement(Case caseArriver) {
        // le joueur ne peut pas se deplacer sur la case ou il se trouve au depart
        if(caseArriver.equals(this.getCasePiece())){
            return false ;
        }

        int ligneDepart=this.getCasePiece().getLignes();
        int colonneDepart=this.getCasePiece().getColonnes();

        int ligneArriver=caseArriver.getLignes();
        int colonneArriver=caseArriver.getColonnes();

        int distanceLigne=Math.abs(ligneArriver-ligneDepart);
        int distanceColonne=Math.abs(colonneArriver-colonneDepart);

        if(distanceColonne == distanceLigne || 
           colonneArriver == colonneDepart ||
           ligneArriver == ligneDepart ){
            return true;
        } else {return false;}
    }

    public String getSymbolePiece(){
        String couleurPiece = this.getcouleurPiece();
        String symbole="";

        if(couleurPiece.equals("blanc")){
            symbole = "D";
        } else {symbole="d";}

        return symbole;
    }
}
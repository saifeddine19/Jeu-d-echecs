public class Tour extends Piece {

    public Tour(Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    @Override
    public boolean deplacement(Case deplacement) {
        int ligneDepart = this.getCasePiece().getLignes();
        int colonneDepart = this.getCasePiece().getColonnes();

        int ligneArrivee = deplacement.getLignes();
        int colonneArrivee = deplacement.getColonnes();

        // Vérifie que le déplacement est vertical ou horizontal
        if (ligneDepart != ligneArrivee && colonneDepart != colonneArrivee) {
            return false; // le déplacement n'est ni vertical ni horizontal
        }

        // Vérifie la case d'arrivée
        if (deplacement.estVide()) {
            return true;
        } else {
            Piece pieceArrivee = deplacement.getPiece();
            return !pieceArrivee.getcouleurPiece().equals(this.getcouleurPiece());
        }
    }

    public String getSymbolePiece(){
        String couleurPiece = this.getcouleurPiece();
        String symbole="";

        if(couleurPiece.equals("blanc")){
            symbole = "T";
        } else {symbole="t";}

        return symbole;
    }
}

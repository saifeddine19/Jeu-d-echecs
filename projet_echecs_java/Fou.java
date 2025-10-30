//Fait par Ouways
public class Fou extends Piece {
	public Fou(){
		super(); }
	
    public Fou(Case casePiece, String couleurPiece,Echiquier plateau) {
        super(casePiece, couleurPiece,plateau);
    }

    
    public boolean deplacement(Case caseArriver) {
        // le joueur ne peut pas se deplacer sur la case ou il se trouve au depart
        if(caseArriver.equals(this.getCasePiece())){
            return false ;
        }
        int ligneDepart = this.getCasePiece().getLignes();
        int colonneDepart = this.getCasePiece().getColonnes();

        int ligneArrivee = caseArriver.getLignes();
        int colonneArrivee = caseArriver.getColonnes();

        // Vérifie que le déplacement est diagonal
        if (Math.abs(ligneArrivee - ligneDepart) != Math.abs(colonneArrivee - colonneDepart)) {
            return false;
        } else {return true;}

        

        
    }

    public String getSymbolePiece(){
        String couleurPiece = this.getcouleurPiece();
        String symbole="";

        if(couleurPiece.equals("blanc")){
            symbole = "F";
        } else {symbole="f";}

        return symbole;
    }
}
    

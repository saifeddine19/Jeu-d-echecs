// Fait par Ouways
public abstract class Piece {
    private Case CasePiece;
    private String couleurPiece;
    private Echiquier echiquier ;

    public Piece(){

    }

    public Piece(Case CasePiece, String couleurPiece,Echiquier plateau) {
        this.CasePiece = CasePiece;
        this.couleurPiece = couleurPiece;
        this.echiquier=plateau;
    }
    // getter 
    public Case getCasePiece() {
        return CasePiece;
    }

    public Echiquier getEchiquierPiece(){
        return echiquier;
    }

    public void setCasePiece(Case CasePiece) {
        this.CasePiece = CasePiece;
    }

    public String getcouleurPiece() {
        return couleurPiece;
    }

    public void setcouleurPiece(String couleurPiece) {
        this.couleurPiece = couleurPiece;
    }

    public void setEchequierPiece(Echiquier plateau){
        this.echiquier=plateau ;
    }

    // Permet de verifier si le deplacement d'une piece est légal
    public abstract boolean deplacement(Case caseArriver) ;

    //Methode abstraite qui permet de retourner un symbole qui identifie la piece
    // Si Roi noir la methode retourne "r", sinon "R"
    public abstract String getSymbolePiece();

    // Redefinition equals
    public boolean equals(Object o){
        if(o==null) return false ;
        if (this.getClass() != o.getClass()) return false;

        return this.couleurPiece.equals( ((Piece) o).couleurPiece )&& this.CasePiece ==((Piece)o).CasePiece 
               && this.echiquier == ((Piece) o).echiquier ;
    }
    
}
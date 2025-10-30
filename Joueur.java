import java.util.ArrayList;
// Fait par Ouways
public class Joueur {
    private String nom;
    private String couleurJoueur;
    private ArrayList<Piece> pieceJoueur;

    public Joueur(){
        this.pieceJoueur = new ArrayList<Piece>();

    }

    public Joueur(String nom,ArrayList<Piece> pieceJoueur,String couleur) {
        this.nom = nom;
        this.pieceJoueur = pieceJoueur;
        this.couleurJoueur=couleur;
    }

    public  String getNom(){
        return nom;
    }

    public String getCouleurJoueur(){
        return couleurJoueur;
    }

    public ArrayList<Piece> getPieceJoueur() {
        return pieceJoueur;

    }

    public void setNom(String nom) {
        this.nom = nom;

    }

    public void setpieceJoueur(ArrayList<Piece> pieceJoueur) {
        this.pieceJoueur = pieceJoueur;
    }

    public void setcouleurJoueur(String str){
        this.couleurJoueur=str;
    }

    public void ajouterPiece(Piece piece){
        this.pieceJoueur.add(piece);
    }
    //Permet de donner l'index d'une Piece se rouvant dans une list
    public int getindexPiece (Piece pieceCible){
        ArrayList<Piece> liste = this.getPieceJoueur();
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).equals(pieceCible)){
                return i;
            }
        } return -1 ;

    }
    // affiche les piece du Joueur
    public String afficherPieceJoueur() {
        ArrayList<Piece> listJoueur=this.getPieceJoueur();
        String chaineRetourner="";
        for(int i=0;i<listJoueur.size();i++){
            Piece piece=listJoueur.get(i);
            String symbolePiece = piece.getSymbolePiece();
            chaineRetourner += symbolePiece+" | ";
        } return chaineRetourner;
    }

    //Redéfinition d'equals
    public boolean equals(Object obj) {
        if (this == obj) return true; // mêmes références
        if (obj == null || getClass() != obj.getClass()) return false;
    
        Joueur autre = (Joueur) obj;
    
        
        return this.nom != null && this.nom.equals(autre.nom)
            && this.couleurJoueur != null && this.couleurJoueur.equals(autre.couleurJoueur);
    }

    
}
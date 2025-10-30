// Fait par Saif-eddine
public class Case {
    private String nomCase ;
    private int lignes ;
    private int colonnes ;
    private Piece piece ;

    // Constructeur champs à champs
    public Case(String nom,int ligne,int colonne){
        this.nomCase=nom;
        this.lignes=ligne;
        this.colonnes=colonne;
    }

    // getter :
    public String getNomCase(){
        return nomCase ;
    }

    public int getLignes(){
        return lignes;
    }

    public int getColonnes(){
        return colonnes;
    }

    public Piece getPiece(){
        return piece ;
    }
    // fin getter

    // setter :
    public void setNomCase(String nvNom){
        this.nomCase=nvNom;
    }

    public void setLignes(int nvLigne){
        this.lignes=nvLigne;
    }

    public void setPiece(Piece nvPiece){
        this.piece=nvPiece;
    }
    // fin setter

    /*Methode qui permet de vérifier si une case est ocupée par
    une piéce ou non . Elle retourne un booleen .*/ 
    public boolean estVide() {
        return this.piece == null;
    }
}
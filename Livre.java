public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;


    // Constructeurs sans et avec paramètres
    public Livre(){

    }

    public Livre(String titre, String auteur, int anneePublication, String ISBN){
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }

    // Getteurs 
    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public int getAnneePublication(){
        return this.anneePublication;
    }

    public String getISBN(){
        return this.ISBN;
    }
    /*  Setteurs */
    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnneePublication(int anneePublication){
        this.anneePublication = anneePublication;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    // Methode toString() pour afficher les détails du livre
    public String toString(){
        return "---- Détails du livre ----\n" +
               "titre                : " + this.titre + "\n" +
               "auteur               : " + this.auteur + "\n" +
               "année de publication : " + this.anneePublication + "\n" +
               "ISBN                 : " + this.ISBN;
    }
}

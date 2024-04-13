import java.util.ArrayList;
public class Utilisateur {
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private boolean cotisation = false;


    // Constructeurs sans et avec paramètres pour initialiser les attributs
    public Utilisateur(){}

    public Utilisateur(String nom, int numeroIdentification, ArrayList<Livre> livresEmpruntes, boolean cotisation){
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = livresEmpruntes;
        this.cotisation = cotisation;

    }

    // Methode pour afficher les livres empruntés de l'utilisateur
    public void afficherLivresEmpruntes(){
        System.out.println("Voici la liste des livres empruntés : ");
        for (Livre livre : this.livresEmpruntes) {
            System.out.println("Titre : " + livre.getTitre() + "\n" +
            "Auteur : " + livre.getAuteur() + "\n" +
            "Année de publication : " + livre.getAnneePublication() + "\n" +
            "ISBN : " + livre.getISBN() + "\n-------------\n");
        }
    }
    // Getteurs
    public String getNom(){
        return this.nom;
    }

    public int getNumeroIdentification(){
        return this.numeroIdentification;
    }

    public ArrayList<Livre> getLivresEmpruntes(){
        return this.livresEmpruntes;
    }

    public boolean getCotisation(){
        return this.cotisation;
    }
    // setteurs
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setNumeroIdentification(int numeroIdentification){
        this.numeroIdentification = numeroIdentification;
    }

    public void setLivresEmpruntes(Livre livre){
        livresEmpruntes.add(livre);
    }

    public void setCotisiation(boolean cotisation){
        this.cotisation = cotisation;
    }

    // Methode toString() pour afficher les détails de l'utilisateur
    public String toString(){
        return "---- Informations de l'utilisateur ----\n" +
               "Nom                     : " + this.nom + "\n" +
               "Numéro d'identification : " + this.numeroIdentification + "\n" +
               "Nombre livres empruntés : " + this.livresEmpruntes.size() + "\n" +
               "Cotisation à jour       : " + this.cotisation;
    }


      
}

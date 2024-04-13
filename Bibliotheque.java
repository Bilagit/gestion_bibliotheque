import java.util.HashMap;
import java.util.ArrayList;


public class Bibliotheque {
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;
    private ArrayList<Utilisateur> listeUtilisateurs;

    // Constructeurs sans et avec paramètres pour initialiser les attributs
    public Bibliotheque(){
    }

    public Bibliotheque(ArrayList<Livre> listeLivres, HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs){
        this.listeLivres = listeLivres;

        this.empruntsUtilisateurs = empruntsUtilisateurs;
        listeUtilisateurs = new ArrayList<>();
    }

    // Getteurs
    public ArrayList<Livre> getListeLivres(){
        return this.listeLivres;
    }

    public HashMap<Utilisateur, ArrayList<Livre>> getEmpruntsUtilisateurs(){
        return this.empruntsUtilisateurs;
    }

    //Setteurs

    public void setListeLivres(ArrayList<Livre> listLivres){
        this.listeLivres = listLivres;
    }

    public void setEmpruntsUtilisateurs(ArrayList<Livre> livresEmpruntes, Utilisateur utilisateur){
        this.empruntsUtilisateurs.put(utilisateur, livresEmpruntes);
    }

    // Methode pour ajouter un Livre

    public void ajouterLivre(Livre livre){
        this.listeLivres.add(livre);
    }

    // Methode pour supprimer un livre

    public void supprimerLivre(Livre livre){
        this.listeLivres.remove(livre);
    }

    // Méthode pour rechercher un livre avec le titre

    public void rechercherParTitre(String titre){
        boolean resultat = false;
        for (Livre livre : this.listeLivres) {
            String titretmp = livre.getTitre();
            if (titretmp.equals(titre)) {
                System.out.println("--- Livre trouvé ---\n " +
                "Titre : " + titretmp + "\n" +
                "Auteur : " + livre.getAuteur() + "\n" +
                "Année de publication : " + livre.getAnneePublication() + "\n" +
                "ISBN : " + livre.getISBN());
                resultat = true;
                break;
            }
        }
        if(!resultat){
            System.out.println("Aucun livre trouvé");
        }
    }

    // Méthode pour rechercher un Livre avec le nom de l'auteur
    public void rechercherParAuteur(String auteur){
        boolean resultat = false;
        for (Livre livre : this.listeLivres) {
            String auteurtmp = livre.getAuteur();
            if (auteurtmp.equals(auteur)) {
                System.out.println("--- Livre trouvé ---\n " +
                "Titre : " + livre.getTitre() + "\n" +
                "Auteur : " + auteurtmp + "\n" +
                "Année de publication : " + livre.getAnneePublication() + "\n" +
                "ISBN : " + livre.getISBN());
                resultat = true;
                break;
            }
        }
        if(!resultat){
            System.out.println("Aucun livre trouvé");
        }
    }

    // Méthode pour rechercher un Livre avec son ISBN
    public void rechercherParISBN(String ISBN){
        boolean resultat = false;
        for (Livre livre : this.listeLivres) {
            String ISBNtmp = livre.getISBN();
            if (ISBNtmp.equals(ISBN)) {
                System.out.println("--- Livre trouvé ---\n " +
                "Titre : " + livre.getTitre() + "\n" +
                "Auteur : " + livre.getAuteur() + "\n" +
                "Année de publication : " + livre.getAnneePublication() + "\n" +
                "ISBN : " + ISBNtmp);
                resultat = true;
                break;
            }
        }
        if(!resultat){
            System.out.println("Aucun livre trouvé");
        }
    }

    // Méthode pour vérifier si l'utilisateur a cotisé
    public boolean verifierUtilisateur(Utilisateur utilisateur){
        if (utilisateur.getCotisation() == true) {
            return true;
        }
        return false;
    }

    // Méthode pour enregistrer l'emprunt d'un livre de l'utilisateur
    public void enregistrerEmprunt(Livre livre, Utilisateur utilisateur){
        utilisateur.setLivresEmpruntes(livre);
        this.empruntsUtilisateurs.put(utilisateur, utilisateur.getLivresEmpruntes());
        System.out.println("Livre emprunté avec succès !");
    }

    // Méthode pour enregistrer le retour d'un livre par l'utilisateur
    public void enregistrerRetour(Livre livre, Utilisateur utilisateur){
        ArrayList<Livre> livretmp = utilisateur.getLivresEmpruntes();
        for (Livre tmp : livretmp) {
            if (tmp == livre) {
                livretmp.remove(livre);
                this.empruntsUtilisateurs.put(utilisateur, livretmp);
                System.out.println("Retour enregistré avec succès");
                break;
            }
        }
    }

    // Méthode pour afficher la liste des Livres de la Bibliothèque
    public void afficherListeLivres(){
        for (Livre livre : this.listeLivres) {
            System.out.println("Titre : " + livre.getTitre() + "\n" +
                               "Auteur : " + livre.getAuteur() + "\n" +
                               "Année de publication : " + livre.getAnneePublication() + "\n" +
                               "ISBN : " + livre.getISBN() + "\n--------------");
        }
    }

    // Méthode pour retourner l'objet Livre en recherchant le titre
    public Livre retournerLivre(String titre){
        for (Livre  livre : this.listeLivres) {
            if (livre.getTitre().equals(titre)) {
                return livre;
            }
        }
        return null;
    }

    // Méthode pour ajouter un utilisateur dans la Bibliothèque
    public void ajouterUtilisateur(Utilisateur utilisateur){
        this.listeUtilisateurs.add(utilisateur);
    }

    // Méthode pour retourner un utilisateur en recherchant le numéro d'identification
    public Utilisateur retournerUtilisateur(int numeroIdentification){
        for (Utilisateur utilisateur : this.listeUtilisateurs) {
            if (utilisateur.getNumeroIdentification() == numeroIdentification) {
                return utilisateur;
            }
        }
        return null;
    }

}

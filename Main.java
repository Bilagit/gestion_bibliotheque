import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void menu(){
        System.out.println("**** Voici les fonctionnalités de la Bibliothèque ****");
        System.out.println("\t1. Ajouter un Livre");
        System.out.println("\t2. Supprimer un Livre");
        System.out.println("\t3. Rechercher un Livre");
        System.out.println("\t4. Afficher les Livres de la Bibliothèque");
        System.out.println("\t5. Empruntez un Livre");
        System.out.println("\t6. Retourner un Livre");
        System.out.println("\t7. Quitter la Bibliothèque");
        System.out.print("Veuillez saisir un numéro : ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String titre;
        String auteur;
        int anneePublication;
        String ISBN;
        String recherche;
        Bibliotheque maBibliotheque = new Bibliotheque(new ArrayList<Livre>(), new HashMap<Utilisateur, ArrayList<Livre>>());
        do{
            System.out.println("**** Bienvenue dans la Bibliothèque ****");
            System.out.println("Veuillez vous enregistrer !");
            System.out.print("Quel est votre nom ? : ");
            String nom = sc.nextLine();
            System.out.print("Saisir votre numéro d'identification : ");
            int ine = sc.nextInt();
            ArrayList<Livre> livreEmpruntes = new ArrayList<>();
            System.out.print("Voulez vous côtiser ? (oui/non) : ");
            String verifCotisation = sc.next();
            boolean cotisation;
            switch (verifCotisation) {
                case "oui":
                    cotisation = true;
                    break;
                case "non":
                    cotisation = false;
                    break;
                default:
                    cotisation = false;
            }
            maBibliotheque.ajouterUtilisateur(new Utilisateur(nom, ine, livreEmpruntes, cotisation));
            int choix = 0;
            while(choix != 7){
                menu();
                choix = sc.nextInt();
                sc.nextLine();
                switch (choix) {
                    case 1:
                        System.out.println("**** Ajout d'un Livre ****");
                        System.out.print("Saisir le titre : ");
                        titre = sc.nextLine();
                        System.out.print("Saisir l'auteur : ");
                        auteur = sc.nextLine();
                        System.out.print("L'année de publication (yyyy) : ");
                        anneePublication = sc.nextInt();
                        System.out.print("L'ISBN : ");
                        ISBN = sc.next();
                        maBibliotheque.ajouterLivre(new Livre(titre, auteur, anneePublication, ISBN));
                        System.out.println("Livre ajouté avec succès !!");
                        break;
                    case 2:
                        System.out.println("**** Suppression d'un Livre ****");
                        System.out.print("Saisir le titre : ");
                        titre = sc.nextLine();
                        Livre livreSupp = maBibliotheque.retournerLivre(titre);
                        if(livreSupp != null){ 
                            maBibliotheque.supprimerLivre(livreSupp);
                            System.out.println("Livre supprimé avec succès !!");
                        }
                        else{
                            System.out.println("Impossible de supprimer le Livre.");
                        }
                        break;
                    case 3:
                        System.out.println("**** Recherche d'un Livre ****");
                        System.out.println("Voulez-vous rechercher par : titre/auteur/ISBN");
                        recherche = sc.next();
                        sc.nextLine();
                        if (recherche.equals("titre")) {
                            System.out.print("Saisir le titre : ");
                            titre = sc.nextLine();
                            maBibliotheque.rechercherParTitre(titre);
                        }
                        else if (recherche.equals("auteur")) {
                            System.out.print("Saisir l'auteur : ");
                            auteur = sc.nextLine();
                            maBibliotheque.rechercherParAuteur(auteur);
                        }
                        else if (recherche.equals("ISBN")) {
                            System.out.print("ISBN : ");
                            ISBN = sc.next();
                            maBibliotheque.rechercherParISBN(ISBN);
                        }
                        else{
                            System.out.println("Choix indisponible.");
                        }
                        break;
                    case 4:
                        System.out.println("**** Liste des Livres de la Bibliothèque ****");
                        maBibliotheque.afficherListeLivres();
                        break;
                    case 5:
                        System.out.println("**** Emprunt d'un Livre ****");
                        System.out.print("Saisir votre numéro d'identification : ");
                        ine = sc.nextInt();
                        sc.nextLine();
                        Utilisateur utilisateur = maBibliotheque.retournerUtilisateur(ine);
                        if (maBibliotheque.verifierUtilisateur(utilisateur)) {
                            System.out.print("Saisir le titre : ");
                            titre = sc.nextLine();
                            Livre livreEmprunt = maBibliotheque.retournerLivre(titre);
                            if (livreEmprunt != null) {
                                maBibliotheque.enregistrerEmprunt(livreEmprunt, utilisateur);
                                System.out.println(livreEmprunt);
                            }
                        }
                        else{
                            System.out.println("Vous ne pouvez pas emprunter de livre car vous n'avez pas côtisé.");
                        }
                        break;
                    case 6:
                        System.out.println("**** Retour d'un Livre ****");
                        System.out.print("Saisir le titre : ");
                        titre = sc.nextLine();
                        System.out.print("Saisir votre numéro d'identification : ");
                        ine = sc.nextInt();
                        Utilisateur utilisateur2 = maBibliotheque.retournerUtilisateur(ine);
                        Livre livre2 = maBibliotheque.retournerLivre(titre);
                        maBibliotheque.enregistrerRetour(livre2, utilisateur2);
                        System.out.println("Livre retourné avec succès !");
                        break;
                    case 7:
                        System.out.println("\t Merci de votre visite, Aurevoir à bientôt !");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                            for (int i = 0; i < 40; i++) {
                                System.out.println();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Choix indisponible.");
                        break;
                }
                sc.nextLine();
            }
        }while (true);
    }
}

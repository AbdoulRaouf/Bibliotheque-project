import java.util.Scanner;

public class Main {

    public static  void main(String[] args){

        Gerant g= new Gerant();

       System.out.println("\n\n********-----BIENVENUE DANS NOTRE BIBLIOTHEQUE-----********");
       Scanner sc= new Scanner(System.in);
       int encore=1, choix;
       do {
           System.out.println("\n\n1.----- AJOUTER UN LIVRE-----");
           System.out.println("2.----- CHERCHER UN LIVRE-----");
           System.out.println("3.----- SUPPRIMER UN LIVRE-----");

           System.out.println("\n4.----- AJOUTER UN ADHERENT-----");
           System.out.println("5.----- CHERCHER UN ADHERENT-----");
           System.out.println("6.----- SUPPRIMER UN ADHERENT-----");

           System.out.println("\n7.----- ENREGISTRER UN EMPRUNT-----");

           System.out.println("\n8.----- AFFICHER TOUS LES LIVRES-----");
           System.out.println("9.----- AFFICHER TOUS LES ADHERENTS-----");
           System.out.println("10.----- AFFICHER TOUS LES EMPRUNTS-----");

           System.out.println("\n11.----- MODIFICATION D'UN EMPRUNT-----");
           System.out.println("\n12.----- MODIFICATION D'UN LIVRE-----");
           System.out.println("\n13.----- MODIFICATION D'UN ADHERENT-----");

           choix= sc.nextInt();


           switch (choix){

               //Ajout livre
               case 1:
                   Livre livreAjout= creerLivre();
                   if (livreAjout!=null) {
                       g.ajouterLivre(livreAjout);
                       System.out.println("^^^^^^^Livre enregistré avec succès^^^^^^^");
                   }
                   else
                       System.out.println("ECHEC D'ENREGISTREMENT DE LIVRE");
                   break;


                //Recherche de livre
               case 2:
                   Livre livreRech= g.chercherLivre();
                   if (livreRech!=null){
                       System.out.println("\nLivre recherche: \n\t"+livreRech);
                   }
                   else
                       System.out.println("ECHEC...LIVRE NON TROUVE");
                   break;

               //Sippression de livre
               case 3:
                   boolean livreSupp= g.supprimerLivre();
                   if(livreSupp){
                       System.out.println("^^^^^^^^Livre supprimé avec succès^^^^^^^^");
                   }
                   else
                       System.out.println("ECHEC...SUPPRESSION DE LIVRE NON EFFECTUEE");
                   break;

               //Ajout adherent
               case 4:
                   Adherent adhAjout= creerAdherent();
                   if (adhAjout!=null){
                       if(g.ajouterAdherents(adhAjout))
                           System.out.println("^^^^^^^^Adhérent ajouté avec succès^^^^^^^^");
                   }
                   else
                       System.out.println("ECHEC...CREATION D'ADHERENT NON EFFECTUEE");

                   break;


               //Chercher adherent
               case 5:
                   Adherent adhRech= g.chercherAdherent();
                   if (adhRech!=null){
                       System.out.println("\nAadhérent recherché: \n\t"+adhRech);
                   }
                   else
                       System.out.println("ECHEC...ADHERENT NON TROUVE");
                   break;


               //Supprimer adherent
               case 6:
                   if(g.supprimerAdherent())
                        System.out.println("^^^^^^^^Adhérent supprimé avec succès^^^^^^^^");
                   else
                        System.out.println("ECHEC...ADHERENT NON TROUVE");
                   break;

               //Enregistrer emprunt
               case 7:
                   Adherent adrEmp= g.chercherAdherent();
                   Livre livEmp= g.chercherLivre();
                   Emprunt emprunt = g.nouvelEmprunt(adrEmp, livEmp);
                   if (emprunt!=null){
                       System.out.println("^^^^^^^^EMPRUNT ENREGISTRE AVEC SUCCES");
                   }
                   else
                       System.out.println("ECHEC...EMPRUNT NON EFFECTUE");
                   break;


               //affichage des livres
               case 8:
                   System.out.println ("----------AFFICHAGE DES LIVRES----------");
                   System.out.println(g.displayAllLivres());
                   break;

               //affichage des adherents
               case 9:
                   System.out.println ("----------AFFICHAGE DES ADHERENTS----------");
                   System.out.println(g.displayAllAdherents());
                   break;

               //affichage des emprunts
               case 10:
                   System.out.println ("----------AFFICHAGE DES EMPRUNTS----------");
                   System.out.println(g.displayAllEmprunts());
                   break;


               //Modification emprunt
               case 11:
                   g.modifierEmprunt();

                   break;

               case 12:
                   g.modifierLivre();
                   System.out.println("^^^^^^^^Livre Modifié avec succès^^^^^^^^");
                   break;
               case 13:
                   g.modifierAdherent();
                   System.out.println("^^^^^^^^Adherent Modifié avec succès^^^^^^^^");
                   break;

               default:
                   break;
           }

       }while (encore==1);
    }

    public static Adherent creerAdherent(){
        Scanner sc= new Scanner(System.in);
        System.out.println("*****CREATION D'UN NOUVEL ADHERENT******");

        System.out.println("\tNom de l'adhérent: ");
        String nom= sc.nextLine();

        System.out.println("\tNuméro de l'adhérent: ");
        String numero=sc.nextLine();

        System.out.println("\tStatut de l'adhérent (true/false): ");
        boolean statut= sc.nextBoolean();

        Adherent ad= new Adherent(nom, numero, statut);
        return ad;
    }

    public static Livre creerLivre(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\n\n*****CREATION D'UN LIVRE*****");
        System.out.println("\tNom du livre: ");
        String nom= sc.nextLine();

        System.out.println("\tAuteur du livre:");
        String auteur= sc.nextLine();

        System.out.println("\tNuméro du livre (String): ");
        String numero= sc.nextLine();

        System.out.println("\tNombre d'exemplaires (int):");
        int nbr= sc.nextInt();

        Livre livre= new Livre(nom, auteur, numero, nbr);
        return livre;
    }



}

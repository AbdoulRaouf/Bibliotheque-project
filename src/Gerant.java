import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerant {

    private List<Livre> lesLivres;
    private List<Adherent> lesAdherents;

    private List<Emprunt> lesEmprunts;

    public Gerant() {
        lesAdherents= new ArrayList<>();
        lesLivres= new ArrayList<>();
        lesEmprunts= new ArrayList<>();
    }

    /**
     * Gestion des adherents
     * @param adherent
     * @return
     */
    public boolean ajouterAdherents(Adherent adherent){
        if (lesAdherents.add(adherent))
            return  true;
        else
            return false;
    }

    public String displayAllAdherents(){
        String retour="";
        for (Adherent ad: lesAdherents){
            retour+= ad.toString()+"\n";
        }
        return retour;
    }

    public boolean supprimerAdherent(){

        System.out.println("\n\n*****SUPPRESSION D'UN ADHERENT*****");
        System.out.println("\tSaisir le numéro de l'adhérent à supprimer: ");
        String numAdherent= new Scanner(System.in).nextLine();
        boolean sup=false;

        for (Adherent adherent: lesAdherents){
            if (adherent.getNumero().equals(numAdherent)){
                boolean reusi= lesAdherents.remove(adherent);
                if (reusi)
                    sup=true;
            }
            break;
        }
        return sup;
    }

    public Adherent chercherAdherent(){
        System.out.println("\n\n*****RECHERCHE D'UN ADHERENT*****");
        System.out.println("\t\tSaisir le numéro de l'Adhérent à chercher: ");
        String numAdherent= new Scanner(System.in).nextLine();
        Adherent add= null;

        for (Adherent ad: lesAdherents){
            if (ad.getNumero().equals(numAdherent)){
                add= ad;
            }
            break;
        }
        return add;
    }
    public  void modifierLivre(){
        System.out.println("******MODIFIER un livre******");
        System.out.println("Entrer le numero du Livre à modifier");
        String numLiv=new Scanner(System.in).nextLine();
        for (Livre livre:lesLivres) {
            if (livre.getNumero().equals(numLiv)){
                System.out.println("Entrer le nouveau Nom");
                String NN=new Scanner(System.in).nextLine();
                livre.setNom(NN);
                System.out.println("Entrer le nouveau Numero");
                String NNu=new Scanner(System.in).nextLine();
                livre.setNumero(NNu);
                System.out.println("Entrer le nouveau Auteur");
                String NA=new Scanner(System.in).nextLine();
                livre.setAuteur(NA);
                System.out.println("Entrer le nouveau Nombre");
                int Nnom=new Scanner(System.in).nextInt();
                livre.setNombre(Nnom);

            }
            break;
        }
    }
    public void  modifierAdherent(){
        System.out.println("******MODIFIER un Adherent******");
        System.out.println("Entrer le numero de l'Adherent à modifier");
        String numAd=new Scanner(System.in).nextLine();
        for (Adherent ad:lesAdherents){
            if (ad.getNumero().equals(numAd)){
                System.out.println("Entrer le nouveau nom");
                String nomad=new Scanner(System.in).nextLine();
                ad.setNom(nomad);
                System.out.println("Entrer le nouveau nom");
                String numad=new Scanner(System.in).nextLine();
                ad.setNumero(numad);
                System.out.println("Entrer le nouveau Statut");
                boolean stad=new Scanner(System.in).nextBoolean();
                ad.setStatut(stad);
            }
            break;
        }
    }
    public void modifierEmprunt(){
       Emprunt emprunt= chercherEmprunt();
       if (emprunt!=null){
           System.out.println("Donner le surplus de jour pour étendre la date de retour de l'emprunt (int):");
           int surplus= new Scanner(System.in).nextInt();
           emprunt.etendreDateRetour(surplus);
           System.out.println("Date de retour mise en jour....\n\tNouvelle date: "+emprunt.getDateRetour());
       }
       else
           System.out.println("Emprunt non effectuée");
    }

    /**
     * Gestion des livres
     */
    public boolean ajouterLivre(Livre livre){
        if (lesLivres.add(livre))
            return true;
        else
            return false;
    }

    public String displayAllLivres(){
        String retour="";
        for (Livre l: lesLivres){
            retour+="\n";
            retour+=l.toString();
        }
        return retour;
    }

    public Livre chercherLivre(){
        System.out.println("\n\n*****RECHERCHE D'UN LIVRE*****");
        System.out.println("\tSaisir le numéro du livre à chercher :");
        String numero= new Scanner(System.in).nextLine();
        Livre liv= null;

        for (Livre l: lesLivres){
            if (l.getNumero().equals(numero)){
                liv=l;
            }
            break;
        }
        return  liv;
    }

    public boolean supprimerLivre(){
        System.out.println("\n\n*****SUPPRESSION D'UN LIVRE*****");
        System.out.println("\tSaisir le numéro du livre à supprimer: ");
        String numAdherent= new Scanner(System.in).nextLine();
        boolean sup=false;

        for (Livre livre: lesLivres){
            if (livre.getNumero().equals(numAdherent)){
                boolean reusi= lesLivres.remove(livre);
                if (reusi)
                    sup=true;
            }
            break;
        }
        return sup;
    }


    /**
     * Gestion des emprunts
     */
    public Emprunt nouvelEmprunt(Adherent adherent, Livre livre){
        Emprunt emprunt= null;

        if ( adherent!=null && livre!=null && adherent.isStatut() && livre.getNombre()>=1) {
            livre.nouvelEmprunt();
            adherent.nouvelEmprunt(livre);
            emprunt = new Emprunt(livre, adherent);
            lesEmprunts.add(emprunt);
        }
        return emprunt;
    }

    public Emprunt chercherEmprunt(){
        System.out.println("\n\n*****RECHERCHE D'UN EMPRUNT*****");
        System.out.println("\tSaisir le numéro de l'emprunt à rechercher (int): ");
        int numEmp= new Scanner(System.in).nextInt();
        Emprunt emprunt=null;

        for (Emprunt emp: lesEmprunts){
            if (emp.getNumeroEmprunt()==numEmp){
                emprunt= emp;
            }
            break;
        }
        return emprunt;
    }

    public String displayAllEmprunts(){
        String retour="";
        for (Emprunt emp: lesEmprunts){
            retour+="\n"+emp.toString();
        }
        return  retour;
    }


}

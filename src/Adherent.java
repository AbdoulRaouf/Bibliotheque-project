import java.util.ArrayList;
import java.util.List;

public class Adherent {

    private String nom, numero;
    private boolean statut;

    private List<Livre> livresEmpruntes;

    public Adherent(String nom, String numero, boolean statut) {
        this.nom = nom;
        this.numero = numero;
        this.statut = statut;
        this.livresEmpruntes= new ArrayList<>();
    }

    public Adherent() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                ", statut=" + statut +
                '}';
    }

    public void nouvelEmprunt(Livre livre){
        this.livresEmpruntes.add(livre);
    }
}

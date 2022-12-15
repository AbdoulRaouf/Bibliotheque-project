public class Livre {

    private String nom, auteur, numero;
    private int nombre;

    public Livre(String nom, String auteur, String numero, int nombre) {
        this.nom = nom;
        this.auteur = auteur;
        this.numero = numero;
        this.nombre = nombre;
    }

    public Livre() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void nouvelEmprunt(){
        this.nombre--;
    }

    public void restituerEmprunt(){
        this.nombre++;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "nom='" + nom + '\'' +
                ", auteur='" + auteur + '\'' +
                ", numero='" + numero + '\'' +
                ", nombre=" + nombre +
                '}';
    }
}

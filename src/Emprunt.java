import java.time.LocalDate;

public class Emprunt {

    private static int id=0;
    private int numeroEmprunt;
    private Livre livreEmprunt;
    private Adherent client;
    private String dateEnregistrement, dateRetour;

    public Emprunt(Livre livreEmprunt, Adherent client) {
        this.livreEmprunt = livreEmprunt;
        this.client = client;
        this.dateEnregistrement= LocalDate.now().toString();
        this.dateRetour= LocalDate.now().plusDays(7).toString();

        id++;
        this.numeroEmprunt=id;
    }

    public Emprunt() {
    }

    public Livre getLivreEmprunt() {
        return livreEmprunt;
    }

    public void setLivreEmprunt(Livre livreEmprunt) {
        this.livreEmprunt = livreEmprunt;
    }

    public Adherent getClient() {
        return client;
    }

    public void setClient(Adherent client) {
        this.client = client;
    }

    public String getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(String dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getNumeroEmprunt() {
        return numeroEmprunt;
    }

    public void setNumeroEmprunt(int numeroEmprunt) {
        this.numeroEmprunt = numeroEmprunt;
    }

    public void etendreDateRetour(int joursSurplus){
        LocalDate dateret= LocalDate.parse(this.getDateRetour());
        LocalDate nouv=dateret.plusDays(joursSurplus);
        this.setDateRetour(nouv.toString());
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "numeroEmprunt=" + numeroEmprunt +
                ", livreEmprunt=" + livreEmprunt +
                ", client=" + client +
                ", dateEnregistrement='" + dateEnregistrement + '\'' +
                ", dateRetour='" + dateRetour + '\'' +
                '}';
    }
}

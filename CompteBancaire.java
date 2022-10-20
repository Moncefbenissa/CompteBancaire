import java.util.Scanner;

public class CompteBancaire{
    Scanner scanner = new Scanner(System.in);

    //Déclaration des attributs:
    private String nom;
    private long numero;
    private double sold;
    private static int nbrComptes = 0;

    //Constructeurs:

    public CompteBancaire(){
        System.out.println("Entrer le nom complet ..."); nom = scanner.nextLine();

        //Générer un id/num de compte
        numero = ++(nbrComptes);

        /*
         Note:
            int a = 3 ;
            int b = ++a; -> Pré Incrémentation
            int c = a++;  -> Post Incrémentation
        */
        sold = 0;
    }

    public CompteBancaire(String nom, long numero, double sold) {
        this.nom = nom;
        this.numero = numero;
        this.sold = sold;
    }


    //Getters and setters:

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public static int getNbrComptes() {
        return nbrComptes;
    }

    //Affichage d'objet: (La fonction toString renvoie la description d'objet)
    @Override
    public String toString() {
        return "CompteBancaire{"+
                "  Nom='" + nom + '\'' +
                ", Numero=" + numero +
                ", Sold=" + sold +
                '}';
    }

    //Définition des fonctions:

    public void verser(double s){
        if(s > 0) this.sold += s;
    }

    public void verser(){
        System.out.println("Entrer le montant à verser ...");
        scanner.nextLine();
        double input = scanner.nextDouble();
        if(input > 0) this.sold += input;
    }

    public void virer(double montant,CompteBancaire compte){
        if(montant > 0) compte.setSold(compte.getSold()+montant);
    };

    public void virer(CompteBancaire compte){
        System.out.println("Entrer le montant à virer ...");
        double input = scanner.nextDouble();
        if(input > 0) compte.setSold(compte.getSold()+input);
    }

    public double retirer(double montant){
        if(montant > 0 && montant <= 3000) {
            this.sold -= montant;
            return montant;
        }
        else return 0;
    }
    public double retirer(){
        System.out.println("Entrer un montant :");
        double montant = scanner.nextDouble();

        if(montant > 0 && montant <= 3000) {
            this.sold -= montant;
            return montant;
        }
        else return 0;
    }


    private char menuCompte(){
        System.out.println("Afficher \t a \n" + "Verser \t v \n" + "Retirer \t r \n" + "Quitter \t q \n");
        char choix = scanner.next().charAt(0);
        return choix;
    }

    public void operations(){
        char choix =' ';
        while((choix = menuCompte()) != 'q') {
            switch (choix) {
                case 'a':
                    System.out.println(this);
                    break;
                case 'v':
                    verser();
                    break;
                case 'r':
                    retirer();
                    break;
                case 'q':
                    break;
            }
        }
    }

    //La fonction main:
    public static void main(String[] args) {
        Banque banque = new Banque(20);
        banque.operations();
    }

}



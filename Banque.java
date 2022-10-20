import java.util.Scanner;

public class Banque {
    Scanner scanner = new Scanner(System.in);
    private int nombreMax;
    private int nombre;

    private  CompteBancaire comptes[]; //Déclaration du tableau

    public Banque(int nombreM){
        this.nombreMax = nombreM;
        nombre = 0;
        comptes = new CompteBancaire[nombreMax];
    }

    //Définition des fonctions :

    public void creerComptes(){
        if(nombre == nombreMax){
            System.out.println("Impossible de créer un compte ! ");
            return;
        }
        comptes[nombre++] = new CompteBancaire();
    }
    public void listerComptes(){
        for(CompteBancaire c : comptes) {if(c != null){
            System.out.println(c.toString());
        }}
    }
    public int chercherCompte(int numeroCompte){
        for(int i = 0 ; i < comptes.length ; i++){
            if(comptes[i].getNumero() == numeroCompte) return i;
        }
        return -1;
    }
    public int chercherCompte(String nomCompte){
        for(int i = 0 ; i < comptes.length ; i++){
            if(comptes[i].getNom() == nomCompte) return i;
        }
        return -1;
    }
    public void operationCompte(){
        System.out.println("Entrer le numéro du compte : ");
        int numero  = scanner.nextInt();
        int index = chercherCompte(numero);
        if(index >= 0){
            comptes[index].operations();
        }
    }
    private char menuBanque(){
        System.out.println("********************* MENU ***********************\n Lister \t l \n" + "Operations sur le compte \t o \n" + "Creer Compte \t c \n" + "Quitter \t q \n +********************************************\n");
        char choix = scanner.next().charAt(0);
        return choix;
    }
    public void operations(){
        char choix =' ';
        while((choix = menuBanque()) != 'q') {
            switch (choix) {
                case 'l':
                    listerComptes();
                    break;
                case 'o':
                    operationCompte();
                    break;
                case 'c':
                    creerComptes();
                    break;
                case 'q':
                    break;
            }
        }
    }

}

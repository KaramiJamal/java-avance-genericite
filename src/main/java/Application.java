import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner sc;
    private static IMetier<Produit> produits;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        produits = new MetierProduitImpl();
        //
        String value="0";
        while (!value.equals("5")){
            System.out.print("###########################\n\n");
            System.out.println("1. Afficher la liste des produits.\n" +
                    "2. Rechercher un produit par son id.\n" +
                    "3. Ajouter un nouveau produit dans la liste.\n" +
                    "4. Supprimer un produit par id.\n" +
                    "5. Quitter ce programme.");
            value = sc.nextLine();
            switch (value){
                case "1" :
                    showAllProduct();
                    break;
                case "2" :
                    findProductById();
                    break;
                case "3" :
                    addNewProduct();
                    break;
                case "4" :
                    deleteProductById();
                    break;
                case "5" :
                    System.out.println("See you later!");
                    break;
                default:
                    System.out.println("Invalid choice !");
            }

        }

    }

    private static void showAllProduct() {
        List<Produit> produitList = produits.getAll();
        if(produitList.size()==0){
            System.out.println("Il n'y a aucun produit !");
        }else{
            produitList.forEach(p-> System.out.println(p));
        }
    }

    private static void deleteProductById() {
        System.out.print("Tap the ID of the product : ");
        Long id = sc.nextLong();sc.nextLine();
        produits.delete(id);
    }

    private static void addNewProduct() {
        try {
            int id;
            String nom;
            String marque;
            double prix;
            String description;
            int nbrStock;
            System.out.print("id : ");id= sc.nextInt();sc.nextLine();
            System.out.print("Name : ");nom = sc.nextLine();
            System.out.print("marque : ");marque = sc.nextLine();
            System.out.print("prix : ");prix = sc.nextDouble();sc.nextLine();
            System.out.print("description : ");description = sc.nextLine();
            System.out.print("nombre stock : ");nbrStock = sc.nextInt();sc.nextLine();
            Produit p = new Produit(id, nom, marque, prix, description, nbrStock);
            produits.add(p);
            System.out.println("product added successfully");
        }catch (Exception exception){
            System.out.println("Invalid value!");
        }
    }

    private static void findProductById() {
        System.out.print("id : ");
        int id = sc.nextInt();
        sc.nextLine();
        Produit produit = produits.findById(id);
        if(produit != null){
            System.out.println(produit);
        }else{
            System.out.println("Produit not found");
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit o) {
        if(o != null){
            this.produits.add(o);
        }
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for( Produit p: produits){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit produit = null;
        for( Produit p: produits){
            if(p.getId() == id){
                produit = p;
                break;
            }
        }
        if(produit != null){
            produits.remove(produit);
            System.out.println("Product removed");
        }else{
            System.out.println("Product not found");
        }
    }
}

import java.util.List;

public interface IMetier<T> {
    public void add(T o); //: qui permet d’ajouter un objet à la liste.
    public List<T> getAll(); // : qui retourne la liste des objets sous forme d’une liste.
    public T findById(long id); // : qui retourne un produit par id.
    public void delete(long id); // : qui supprime un objet par id.
}

import java.util.List;
import java.util.*;

public class GestorCatalogo {
  private final Map<Integer, Material> catalogo = new HashMap<>();

  public void agregarMaterial(Material material) {
    catalogo.put(material.getId(), material);
  }

  public void eliminarMaterial(int id) {
    catalogo.remove(id);
  }

  public Optional<Material> obtenerPorId(int id) {
    return Optional.ofNullable(catalogo.get(id));
  }

  public List<Material> bucarPorTitulo(String texto) {
    String t = texto.toLowerCase();
    return catalogo.values().stream().filter(material -> material.getTitulo().toLowerCase().contains(t)).toList();
  }

  public List<Material> buscarPorTipo(String tipo) {
    return catalogo.values().stream().filter(material -> material.getTipo().equalsIgnoreCase(tipo)).toList();
  }

  public List<Material> listarDisponibles() {
    return catalogo.values().stream().filter(Material::getDisponible).toList();
  }

  public Collection<Material> listarTodo() {
    return Collections.unmodifiableCollection(catalogo.values());
  }

}

import java.util.List;
import java.util.*;

public class GestorPrestamos {
  private static final int max_Prestamos = 3;
  private final Map<String, List<Material>> prestamos = new HashMap<>();

  public boolean prestar(Persona persona, Material material) {
    if (!material.getDisponible()) {
      System.out.println("Ya se prestó el matrial");
      return false;
    }

    List<Material> lista = prestamos.computeIfAbsent(persona.getId(), k -> new ArrayList<>());

    if (lista.size() >= max_Prestamos) {
      System.out.println(persona.getNombre() + "Ya alcanzo el limite de" + max_Prestamos + "prestamos");
      return false;
    }

    material.registrarPrestamo();
    lista.add(material);
    System.out.println("Prestado " + material.getTitulo() + " a " + persona.getNombre());
    return true;
  }

  public boolean deolver(Persona persona, int idMaterial) {
    List<Material> lista = prestamos.get(persona.getId());

    if (lista == null) {
      System.out.println(persona.getNombre() + " no tiene prestamos activos");
      return false;
    }

    Optional<Material> opcional = lista.stream().filter(material -> material.getId() == idMaterial).findFirst();

    if (opcional.isEmpty()) {
      System.out.println(persona.getNombre() + " no esta asociado con este producto");
      return false;
    }

    Material material = opcional.get();
    material.registrarDevolucion();
    lista.remove(material);
    System.out.println("Se devolvio" + material.getTitulo() + " y lo devolvio: " + persona.getNombre());
    return true;
  }

  public List<Material> prestamosDe(Persona persona) {
    return prestamos.getOrDefault(persona.getId(), List.of());
  }

  public int cantidadDePrestamos(Persona persona) {
    return prestamosDe(persona).size();
  }
}

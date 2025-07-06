import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ArchivoUtils {
  private ArchivoUtils() {
  }

  /*---------------------------------------------------------------
     * 1. Cargar catálogo completo
     *    dataDir = ruta a la carpeta data (p.e. "Biblioteca/data")
     *---------------------------------------------------------------*/
  public static void cargarCatalogo(String dataDir, GestorCatalogo cat) throws IOException {
    cargarLibros(Paths.get(dataDir, "libros.txt"), cat);
    cargarDvds(Paths.get(dataDir, "dvds.txt"), cat);
    cargarRevistas(Paths.get(dataDir, "revistas.txt"), cat);
  }

  /*---------------------------------------------------------------
   * 2. Métodos específicos para cada tipo
   *---------------------------------------------------------------*/
  private static void cargarLibros(Path file, GestorCatalogo cat) throws IOException {
    List<String> lineas = Files.readAllLines(file);
    for (String l : lineas) {
      if (l.isBlank())
        continue; // salta líneas vacías
      String[] p = l.split("\\|");
      try {
        int id = Integer.parseInt(p[0]);
        String titulo = p[1];
        String genero = p[2];
        String autor = p[3];
        int paginas = Integer.parseInt(p[4]);
        String isbn = p[5];

        Libro libro = new Libro(titulo, genero, id, autor, paginas, isbn);
        cat.agregarMaterial(libro);
      } catch (Exception e) {
        System.err.println("❌ Línea malformada en libros.txt: " + l);
      }
    }
  }

  private static void cargarDvds(Path file, GestorCatalogo cat) throws IOException {
    List<String> lineas = Files.readAllLines(file);
    for (String l : lineas) {
      if (l.isBlank())
        continue;
      String[] p = l.split("\\|");
      try {
        int id = Integer.parseInt(p[0]);
        String titulo = p[1];
        String genero = p[2];
        String director = p[3];
        String duracionMin = p[4];

        DVD dvd = new DVD(titulo, genero, id, director, duracionMin);
        cat.agregarMaterial(dvd);
      } catch (Exception e) {
        System.err.println("❌ Línea malformada en dvds.txt: " + l);
      }
    }
  }

  private static void cargarRevistas(Path file, GestorCatalogo cat) throws IOException {
    List<String> lineas = Files.readAllLines(file);
    for (String l : lineas) {
      if (l.isBlank())
        continue;
      String[] p = l.split("\\|");
      try {
        int id = Integer.parseInt(p[0]);
        String titulo = p[1];
        String genero = p[2];
        String tematica = p[3];
        String edicion = p[4];

        Revista rev = new Revista(titulo, genero, id, tematica, edicion);
        cat.agregarMaterial(rev);
      } catch (Exception e) {
        System.err.println("❌ Línea malformada en revistas.txt: " + l);
      }
    }
  }
}

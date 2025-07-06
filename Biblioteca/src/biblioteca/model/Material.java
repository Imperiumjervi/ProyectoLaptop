public abstract class Material {
  private String titulo;
  private String genero;
  private boolean disponible = true;
  private final int id;

  public Material(String titulo, String genero, int id) {
    this.titulo = titulo;
    this.genero = genero;
    this.id = id;
  }

  public abstract void mostrarInformacion();

  public abstract String getTipo();

  public void registrarPrestamo() {
    if (!disponible) {
      System.out.println("No se puede prestar, esta ocupado");
      return;
    }
    disponible = false;
  }

  public void registrarDevolucion() {
    disponible = true;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getGenero() {
    return genero;
  }

  public boolean getDisponible() {
    return disponible;
  }

  public int getId() {
    return id;
  }
}

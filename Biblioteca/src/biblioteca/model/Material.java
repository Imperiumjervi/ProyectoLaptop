public abstract class Material {
  private String titulo;
  private String genero;
  private boolean disponible = true;

  public Material(String titulo, String genero) {
    this.titulo = titulo;
    this.genero = genero;
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

  void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  void setGenero(String genero) {
    this.genero = genero;
  }

  void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }
}

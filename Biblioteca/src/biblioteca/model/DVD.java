/**
 * DVD
 */
public class DVD extends Material {
  private String director;
  private String duracion;

  public DVD(String titulo, String genero, int id, String director, String duracion) {
    super(titulo, genero, id);
    this.director = director;
    this.duracion = duracion;
  }

  void setDirector(String director) {
    this.director = director;
  }

  void setDuracion(String duracion) {
    this.duracion = duracion;
  }

  String getDirector() {
    return director;
  }

  String getDuracion() {
    return duracion;
  }

  @Override
  public void mostrarInformacion() {

  }

  @Override
  public String getTipo() {
    return "DVD";
  }
}

public class Revista extends Material {
  String tematica;
  String edicion;

  public Revista(String titulo, String genero, int id, String tematica, String edicion) {
    super(titulo, genero, id);
    this.tematica = tematica;
    this.edicion = edicion;
  }

  @Override
  public void mostrarInformacion() {

  }

  @Override
  public String getTipo() {
    return "Revista";
  }

  void setTematica(String tematica) {
    this.tematica = tematica;
  }

  void setEdicion(String edicion) {
    this.edicion = edicion;
  }

  String getTematica() {
    return tematica;
  }

  String getEdicion() {
    return edicion;
  }
}

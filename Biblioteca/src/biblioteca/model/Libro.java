public class Libro extends Material {
  private String autor;
  private int paginas;

  Libro(String titulo, String genero, String autor, int paginas) {
    super(titulo, genero);
    this.autor = autor;
    this.paginas = paginas;
  }

  @Override
  public void mostrarInformacion() {

  }

  @Override
  public String getTipo() {
    return "Libro";
  }

  void setAutor(String autor) {
    this.autor = autor;
  }

  void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  String getAutor() {
    return autor;
  }

  int getPaginas() {
    return paginas;
  }
}

public class Libro extends Material {
  private String autor;
  private int paginas;
  private String isbn;

  Libro(String titulo, String genero, int id, String autor, int paginas, String isbn) {
    super(titulo, genero, id);
    this.autor = autor;
    this.paginas = paginas;
    this.isbn = isbn;
  }

  @Override
  public void mostrarInformacion() {

  }

  @Override
  public String getTipo() {
    return "Libro";
  }

  public String getIsbn() {
    return isbn;
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

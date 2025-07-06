import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaterialTest {

  private Libro libro;
  private GestorPrestamos gp;
  private Persona ana;

  @BeforeEach
  void setUp() {
    libro = new Libro("1984", "Distopía", 1,
        "George Orwell", 328, "978-8499890944");
    gp = new GestorPrestamos();
    ana = new Persona("CC123", "Ana López");
  }

  /*------------------------------------------
   * 1. Prueba de getters / setters
   *------------------------------------------*/
  @Test
  void gettersSettersFuncionan() {
    libro.setTitulo("Animal Farm");
    assertEquals("Animal Farm", libro.getTitulo());
    assertEquals("Libro", libro.getTipo());
  }

  /*------------------------------------------
   * 2. Prueba de préstamo y devolución
   *------------------------------------------*/
  @Test
  void prestamoYDevolucion() {
    assertTrue(libro.getDisponible());

    // Prestamos
    assertTrue(gp.prestar(ana, libro));
    assertFalse(libro.getDisponible());

    // Segundo préstamo (mismo libro) debe fallar
    assertFalse(gp.prestar(ana, libro));

    // Devolvemos
    assertTrue(gp.devolver(ana, 1));
    assertTrue(libro.getDisponible());
  }
}

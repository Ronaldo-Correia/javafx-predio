import java.util.ArrayList;
import java.util.List;
public class Andar {
      private double valorMetroQuadrado;
      private List<Sala> salas;
  
      public Andar(double valorMetroQuadrado) {
          this.valorMetroQuadrado = valorMetroQuadrado;
          this.salas = new ArrayList<>();
      }
  
      public void adicionarSala(Sala sala) {
          salas.add(sala);
      }
  
      public double calcularAluguel() {
          double aluguelTotal = 0;
          for (Sala sala : salas) {
              aluguelTotal += sala.getTamanho() * valorMetroQuadrado;
          }
          return aluguelTotal;
      }
  }
    
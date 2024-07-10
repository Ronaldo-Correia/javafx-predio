import java.util.ArrayList;
import java.util.List;

public class Edificio  {
    private List<Andar> andares;

    public Edificio() {
        this.andares = new ArrayList<>();
    }

    public void adicionarAndar(Andar andar) {
        andares.add(andar);
    }

    public double calcularAluguelTotal() {
        double aluguelTotal = 0;
        for (Andar andar : andares) {
            aluguelTotal += andar.calcularAluguel();
        }
        return aluguelTotal;
    }
}

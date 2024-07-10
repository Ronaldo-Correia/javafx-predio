public class AreadoPrédio {
    public static void main(String[] args) {
        // Criando salas
        Sala sala1 = new Sala(50.0);
        Sala sala2 = new Sala(30.0);
        Sala sala3 = new Sala(40.0);

        // Criando andares e adicionando salas
        Andar andar1 = new Andar(20.0);
        andar1.adicionarSala(sala1);
        andar1.adicionarSala(sala2);

        Andar andar2 = new Andar(25.0);
        andar2.adicionarSala(sala3);

        // Criando edifício e adicionando andares
        Edificio edificio = new Edificio();
        edificio.adicionarAndar(andar1);
        edificio.adicionarAndar(andar2);

        // Calculando o aluguel total do prédio
        double aluguelTotal = edificio.calcularAluguelTotal();
        System.out.println("O aluguel total do prédio é: R$ " + aluguelTotal);
    }
}

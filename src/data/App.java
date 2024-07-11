package data;

public class App {
    public static void main(String[] args) {
        Data data1 = new Data(1, 1, 2024);
        Data data2 = new Data(2, 1, 2024);

        System.out.println("Data 1: " + data1 + " | Data 2: " + data2);
        System.out.println("data1.anterior(data2): " + data1.anterior(data2));
        System.out.println("data1.posterior(data2): " + data1.posterior(data2));
        System.out.println("data1.igual(data2): " + data1.igual(data2));
        data1.incrementarDia();
        System.out.println("Data 1: " + data1 + " | Data 2: " + data2);
        System.out.println("data1.anterior(data2): " + data1.anterior(data2));
        System.out.println("data1.posterior(data2): " + data1.posterior(data2));
        System.out.println("data1.igual(data2): " + data1.igual(data2));
        data1.incrementarDia();
        System.out.println("Data 1: " + data1 + " | Data 2: " + data2);
        System.out.println("data1.anterior(data2): " + data1.anterior(data2));
        System.out.println("data1.posterior(data2): " + data1.posterior(data2));
        System.out.println("data1.igual(data2): " + data1.igual(data2));
    }
}

package data;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    // Construtor
    public Data(int dia, int mes, int ano) {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {
            this.mes = 1;
        }
        if (dia > 0 && dia <= diasNoMes(mes, ano)) {
            this.dia = dia;
        } else {
            this.dia = 1;
        }
        this.ano = ano;
    }

    // Método para verificar se a data atual é anterior à data passada como parâmetro
    public boolean anterior(Data outraData) {
        return this.valorNumerico() < outraData.valorNumerico();
    }

    // Método para verificar se a data atual é posterior à data passada como parâmetro
    public boolean posterior(Data outraData) {
        return this.valorNumerico() > outraData.valorNumerico();
    }

    // Método para verificar se a data atual é igual à data passada como parâmetro
    public boolean igual(Data outraData) {
        return this.valorNumerico() == outraData.valorNumerico();
    }

    // Método auxiliar para converter a data em um valor numérico
    private int valorNumerico() {
        return (ano * 10000) + (mes * 100) + dia;
    }

    // Método para incrementar o dia, ajustando mês e ano se necessário
    public void incrementarDia() {
        dia++;
        if (dia > diasNoMes(mes, ano)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                ano++;
            }
        }
    }

    // Método auxiliar para obter o número de dias em um mês específico
    private int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (anoBissexto(ano)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }

    // Método auxiliar para verificar se um ano é bissexto
    private boolean anoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método para exibir a data no formato texto
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}

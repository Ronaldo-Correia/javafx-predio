package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Andar {
    private List<Sala> salas;
    private int valorMetro;
    public Andar(int valorMetro) {
        salas = new ArrayList<>();
        this.valorMetro = valorMetro;
    }    
    public  void addSala(Sala sala){
        salas.add(sala);
    }

    public int getValor(){
        int valor = 0;
        for (Sala sala : salas) {
            valor+=sala.getTamanho();
        }
        valor*=valorMetro;
        return valor;
    }
}

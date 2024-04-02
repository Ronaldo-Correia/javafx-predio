package com.example;

import java.util.ArrayList;
import java.util.List;

public class Predio {
    List<Andar> andares;

    public Predio() {
        andares = new ArrayList<>();
    }

    public void addAndar(Andar andar){
        andares.add(andar);
    }

    public int getValor(){
        int valor = 0;
        for (Andar andar : andares) {
            valor+=andar.getValor();
        }
        return valor;
    }

    
}

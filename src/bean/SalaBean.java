package bean;

import java.io.Serializable;

public class SalaBean implements Serializable {
    private String capacidade;
    private String numero;

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

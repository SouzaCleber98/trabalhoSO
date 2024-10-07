package com.fatec.model;

public class Processo {

private String nome;
private int tempoExe;
private int tempoChegada;
private boolean flag;
private int tempoEspera;
private int termino;

public Processo(String nome, int tempoExe, int tempoChegada) {
    this.nome = nome;
    this.tempoExe = tempoExe;
    this.tempoChegada = tempoChegada;
    this.flag=false;
    this.tempoEspera=0;
    this.termino=0;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public int getTempoExe() {
    return tempoExe;
}

public void setTempoExe(int tempoExe) {
    this.tempoExe = tempoExe;
}

public int getTempoChegada() {
    return tempoChegada;
}

public void setTempoChegada(int tempoChegada) {
    this.tempoChegada = tempoChegada;
}

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }
    
    


}

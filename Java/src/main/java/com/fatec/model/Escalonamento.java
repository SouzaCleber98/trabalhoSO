package com.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class Escalonamento {

  
private List<Processo> processos;
private List<Processo> terminado=new ArrayList<>();
public static int tempo=0;


    public Escalonamento(List<Processo> processos) {
        this.processos = processos;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public List<Processo> getTerminado() {
        return terminado;
    }

    public void setTerminado(List<Processo> terminado) {
        this.terminado = terminado;
    }

    public static int getTempo() {
        return tempo;
    }

    public static void setTempo(int tempo) {
        Escalonamento.tempo = tempo;
    }

//Métodos

public void encontrarMenor() {
    // Se não houver processos, não faça nada
    if (processos.isEmpty()) {
        return;
    }

    // Inicialmente, marque o primeiro processo
    processos.get(0).setFlag(true);

    for (int i = 0; i < processos.size() - 1; i++) {
        // Verifica se o processo atual tem tempo de execução maior que o próximo
        if (processos.get(i).getTempoExe() > processos.get(i + 1).getTempoExe()) {
            // Desmarca o processo atual e marca o próximo
            processos.get(i).setFlag(false);
            processos.get(i + 1).setFlag(true);
        } else {
            // Se o próximo não for menor, garante que o processo atual mantém a flag
            processos.get(i + 1).setFlag(false);
        }
    }

    // Se ainda houver apenas um processo, marque a flag como true
    if (processos.size() == 1) {
        processos.get(0).setFlag(true);
    }
}


public void escalonar() {
    // Se não houver mais processos, finalize a execução
    if (processos.isEmpty()) {
        return;
    }

    encontrarMenor(); // Encontra o menor processo

    boolean encontrou = false; // Para verificar se algum processo foi encontrado
    for (Processo processo : processos) {
        if (processo.isFlag()) {
            encontrou = true;
            processo.setTempoEspera(tempo);
            tempo += processo.getTempoExe();
            terminado.add(processo);
            
            processo.setTermino(processo.getTempoChegada() + processo.getTempoEspera() + processo.getTempoExe());
            // Remove o processo atual
            processos.remove(processo); 
            break; // Para evitar ConcurrentModificationException
        }
    }

    // Se um processo foi encontrado, chame o método novamente
    if (encontrou) {
        escalonar(); // Chamada recursiva para continuar o escalonamento
    }
}

   


}







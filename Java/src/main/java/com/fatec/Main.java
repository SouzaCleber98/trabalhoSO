package com.fatec;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.fatec.model.Escalonamento;
import com.fatec.model.Processo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Processo> processos = new ArrayList<>();

        System.out.print("Quantos processos você deseja inserir? ");
        int quantidade = 0;
        while (quantidade <= 0) {
            try {
                quantidade = scanner.nextInt();
                if (quantidade <= 0) {
                    System.out.println("Por favor, insira um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        scanner.nextLine(); // Consumir a nova linha após nextInt

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome do processo: ");
            String nome = scanner.nextLine();

            int tempoExe = 0;
            int tempoChegada = 0;

            // Lê o tempo de execução
            while (tempoExe <= 0) {
                System.out.print("Digite o tempo de execução: ");
                try {
                    tempoExe = scanner.nextInt();
                    if (tempoExe <= 0) {
                        System.out.println("O tempo de execução deve ser um valor positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número válido.");
                    scanner.nextLine(); // Limpa o buffer
                }
            }
            scanner.nextLine(); // Consumir a nova linha após nextInt

            // Lê o tempo de chegada
            while (tempoChegada < 0) { // Tempo de chegada pode ser 0, mas não negativo
                System.out.print("Digite o tempo de chegada: ");
                try {
                    tempoChegada = scanner.nextInt();
                    if (tempoChegada < 0) {
                        System.out.println("O tempo de chegada não pode ser negativo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número válido.");
                    scanner.nextLine(); // Limpa o buffer
                }
            }
            scanner.nextLine(); // Consumir a nova linha após nextInt

            Processo processo = new Processo(nome, tempoExe, tempoChegada);
            processos.add(processo);
        }

        Escalonamento escalonamento = new Escalonamento(processos);
        escalonamento.escalonar();

        System.out.println("Processos terminados:");
        for (Processo p : escalonamento.getTerminado()) {
            System.out.printf("Nome: %s, Tempo de Espera: %d, Tempo de Término: %d%n", 
                              p.getNome(), p.getTempoEspera(), p.getTermino());
        }

        scanner.close(); // Fechar o scanner
    }
}

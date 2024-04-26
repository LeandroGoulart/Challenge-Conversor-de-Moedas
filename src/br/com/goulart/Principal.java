package br.com.goulart;

import java.util.Scanner;

import br.com.goulart.model.RespostaParesMoedas;
import br.com.goulart.api.ObterParMoedas;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        var conversor = new ObterParMoedas();

        while(true) {
            System.out.println("""
                    *=============================================================*
                    * Bem-vindo ao Conversor de Moedas - Desenvolvido por Goulart *
                    *-------------------------------------------------------------*
                    *  (1) DÓLAR AMERICANO =>  PESO ARGENTINO                     *
                    *  (2) PESO ARGENTINO  =>  DÓLAR AMERICANO                    *
                    *  (3) DÓLAR AMERICANO =>  REAL BRASILEIRO                    *
                    *  (4) REAL BRASILEIRO =>  DÓLAR AMERICANO                    *
                    *  (5) DÓLAR AMERICANO =>  PESO COLOMBIANO                    *
                    *  (6) PESO COLOMBIANO =>  DÓLAR AMERICANO                    *
                    *  (7) SAIR DO PROGRAMA                                       *
                    *=============================================================*
                    Por Favor, Digite a Opção Desejada: """);


            opcao = entrada.nextInt();

            if(opcao == 7) {
                break;
            }

            switch (opcao) {
                case 1:
                    conversor.moedaBase = "USD";
                    conversor.moedaAlvo = "ARS";
                    break;
                case 2:
                    conversor.moedaBase = "ARS";
                    conversor.moedaAlvo = "USD";
                    break;
                case 3:
                    conversor.moedaBase = "USD";
                    conversor.moedaAlvo = "BRL";
                    break;
                case 4:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "USD";
                    break;
                case 5:
                    conversor.moedaBase = "USD";
                    conversor.moedaAlvo = "COP";
                    break;
                case 6:
                    conversor.moedaBase = "COP";
                    conversor.moedaAlvo = "USD";
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, verifique.");
                    break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            double valor = entrada.nextDouble();

            RespostaParesMoedas resultado = conversor.obterParMoedas(valor);

            System.out.println("O valor de " + conversor.moedaBase + " " + valor +
                    " para " + conversor.moedaAlvo + " é " + resultado.conversion_result);
        }
    }
}

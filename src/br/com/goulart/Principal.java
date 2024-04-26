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
                    *   (1) BRL Real Brasileiro   =>    Dólar Americano USD       *
                    *   (2) USD Dólar Americano   =>    Real Brasileiro BRL       *
                    *   (3) BRL Real Brasileiro   =>    Euro EUR                  *
                    *   (4) EUR Euro              =>    Real Brasileiro BRL       *
                    *   (5) BRL Real Brasileiro   =>    Libra Esterlina GBP       *
                    *   (6) GBP Libra Esterlina   =>    Real Brasileiro BRL       *
                    *   (7) BRL Real Brasileiro   =>    Peso Argentino ARS        *
                    *   (8) ARS Peso Argentino    =>    Real Brasileiro BRL       *
                    *   (9) BRL Real Brasileiro   =>    Dólar Canadense CAD       *
                    *  (10) CAD Dólar Canadense   =>    Real Brasileiro BRL       *
                    *  (11) SAIR DO PROGRAMA                                      *
                    *=============================================================*
                    Por Favor, Digite a Opção Desejada: """);

            opcao = entrada.nextInt();

            if(opcao == 11) {
                break;
            }

            switch (opcao) {
                case 1:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "USD";
                    break;
                case 2:
                    conversor.moedaBase = "USD";
                    conversor.moedaAlvo = "BRL";
                    break;
                case 3:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "EUR";
                    break;
                case 4:
                    conversor.moedaBase = "EUR";
                    conversor.moedaAlvo = "BRL";
                    break;
                case 5:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "GBP";
                    break;
                case 6:
                    conversor.moedaBase = "GBP";
                    conversor.moedaAlvo = "BRL";
                    break;
                case 7:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "ARS";
                    break;
                case 8:
                    conversor.moedaBase = "ARS";
                    conversor.moedaAlvo = "BRL";
                    break;
                case 9:
                    conversor.moedaBase = "BRL";
                    conversor.moedaAlvo = "CAD";
                    break;
                case 10:
                    conversor.moedaBase = "CAD";
                    conversor.moedaAlvo = "BRL";
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, verifique.");
                    break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            conversor.quantidade = entrada.nextDouble();

            RespostaParesMoedas resultado = conversor.obterParMoedas();

            System.out.println("O valor de " + conversor.moedaBase + " " + conversor.quantidade +
                    " para " + conversor.moedaAlvo + " é " + resultado.conversion_result);
        }
    }
}
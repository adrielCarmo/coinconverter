package br.com.coinconverter.controller;

import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal {
    int op;
    Scanner r;

    public void imprimeMenu() {
        System.out.println("""
                           ============== SISTEMA COINMATCH ==============
                           Bem vindo ao sistema conversor de moedas!
                           
                           1 - Dólar [USD] > Real [BRL]
                           2 - Real [BRL] > Dólar [USD]
                           3 - Dólar [USD] > Euro [EUR]
                           4 - Euro [EUR] > Real [BRL]
                           5 - Yuan (Chinês) [CNY] > Real [BRL]
                           6 - Peso Argentino [ARS] > Real [BRL]
                           0 - Sair
                           
                           Digite a opção desejada:""");

    }

    public void iniciar() {
        r = new Scanner(System.in);

        double valorMoeda;

        do {
            imprimeMenu();
            op = r.nextInt();

            valorMoeda = leValorMoeda();

            switch (op){
                case 1:
                    converteMoeda("USD", "BRL", valorMoeda);
                    break;
                case 2:
                    converteMoeda("BRL", "USD", valorMoeda);
                    break;
                case 3:
                    converteMoeda("USD", "EUR", valorMoeda);
                    break;
                case 4:
                    converteMoeda("EUR", "BRL", valorMoeda);
                    break;
                case 5:
                    converteMoeda("CNY", "BRL", valorMoeda);
                    break;
                case 6:
                    converteMoeda("ARS", "BRL", valorMoeda);
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    System.exit(1);
                default:
                    System.out.println("Opção Inválida! Digite uma opção válida...\n\n");
                    break;
            }
        } while (op != 0);
    }

    public Double leValorMoeda() {
        if (op >=1 && op <=6) {
            r = new Scanner(System.in);
            System.out.println("Digite o valor que deseja realizar a conversão: ");
            return r.nextDouble();
        } else {
            return 0d;
        }
    }

    public void converteMoeda(String siglaMoedaBase, String siglaMoedaAlvo, Double valor) {
        try {
            System.out.println("%.2f [%s] equivalem ao valor final de %.2f [%s]"
                    .formatted(valor, siglaMoedaBase, new ConversorDeMoedas()
                    .converteValorMoeda(siglaMoedaBase, siglaMoedaAlvo, valor), siglaMoedaAlvo));
        } catch (IOException | InterruptedException | NullPointerException e) {
            System.out.println("ERR0! Não foi possível realizar a conversão!");
            System.out.println("Motivo: " + e.getMessage());
            System.exit(99);
        }
        msgFinalizar();
    }

    public void msgFinalizar() {
        r = new Scanner(System.in);

        System.out.println("""
                        
                        CONVERSÃO REALIZADA COM SUCESSO!
                        Pressione ENTER para voltar ao menu...""");
        r.nextLine();
    }
}
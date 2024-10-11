package com.jefferson.application;

import com.jefferson.service.ApiService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static Map<String, Double> currencys;

    public static void showMenu() {


        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter =]");
        System.out.println("*".repeat(40));

        Integer option = 0;


        while (option != 7) {
            showOptions();
            try {

                option = Integer.parseInt(sc.nextLine());

                if (option != 7) {
                    System.out.print("Digite o valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    getConvertion(option, valor);
                } else if (option == 7) {

                    System.out.println("Saiu do programa");
                } else {

                    System.out.println("Saiu do programa");
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("Opção inválida");
            }
        }

    }

    public static void showOptions() {
        System.out.println("1) Dólar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real Brasileiro");
        System.out.println("4) Real Brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dólar");
        System.out.println("7) Sair");
    }

    public static void getConvertion(Integer option, Double valor) throws IOException {

        if (currencys == null) {
            currencys = ApiService.getCurrencyRates();
        }

        switch (option) {
            case 1 ->
                    System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>>> " + valor * currencys.get("ARS") + "[ARS]");
            case 2 ->
                    System.out.println("Valor " + valor + " [ARS] corresponde ao valor final de =>>> " + valor / currencys.get("ARS") + "[USD]");
            case 3 -> System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>>> " + valor * currencys.get("BRL")+ "[BRL]");
            case 4 -> System.out.println("Valor " + valor + " [BRL] corresponde ao valor final de =>>> " + valor / currencys.get("BRL")+ "[USD]");
            case 5 -> System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>>> " + valor * currencys.get("COP")+ "[COP]");
            case 6 -> System.out.println("Valor " + valor + " [COP] corresponde ao valor final de =>>> " + valor / currencys.get("COP")+ "[USD]");
            default -> System.out.println("opção inválida");

        }

    }


}

package br.com.coinconverter.controller;

import br.com.coinconverter.model.MoedasExchangeAPI;

import java.io.IOException;

public class ConversorDeMoedas {
    public Double taxaConversao;

    public Double converteValorMoeda(String siglaMoedaBase, String siglaMoedaAlvo, double valor) throws IOException, InterruptedException {
        MoedasExchangeAPI taxasConversaoMoeda = new BuscaValoresMoedas().buscaTaxasConversaoExchangeAPI(siglaMoedaBase);

        this.taxaConversao = Double.parseDouble(taxasConversaoMoeda.conversion_rates().get(siglaMoedaAlvo));

        return (this.taxaConversao * valor);
    }
}

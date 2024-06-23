package br.com.coinconverter.model;

import java.util.HashMap;
import java.util.Map;

public record MoedaExchangeAPI(String result, Map<String, String> conversion_rates = new HashMap<String, String>) {
}

package br.com.coinconverter.model;

import java.util.Map;

public record MoedasExchangeAPI(String result, Map<String, String> conversion_rates) {
}

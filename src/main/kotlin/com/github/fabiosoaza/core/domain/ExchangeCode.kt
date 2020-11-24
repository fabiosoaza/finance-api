package com.github.fabiosoaza.core.domain

enum class ExchangeCode(val exchangeCode: String, val exchangeName: String) {
    B3("B3", "B3 - Brasil Bolsa Balcão"),
    MERCADO_BITCOIN("MERCADO_BITCOIN", "Mercado Bitcoin");

    companion object {
        fun fromExchangeCode(code : String) : ExchangeCode? {
            return ExchangeCode.values().toList().filter{ exchange -> exchange.exchangeCode == code}.firstOrNull()
        }
    }

}
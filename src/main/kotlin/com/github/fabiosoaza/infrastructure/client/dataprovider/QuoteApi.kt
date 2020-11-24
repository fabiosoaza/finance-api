package com.github.fabiosoaza.infrastructure.client.dataprovider

import com.github.fabiosoaza.core.domain.Quote

interface QuoteApi{
    fun getByTickers(exchange: String, tickers : List<String>) : List<Quote>;
}
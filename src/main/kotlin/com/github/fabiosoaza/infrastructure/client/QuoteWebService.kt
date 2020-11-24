package com.github.fabiosoaza.infrastructure.client

import com.github.fabiosoaza.core.domain.Quote
import com.github.fabiosoaza.infrastructure.client.dataprovider.QuoteApi
import com.github.fabiosoaza.infrastructure.client.dataprovider.WebServiceDataProviderFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteWebService(@Inject val webServiceDataProviderFactory: WebServiceDataProviderFactory)  {

    fun getByTicker(exchange: String, ticker : String) : List<Quote>{
        return getByTickers(exchange, listOf(ticker));
    }

    fun getByTickers(exchange: String, tickers : List<String>) : List<Quote>{
        return api(exchange).getByTickers(exchange, tickers);
    }

    private fun api(exchange: String): QuoteApi {
        return webServiceDataProviderFactory.getByExchange(exchange)
    }
}
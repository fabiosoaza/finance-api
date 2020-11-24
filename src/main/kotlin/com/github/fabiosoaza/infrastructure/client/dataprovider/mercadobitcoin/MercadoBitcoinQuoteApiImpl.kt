package com.github.fabiosoaza.infrastructure.client.dataprovider.mercadobitcoin

import com.github.fabiosoaza.core.domain.ExchangeCode
import com.github.fabiosoaza.core.domain.Price
import com.github.fabiosoaza.core.domain.Quote
import com.github.fabiosoaza.infrastructure.client.dataprovider.QuoteApi
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MercadoBitcoinQuoteApiImpl(@Inject @RestClient @field: RestClient var  client: MercadoBitcoinApiClient) : QuoteApi {

    override fun getByTickers(exchange: String, tickers : List<String>) : List<Quote> {
        return tickers.map { ticker -> findByTicker(ticker) }.toList()
    }

    private fun findByTicker(ticker: String): Quote {
        val byTicker = this.client.getByTicker(ticker)
        return fromMap(ticker, byTicker["ticker"] as Map<String, Any>)
    }

    private fun fromMap(ticker: String, map: Map<String, Any>): Quote {
        return Quote(
                ticker = ticker,
                exchange = ExchangeCode.MERCADO_BITCOIN.exchangeCode,
                date = currentDateTime( (map["date"] as Int).toLong()),
                lastPrice = Price(currency = "BRL", amount = "${map["last"]}")
        )
    }

    private fun currentDateTime(dateTimeInEpochFormat: Long): ZonedDateTime {
        val zoneId = ZoneId.of("America/Sao_Paulo")
        val nowUtc = Instant.ofEpochSecond(dateTimeInEpochFormat)
        return ZonedDateTime.ofInstant(nowUtc, zoneId)
    }

}
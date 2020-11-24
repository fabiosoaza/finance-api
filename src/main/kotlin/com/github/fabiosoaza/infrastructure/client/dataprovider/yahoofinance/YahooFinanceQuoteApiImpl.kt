package com.github.fabiosoaza.infrastructure.client.dataprovider.yahoofinance

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
class YahooFinanceQuoteApiImpl(@Inject @RestClient @field: RestClient var  client: YahooFinanceApiClient) : QuoteApi {

    override fun getByTickers(exchange: String, tickers : List<String>) : List<Quote>{
        val byTickers = client.getByTickers(tickers(tickers))
        val resp = byTickers["quoteResponse"] as Map<*, *>
        val results = resp["result"] as List<Map<String, Any>>
        return results.map { res ->fromMap(res) }.toList()
    }

    private fun fromMap(map: Map<String, Any>): Quote {
        return Quote(
                ticker = (map["symbol"] as String).replace(".SA", ""),
                exchange = ExchangeCode.B3.exchangeCode,
                date = currentDateTime( (map["regularMarketTime"] as Int).toLong()),
                lastPrice = Price(currency = "BRL", amount = "${map["regularMarketPrice"]}")
        )
    }

    private fun tickers(tickers: List<String>) = tickers.map { ticker ->
        "${ticker}.SA"
    }.toList().joinToString(",")

    private fun currentDateTime(dateTimeInEpochFormat: Long): ZonedDateTime {
        val zoneId = ZoneId.of("America/Sao_Paulo")
        val nowUtc = Instant.ofEpochSecond(dateTimeInEpochFormat)
        return ZonedDateTime.ofInstant(nowUtc, zoneId)
    }

}
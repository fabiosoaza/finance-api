package com.github.fabiosoaza.infrastructure.client.dataprovider.bvmflegacy

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
class BVMFLegacyQuoteApiImpl(@Inject @RestClient @field: RestClient var  client: BVMFLegacyApiClient) : QuoteApi {

    override fun getByTickers(exchange: String, tickers : List<String>) : List<Quote>{
        val byTickers = client.getByTickers(tickers(tickers))
        return byTickers.map { map->
            fromMap(exchange)
        }.toList()
    }

    private fun fromMap(exchange: String): Quote {
        return Quote(
                ticker = "ticker",
                exchange = exchange,
                date = currentDateTime(),
                lastPrice = Price(currency = "BRL", amount = "25.24")
        )
    }

    private fun tickers(tickers: List<String>) = tickers.joinToString(",")

    private fun currentDateTime(): ZonedDateTime {
        val zoneId = ZoneId.of("America/Sao_Paulo")
        val nowUtc = Instant.now()
        return ZonedDateTime.ofInstant(nowUtc, zoneId)
    }

}
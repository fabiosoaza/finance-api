package com.github.fabiosoaza.infrastructure.client.dataprovider

import com.github.fabiosoaza.core.domain.ExchangeCode
import com.github.fabiosoaza.infrastructure.client.dataprovider.bvmflegacy.BVMFLegacyQuoteApiImpl
import com.github.fabiosoaza.infrastructure.client.dataprovider.mercadobitcoin.MercadoBitcoinQuoteApiImpl
import com.github.fabiosoaza.infrastructure.client.dataprovider.yahoofinance.YahooFinanceQuoteApiImpl
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebServiceDataProviderFactory(@Inject var  bvmfLegacyQuoteService: BVMFLegacyQuoteApiImpl, @Inject var  yahooFinanceService: YahooFinanceQuoteApiImpl,  @Inject var mercadoBitcoinQuoteApiImpl: MercadoBitcoinQuoteApiImpl ) {

    fun getByExchange(exchange: String) : QuoteApi {
        var map = mapOf<String, QuoteApi>(
                ExchangeCode.B3.exchangeCode to yahooFinanceService,
                ExchangeCode.MERCADO_BITCOIN.exchangeCode to mercadoBitcoinQuoteApiImpl
        )
        return map[exchange] ?: throw Exception("Exchange not available")
    }
}
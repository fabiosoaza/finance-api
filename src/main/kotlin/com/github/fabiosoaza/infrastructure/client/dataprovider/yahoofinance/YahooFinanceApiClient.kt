package com.github.fabiosoaza.infrastructure.client.dataprovider.yahoofinance

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.*


@RegisterRestClient(configKey = "external.api.yahoo-finance")
interface YahooFinanceApiClient  {
    @GET
    @Path("/quote")
    @Consumes("application/json")
    fun getByTickers(@QueryParam("symbols") tickersSeparatedByComma: String): Map<String, Any>
}
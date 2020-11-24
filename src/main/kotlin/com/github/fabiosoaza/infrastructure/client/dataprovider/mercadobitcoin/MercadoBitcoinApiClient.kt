package com.github.fabiosoaza.infrastructure.client.dataprovider.mercadobitcoin

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.*


@RegisterRestClient(configKey = "external.api.mercado-bitcoin")
interface MercadoBitcoinApiClient  {
    @GET
    @Path("/{ticker}/ticker")
    @Consumes("application/json")
    fun getByTicker(@PathParam("ticker") ticker: String): Map<String, Any>
}
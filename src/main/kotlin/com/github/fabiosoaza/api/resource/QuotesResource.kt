package com.github.fabiosoaza.api.resource

import com.github.fabiosoaza.core.domain.Quote
import com.github.fabiosoaza.infrastructure.client.QuoteWebService
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/api/v1/quotes")
class QuotesResource(@Inject var  quoteWebService: QuoteWebService) {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exchange/{exchange}/ticker/{ticker}")
    fun quote(@PathParam("exchange") exchange: String, @PathParam("ticker") ticker: String) : Quote {
        return quotes(exchange, ticker)[0]
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exchange/{exchange}/tickers/{tickers}")
    fun quotes(@PathParam("exchange") exchange: String, @PathParam("tickers") tickersSeparatedByComma: String) : List<Quote> {
        return quoteWebService.getByTickers(exchange, tickersSeparatedByComma.split(","))
    }

}
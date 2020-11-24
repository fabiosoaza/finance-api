package com.github.fabiosoaza.api.resource

import com.github.fabiosoaza.core.domain.Exchange
import com.github.fabiosoaza.core.domain.ExchangeCode
import org.slf4j.LoggerFactory
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/api/v1/exchanges")
class ExchangesResource() {

    var logger = LoggerFactory.getLogger(this.javaClass)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun quotes() : List<Exchange> {
        return ExchangeCode.values().map { exchange -> Exchange(exchange.exchangeCode, exchange.exchangeName) }.toList()
    }

}
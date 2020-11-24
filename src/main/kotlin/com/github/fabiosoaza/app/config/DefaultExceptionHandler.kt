package com.github.fabiosoaza.app.config

import org.slf4j.LoggerFactory
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class DefaultExceptionHandler : ExceptionMapper<Throwable> {

    var logger = LoggerFactory.getLogger(this.javaClass)

    override fun toResponse(exception: Throwable?): Response {
        logger.error("Caught and handled in the Global Exception handler", exception);
        return Response.serverError().entity("Error").build();
    }

}
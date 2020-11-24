package com.github.fabiosoaza.infrastructure.client.dataprovider.bvmflegacy

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam


@RegisterRestClient(configKey = "external.api.b3")
interface BVMFLegacyApiClient  {
    @GET
    @Path("FormConsultaCotacoes.asp")
    @Consumes("text/xml")
    fun getByTickers(@QueryParam("strListaCodigos") tickersSeparatedByComma: String): List<Map<String, Any>>
}
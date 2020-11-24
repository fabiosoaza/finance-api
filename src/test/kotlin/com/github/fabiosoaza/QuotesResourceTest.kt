package com.github.fabiosoaza

import com.github.fabiosoaza.infrastructure.client.QuoteWebService
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import javax.inject.Inject


@QuarkusTest
class QuotesResourceTest {

    @Inject
    var quoteWebServiceMock: QuoteWebService? = null

    companion object{
        @BeforeAll
        @JvmStatic
        fun beforeAll(){
           // val mock: QuoteWebService = Mockito.mock(QuoteWebService::class.java)

        }

    }





    @Test
    fun testHelloEndpoint() {
        /*given()
          .`when`().get("/api/v1/quotes/exchange/B3/ticker/BBDC4")
          .then()
             .statusCode(200)
             .body(`is`("hello"))*/
    }

}
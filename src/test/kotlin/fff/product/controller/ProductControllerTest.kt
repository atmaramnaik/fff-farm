package fff.product.controller

import fff.farm.view.SearchedProduct
import io.micronaut.core.type.Argument
import io.micronaut.data.model.Page
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class ProductControllerTest {
    @Inject
    var embeddedServer: EmbeddedServer? = null

    @Test
    @Throws(Exception::class)
    fun testIndex() {
        embeddedServer!!.applicationContext.createBean(RxHttpClient::class.java, embeddedServer!!.url).use {
            client ->
            val resp=client.toBlocking().exchange(HttpRequest.GET<Page<SearchedProduct>>("/product/search"), Argument.of(Page::class.java,SearchedProduct::class.java))
            Assertions.assertEquals(HttpStatus.OK, resp.status())
            val body=resp.body() as Page<SearchedProduct>
            Assertions.assertEquals(1,body.totalSize)
            Assertions.assertEquals("Tomato",body.content[0].name)
        }
    }
}
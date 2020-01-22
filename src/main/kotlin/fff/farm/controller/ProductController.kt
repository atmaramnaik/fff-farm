package fff.farm.controller

import fff.farm.model.Product
import fff.farm.repositories.ProductRepository
import fff.farm.view.SearchedProduct
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Produces

@Controller("/product")
class ProductController(private val productRepository: ProductRepository) {

    @Get(value = "/search")
    @Produces(value = [MediaType.APPLICATION_JSON])
    fun index(pageable: Pageable): Page<SearchedProduct> {
        productRepository.save(Product(id = null, name = "Tomato"))
        return productRepository.list(pageable)
//        return productRepository.findAll().map { SearchedProduct(it.name) }
    }
}
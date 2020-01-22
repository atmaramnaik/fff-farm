package fff.farm.repositories

import fff.farm.model.Product
import fff.farm.view.SearchedProduct
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import io.micronaut.data.repository.PageableRepository
import java.util.*

@JdbcRepository(dialect = Dialect.H2)
interface ProductRepository : PageableRepository<Product, UUID> {
    fun list(pageable: Pageable):Page<SearchedProduct>
//    override fun findAll(): List<Product>
}
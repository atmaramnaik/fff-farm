package fff.farm.model

import io.micronaut.data.annotation.AutoPopulated
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Product(
                    @Id
                    @AutoPopulated
                   var id:UUID?,
                   val name:String) {
}
package fff.product

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("fff.product")
                .mainClass(Application.javaClass)
                .start()
    }
}
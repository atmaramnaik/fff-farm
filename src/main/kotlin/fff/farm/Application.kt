package fff.farm

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("fff.farm")
                .mainClass(Application.javaClass)
                .start()
    }
}
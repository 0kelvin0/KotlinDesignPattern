import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

object NetworkDriver {
    init {
        println("Initializing: $this")
    }
    fun log(): NetworkDriver = apply { println("Network driver: $this") }
}
class NetworkDriverNonSingleton {
    init {
        println("Initializing: $this")
    }
    fun log(): NetworkDriverNonSingleton = apply { println("Network driver: $this") }
}

class SingletonTest {
    @Test
    fun testSingleton() {
        println("Start")
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()

        Assertions.assertThat(networkDriver1).isSameAs(NetworkDriver)
        Assertions.assertThat(networkDriver2).isSameAs(NetworkDriver)
    }

    @Test
    fun testNonSingleton() {
        println("Start")
        val networkDriverNon1 = NetworkDriverNonSingleton().log()
        val networkDriverNon2 = NetworkDriverNonSingleton().log()
    }
}
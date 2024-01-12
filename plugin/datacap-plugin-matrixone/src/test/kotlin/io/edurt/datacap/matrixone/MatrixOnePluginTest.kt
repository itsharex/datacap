package io.edurt.datacap.matrixone

import com.google.common.collect.Lists
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Key
import com.google.inject.TypeLiteral
import io.edurt.datacap.spi.Plugin
import io.edurt.datacap.spi.model.Configure
import io.edurt.datacap.spi.model.Response
import org.apache.commons.lang3.ObjectUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory.getLogger
import org.testcontainers.containers.Network
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.lifecycle.Startables
import org.testcontainers.shaded.org.awaitility.Awaitility.given
import java.util.*
import java.util.concurrent.TimeUnit

class MatrixOnePluginTest {
    private val log = getLogger(this.javaClass)
    private val host = "TestMatrixOneContainer"
    private val name = "MatrixOne"
    private var container: MatrixOneContainer? = null
    private var injector: Injector? = null
    private var configure: Configure? = null

    @Before
    fun before() {
        val network = Network.newNetwork()
        container = MatrixOneContainer()
                .withNetwork(network)
                .withNetworkAliases(host)
                .waitingFor(Wait.forListeningPort())
        container?.portBindings = Lists.newArrayList(String.format("%s:%s", MatrixOneContainer.PORT, MatrixOneContainer.DOCKER_PORT))
        Startables.deepStart(java.util.stream.Stream.of(container)).join()
        log.info("MatrixOne container started")
        given().ignoreExceptions()
                .await()
                .atMost(1, TimeUnit.MINUTES)

        injector = Guice.createInjector(MatrixOneModule())
        configure = Configure()
        configure !!.host = "127.0.0.1"
        configure !!.port = MatrixOneContainer.PORT
        configure !!.username = Optional.of("root")
        configure !!.password = Optional.of("111")
    }

    @Test
    fun test() {
        val plugins: Set<Plugin?>? = injector?.getInstance(Key.get(object : TypeLiteral<Set<Plugin?>?>() {}))
        val plugin: Plugin? = plugins?.first { v -> v?.name().equals(name) }
        if (ObjectUtils.isNotEmpty(plugin)) {
            plugin?.connect(configure)
            val response: Response = plugin !!.execute(plugin.validator())
            log.info("================ plugin executed information =================")
            if (! response.isSuccessful) {
                log.error("Message: {}", response.message)
            }
            else {
                response.columns.forEach { column -> log.info(column.toString()) }
            }
            Assert.assertTrue(response.isSuccessful)
        }
    }
}

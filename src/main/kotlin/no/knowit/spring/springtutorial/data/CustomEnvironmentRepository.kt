package no.knowit.spring.springtutorial.data

import org.springframework.cloud.config.server.environment.NativeEnvironmentProperties
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.stereotype.Repository
import java.io.File
import java.nio.file.Path

@Repository
open class CustomEnvironmentRepository(environment: ConfigurableEnvironment, properties: NativeEnvironmentProperties) : NativeEnvironmentRepository(environment, properties) {

    override fun setSearchLocations(vararg locations: String) {
            val root = getRoot(locations)
            val dirs = File(root).walk()
                    .filter { it.isDirectory }
                    .map { it.toString() }
                    .toList()
                    .toTypedArray()
            super.setSearchLocations(*dirs)
    }

    private fun getRoot(locations: Array<out String>) = Path.of(locations[0].substring(locations[0].indexOf(":") + 1)).toString()
}

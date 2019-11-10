package no.knowit.spring.springtutorial.data

import org.springframework.cloud.config.server.environment.NativeEnvironmentProperties
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.stereotype.Repository
import java.io.File
import java.io.IOException
import java.nio.file.Path

@Repository
open class CustomEnvironmentRepository(environment: ConfigurableEnvironment, properties: NativeEnvironmentProperties) : NativeEnvironmentRepository(environment, properties) {
    init {
        this.setSearchLocations(*properties.searchLocations)
    }

    override fun setSearchLocations(vararg locations: String) {
        try {
            val root = Path.of(locations[0].substring(locations[0].indexOf(":") + 1)).toString()
            val dirs = File(root).walk()
                    .filter { it.isDirectory }
                    .map { it.toString() }
                    .toList()
                    .toTypedArray()
            super.setSearchLocations(*dirs)

                    /*.filter { it.isDirectory }
                    .map { it.toString() }
                    .iterator()
            print(iterator)
            iterator.forEach { it ->
                print(it)
            }*/
            //val array = Array(200) { iterator.next() }
           // super.setSearchLocations(*array)
                    //.filter({it -> })
                    //.map<String>(Function<Path, String> { it.toString() })
                    //.toArray(String[]::new  /* Currently unsupported in Kotlin */))
        } catch (e: IOException) {
            throw RuntimeException(e)
        }

    }
}

package no.knowit.spring.springtutorial.data

import org.junit.jupiter.api.Test

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.cloud.config.server.environment.NativeEnvironmentProperties
import org.springframework.core.env.ConfigurableEnvironment

internal class CustomEnvironmentRepositoryTest {

    @Test
    fun setSearchLocations() {

        val nativeEnvironmentProperties = mock(NativeEnvironmentProperties::class.java)
        `when`(nativeEnvironmentProperties.searchLocations).thenReturn(arrayOf("file:///home/thomas/git/appconfig"))
        CustomEnvironmentRepository( mock(ConfigurableEnvironment::class.java), nativeEnvironmentProperties)
                .setSearchLocations("file:///home/thomas/git/appconfig")
    }
}
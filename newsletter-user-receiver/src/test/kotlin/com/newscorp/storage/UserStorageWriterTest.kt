package com.newscorp.storage

import com.google.cloud.storage.Storage
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper
import com.newscorp.Configuration
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserStorageWriterTest {

    @Test
    fun `writes content to storage`() {
        val storage: Storage = LocalStorageHelper.getOptions().service
        val configuration: Configuration = mockk()
        val storageConfigurationMock: Configuration.Storage = mockk()

        val userStorageWriter: UserStorageWriter = UserStorageWriter(storage, configuration)

        every { configuration.storage } returns storageConfigurationMock
        every { storageConfigurationMock.bucket } returns "user-updates"

        val filename = "storage_example.txt"
        val content = """
            {
                "email": "nano@gmail.com",
                "first_name": "Nano"
            }
        """.trimIndent()
        var blob = userStorageWriter.write(content, filename)

        assertThat(blob).isNotNull
        assertThat(blob.bucket).isEqualTo(configuration.storage.bucket)
        assertThat(blob.name).isEqualTo(filename)
    }
}
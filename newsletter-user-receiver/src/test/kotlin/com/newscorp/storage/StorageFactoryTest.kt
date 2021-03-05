package com.newscorp.storage

import com.newscorp.Configuration
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StorageFactoryTest {

    @Test
    fun `create a storage object`() {
        val conf: Configuration = mockk()
        val factory = StorageFactory()
        val projectId = "TestProject"

        every { conf.storage } returns mockk()
        every { conf.storage.projectId } returns projectId

        val storageService = factory.createStorage(conf)

        assertThat(storageService.options.projectId).isEqualTo(projectId)
    }
}
package com.newscorp.publisher

import com.newscorp.Configuration
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PublisherFactoryTest {
    @Test
    fun `creates a user update publisher`() {
        val publisherFactory: PublisherFactory = PublisherFactory()
        val config: Configuration = mockk()

        every { config.publisher } returns mockk()
        every { config.publisher.projectId } returns "testProjId"
        every { config.publisher.topic } returns "testTopic"

        val publisher = publisherFactory.createUserUpdatePublisher(config)

        assertThat(publisher.topicName.topic).isEqualTo(config.publisher.topic)
    }
}
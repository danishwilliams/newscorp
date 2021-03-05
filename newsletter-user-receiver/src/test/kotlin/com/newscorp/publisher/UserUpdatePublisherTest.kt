package com.newscorp.publisher

import com.google.cloud.pubsub.v1.Publisher
import com.google.pubsub.v1.PubsubMessage
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserUpdatePublisherTest {

    @Test
    fun `publishes the update file name to pub sub`() {
        val publisher: Publisher = mockk(relaxed = true)
        val message = slot<PubsubMessage>()

        val userUpdatePublisher = UserUpdatePublisher(publisher)

        every { publisher.publish(capture(message)) } answers { nothing }

        val filename = "randomfile.txt"
        userUpdatePublisher.publish(filename)

        verify(exactly = 1) { publisher.publish(any()) }
        assertThat(message.captured.data.toStringUtf8()).isEqualTo(filename)

    }
}
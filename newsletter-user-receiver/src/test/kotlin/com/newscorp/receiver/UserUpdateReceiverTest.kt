package com.newscorp.receiver

import com.google.cloud.pubsub.v1.AckReplyConsumer
import com.google.pubsub.v1.PubsubMessage
import com.newscorp.processor.UserMessageProcessor
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.lang.Exception

class UserUpdateReceiverTest {

    @Test
    fun `message is acked after processing is complete`() {

        val messageProcessor: UserMessageProcessor = mockk(relaxed = true)
        val userUpdateReceiver = UserUpdateReceiver(messageProcessor)
        val consumer: AckReplyConsumer = mockk(relaxed = true)
        val message: PubsubMessage = mockk(relaxed = true)

        userUpdateReceiver.receiveMessage(message, consumer)

        verify(exactly = 1) { messageProcessor.process(any()) }
        verify(exactly = 1) { consumer.ack() }
    }

    @Test
    fun `message should not be acked if processing throws an exception`() {
        val messageProcessor: UserMessageProcessor = mockk(relaxed = true)
        val userUpdateReceiver = UserUpdateReceiver(messageProcessor)
        val consumer: AckReplyConsumer = mockk(relaxed = true)
        val message: PubsubMessage = mockk(relaxed = true)

        every { messageProcessor.process(any()) } throws Exception()

        userUpdateReceiver.receiveMessage(message, consumer)

        verify(exactly = 1) { messageProcessor.process(any()) }
        verify(exactly = 0) { consumer.ack() }
    }

}
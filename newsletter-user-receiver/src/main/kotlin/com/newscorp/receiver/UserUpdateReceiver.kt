package com.newscorp.receiver

import com.google.cloud.pubsub.v1.AckReplyConsumer
import com.google.cloud.pubsub.v1.MessageReceiver
import com.google.pubsub.v1.PubsubMessage
import com.newscorp.processor.UserMessageProcessor
import java.lang.Exception
import javax.inject.Singleton

@Singleton
class UserUpdateReceiver(private val messageProcessor: UserMessageProcessor) : MessageReceiver {
    override fun receiveMessage(message: PubsubMessage, consumer: AckReplyConsumer) {

        try {
            messageProcessor.process(message.data.toStringUtf8())
            consumer.ack()
        }
        catch (ex: Exception) {

        }
    }

}

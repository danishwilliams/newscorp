package com.newscorp.publisher

import com.google.cloud.pubsub.v1.Publisher
import com.google.protobuf.ByteString
import com.google.pubsub.v1.PubsubMessage
import javax.inject.Singleton

@Singleton
class UserUpdatePublisher(private val publisher: Publisher) : MessagePublisher {
    override fun publish(filename: String) {
        val data = ByteString.copyFromUtf8(filename)
        val pubsubMessage = PubsubMessage.newBuilder()
            .setData(data)
            .build()

        publisher.publish(pubsubMessage)
    }

}

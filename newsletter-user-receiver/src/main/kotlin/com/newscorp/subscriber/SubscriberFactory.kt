package com.newscorp.subscriber

import com.google.cloud.pubsub.v1.MessageReceiver
import com.google.cloud.pubsub.v1.Subscriber
import com.google.pubsub.v1.ProjectSubscriptionName
import com.newscorp.Configuration
import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class SubscriberFactory {

    @Singleton
    fun createUserUpdateSubscriber(receiver: MessageReceiver, config: Configuration): Subscriber {
        with(config.pubsub) {
            val name = ProjectSubscriptionName.of(projectId, subscription)
            return Subscriber.newBuilder(name, receiver).build()
        }
    }

}

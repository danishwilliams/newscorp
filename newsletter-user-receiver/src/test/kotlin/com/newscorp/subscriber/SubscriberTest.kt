package com.newscorp.subscriber

import com.google.cloud.pubsub.v1.MessageReceiver
import com.google.cloud.pubsub.v1.Subscriber
import com.newscorp.Configuration
import com.newscorp.receiver.UserUpdateReceiver
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubscriberTest {
    @Test
    fun `create a user update subscriber`() {
        val receiver: MessageReceiver = mockk()
        val config:Configuration = mockk()

        val pubSub: Configuration.PubSub = mockk()
        every { config.pubsub } returns pubSub
        every { pubSub.projectId } returns "testProjId"
        every { pubSub.subscription } returns "testSubscription"

        val subscriberFactory: SubscriberFactory = SubscriberFactory()
        val subscriber: Subscriber = subscriberFactory.createUserUpdateSubscriber(receiver, config)

        assertThat(subscriber.subscriptionNameString).isNotNull
    }
}
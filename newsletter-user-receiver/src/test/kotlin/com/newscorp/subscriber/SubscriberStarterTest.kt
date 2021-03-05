package com.newscorp.subscriber

import com.google.cloud.pubsub.v1.Subscriber
import io.micronaut.runtime.server.event.ServerStartupEvent
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class SubscriberStarterTest {
    @Test
    fun `start the subscriber`() {
        val subscriber: Subscriber = mockk(relaxed = true)
        val subscriberStarter: SubscriberStarter = SubscriberStarter(subscriber)

        subscriberStarter.startSubscriber(mockk<ServerStartupEvent>())

        verify(exactly = 1) { subscriber.startAsync() }
    }
}
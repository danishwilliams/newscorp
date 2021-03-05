package com.newscorp

import io.micronaut.context.annotation.ConfigurationProperties
import javax.inject.Inject


@ConfigurationProperties("newsletter-user-receiver")
class Configuration() {

    @Inject
    internal var storage: Storage = Storage()

    @Inject
    internal var pubsub: PubSub = PubSub()

    @Inject
    internal var publisher: Publisher = Publisher()

    @ConfigurationProperties("storage")
    class Storage {
        lateinit var projectId: String
        lateinit var bucket: String
    }

    @ConfigurationProperties("pubsub")
    class PubSub {
        lateinit var projectId: String
        lateinit var subscription: String
    }

    @ConfigurationProperties("publisher")
    class Publisher {
        lateinit var projectId: String
        lateinit var topic: String
    }
}
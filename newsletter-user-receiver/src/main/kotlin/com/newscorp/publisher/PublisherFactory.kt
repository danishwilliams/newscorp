package com.newscorp.publisher

import com.google.cloud.pubsub.v1.Publisher
import com.google.pubsub.v1.ProjectTopicName
import com.newscorp.Configuration
import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class PublisherFactory {

    @Singleton
    fun createUserUpdatePublisher(config: Configuration): Publisher {
        val projTopicName = ProjectTopicName.of(config.publisher.projectId, config.publisher.topic)

        return Publisher.newBuilder(projTopicName).build()
    }

}

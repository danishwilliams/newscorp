package com.newscorp.processor

import com.newscorp.publisher.MessagePublisher
import com.newscorp.storage.MessageWriter
import javax.inject.Singleton

@Singleton
class UserMessageProcessor(
    private val publisher: MessagePublisher,
    private val messageWriter: MessageWriter,
    private val fileNameGenerator: FileNameGenerator
) {
    fun process(content: String) {

        val filename = fileNameGenerator.generateFileName()
        messageWriter.write(content, filename)
        publisher.publish(filename)
    }

}

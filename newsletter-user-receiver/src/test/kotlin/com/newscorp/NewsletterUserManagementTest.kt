package com.newscorp
import com.newscorp.processor.UserMessageProcessor
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class NewsletterUserManagementTest(private val messageProcessor: UserMessageProcessor) {

    @Test
    fun `should save contents to storage and publish file name`() {

    }
}

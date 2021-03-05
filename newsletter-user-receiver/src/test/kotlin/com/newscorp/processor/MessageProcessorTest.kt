package com.newscorp.processor

import com.newscorp.publisher.MessagePublisher
import com.newscorp.storage.MessageWriter
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test


class MessageProcessorTest {

    @Test
    fun `sends publisher update when saving to storage is complete`() {
        // Given
        val messageWriter: MessageWriter = mockk(relaxed = true)
        val publisher: MessagePublisher = mockk(relaxed = true)
        val fileNameGenerator: FileNameGenerator = mockk()
        val filename = "20210304-150501000.txt"


        every { fileNameGenerator.generateFileName() } returns filename

        val processor: UserMessageProcessor = UserMessageProcessor(publisher, messageWriter, fileNameGenerator)

        // When
        val content = """
            {
                "email": "nano@gmail.com",
                "first_name": "Nano"
            }
        """.trimIndent()
        processor.process(content)


        // Then
        verify(exactly = 1) { messageWriter.write(content, filename)  }
        verify(exactly = 1) { publisher.publish(filename)  }

    }
}
package com.newscorp.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileNameGeneratorTest {

    @Test
    fun `generates a unique filename`() {
        val generator = FileNameGenerator()

        val fileName1: String = generator.generateFileName()
        val fileName2: String = generator.generateFileName()

        assertThat(fileName1).isNotEqualTo(fileName2)
    }
}
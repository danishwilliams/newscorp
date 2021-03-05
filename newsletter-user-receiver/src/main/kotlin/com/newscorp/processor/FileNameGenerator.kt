package com.newscorp.processor

import java.util.*
import javax.inject.Singleton

@Singleton
class FileNameGenerator {
    fun generateFileName(): String {

        return "${UUID.randomUUID()}.txt"
    }

}

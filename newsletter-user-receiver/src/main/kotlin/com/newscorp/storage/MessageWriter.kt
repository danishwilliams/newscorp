package com.newscorp.storage

import com.google.cloud.storage.Blob

interface MessageWriter {

    fun write(content: String, filename: String): Blob
}

package com.newscorp.storage

import com.google.cloud.storage.Blob
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.newscorp.Configuration
import javax.inject.Singleton


@Singleton
class UserStorageWriter(private val storage: Storage, private val configuration: Configuration) : MessageWriter {

    override fun write(content: String, filename: String): Blob  {
        val blobInfo = BlobInfo.newBuilder(BlobId.of(configuration.storage.bucket, filename)).build()

        return storage.create(blobInfo, content.toByteArray())
    }

}

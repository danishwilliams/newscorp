package com.newscorp.storage

import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import com.newscorp.Configuration
import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class StorageFactory {
    @Singleton
    fun createStorage(config: Configuration): Storage {
        return StorageOptions.newBuilder().setProjectId(config.storage.projectId).build().service
    }
}

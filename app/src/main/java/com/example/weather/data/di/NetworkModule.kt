package com.example.weather.data.di

import com.example.weather.BuildConfig
import com.example.weather.data.network.KtorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            expectSuccess = true

            defaultRequest {
                url("https://api.openweathermap.org/")
                url.parameters.append("appid", BuildConfig.OPEN_WEATHER_API_KEY)
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }

            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }


    @Provides
    @Singleton
    fun provideKtorClient(client: HttpClient): KtorClient {
        return KtorClient(client)
    }
}
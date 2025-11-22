package com.example.weather.domain.di

import com.example.weather.domain.usecase.WeatherUseCase
import com.example.weather.domain.usecase.WeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    @Singleton
    fun bindWeatherUseCase(weatherUseCaseImpl: WeatherUseCaseImpl): WeatherUseCase
}

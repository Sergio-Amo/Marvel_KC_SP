package com.kc.marvel_kc_sp.di

import com.kc.marvel_kc_sp.Authentication
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceImpl
import com.kc.marvel_kc_sp.data.network.NetworkDataSourceInterface
import com.kc.marvel_kc_sp.data.network.api.MarvelApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkDataProvider {

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest = chain.request()
            val queryParams = Authentication.authenticationParams
            val url = originalRequest.url.newBuilder()
                //"apikey=$publicKey&ts=$timeStamp&hash=$hash"
                // THE API KEY MUST BE SET ON THE AUTHENTICATION FILE
                // CAN BE FOUND ON com.kc.marvel_kc_sp
                .addQueryParameter("apikey", queryParams.apikey)
                .addQueryParameter("ts", queryParams.timeStamp)
                .addQueryParameter("hash", queryParams.hash)
                .build()

            val newRequest =
                originalRequest.newBuilder()
                    .url(url)
                    .build()
            chain.proceed(newRequest)
        }.build()
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(MarvelApi.base)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }


    @Provides
    fun provideNetworkDataSource(networkDataSourceImpl: NetworkDataSourceImpl): NetworkDataSourceInterface {
        return networkDataSourceImpl
    }
}

package com.lomu.netflix.di

import android.content.Context
import androidx.room.Room
import com.lomu.room.NetflixDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
        appDatabase: Class<NetflixDatabase>,
        @Named("database_name") databaseName: String,
    ): NetflixDatabase {

        return synchronized(this) {
            Room.databaseBuilder(
                context = context,
                klass = appDatabase,
                name = databaseName
            ).build()
        }
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): Class<NetflixDatabase> {

        return NetflixDatabase::class.java
    }

    @Provides
    @Singleton
    @Named("database_name")
    fun provideDatabaseName(): String{

        return "netflix_database"
    }

}
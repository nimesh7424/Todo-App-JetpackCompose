package com.nimesh.todoappjetpackcompose.di

import android.app.Application
import androidx.room.Room
import com.nimesh.todoappjetpackcompose.data.TodoDatabase
import com.nimesh.todoappjetpackcompose.data.TodoRepository
import com.nimesh.todoappjetpackcompose.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }

}
package com.enzo.mvvmtodo.data.di

import android.app.Application
import androidx.room.Room
import com.enzo.mvvmtodo.data.Todo
import com.enzo.mvvmtodo.data.TodoDatabase
import com.enzo.mvvmtodo.data.TodoRepository
import com.enzo.mvvmtodo.data.TodoRepositoryImpl
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
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}
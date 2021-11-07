package com.example.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.utils.DataConstants
import com.example.domain.models.ImageDbModel


@Database(entities = [ImageDbModel::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideImageDao():ImageDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DataConstants.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}
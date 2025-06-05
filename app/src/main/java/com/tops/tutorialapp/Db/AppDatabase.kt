package com.tops.tutorialapp.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tops.tutorialapp.Dao.UserDao
import com.tops.tutorialapp.entities.User

@Database(entities =  [User::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun  userDao(): UserDao
}
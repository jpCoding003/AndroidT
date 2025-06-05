package com.tops.tutorialapp.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tops.tutorialapp.entities.User


@Dao
interface UserDao {



        @Insert
        fun insertAll(vararg users: User.User)

        @Query("SELECT * FROM user")
        fun getAll(): List<User>
        

}
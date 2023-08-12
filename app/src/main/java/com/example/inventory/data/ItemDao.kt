package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}

/**
 * Insert data with SQL.
 *
 * INSERT INTO item (id, name, price, quantity) VALUES (1, 'Apple', 0.75, 50),
 * (2, 'Banana', 0.50, 75),
 * (3, 'Orange', 0.60, 60),
 * (4, 'Grapes', 1.20, 40),
 * (5, 'Strawberry', 0.30, 100),
 * (6, 'Mango', 1.50, 30),
 * (7, 'Pineapple', 1.20, 25),
 * (8, 'Watermelon', 2.00, 15),
 * (9, 'Kiwi', 0.80, 50),
 * (10, 'Peach', 0.90, 45),
 * (11, 'Pear', 0.70, 55),
 * (12, 'Cherry', 0.50, 70),
 * (13, 'Blueberry', 0.40, 90),
 * (14, 'Raspberry', 0.60, 65),
 * (15, 'Blackberry', 0.55, 80),
 * (16, 'Lemon', 0.45, 95),
 * (17, 'Lime', 0.40, 85),
 * (18, 'Cantaloupe', 1.75, 20),
 * (19, 'Honeydew', 1.60, 18),
 * (20, 'Dragon fruit', 2.50, 10);
 *
 */

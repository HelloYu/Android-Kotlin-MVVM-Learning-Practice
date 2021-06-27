/*
 * MIT License
 *
 * Copyright (c) 2021 Alan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * File Name: TodoListDao.kt
 * Project: Android-MVVM-Practice
 * Module: Android-MVVM-Practice.app
 * Author: Alan
 * Author URI: https://www.seozen.top
 * Email: Mr.Yu1991@gmail.com
 * Current Modification Date: 6/27/21 10:11 PM
 * Last Modified Date: 6/27/21 7:18 PM
 */

package com.cxtech.android_mvvm_practice

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoListDao {
    @Query("SELECT * FROM todo_list")
    fun getAll(): LiveData<List<TodoItemEntity>>

    @Query("SELECT * FROM todo_list WHERE title IN (:title)")
    fun loadAllByTitles(title: List<String>): LiveData<List<TodoItemEntity>>

    @Insert
    suspend fun insert(todoItemEntity: TodoItemEntity)

    @Delete
    fun delete(todoItemEntity: TodoItemEntity)

    @Update
    fun update(todoItemEntity: TodoItemEntity)
}
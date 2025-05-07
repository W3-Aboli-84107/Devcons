package com.example.emp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.emp.Visitor;

import java.util.List;

@Dao
public interface VisitorDao {

    @Insert
    void insert(Visitor visitor);

    @Query("SELECT * FROM Visitor_table")
    List<Visitor> getAllVisitors();

    @Query("DELETE FROM Visitor_table")
    void deleteAll();
}

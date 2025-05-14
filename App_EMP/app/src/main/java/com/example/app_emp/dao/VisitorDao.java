package com.example.app_emp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.app_emp.model.Visitor;
import java.util.List;

@Dao
public interface VisitorDao {

    @Insert
    void insertVisitor(Visitor visitor);

    @Query("SELECT * FROM visitors ORDER BY id DESC")
    List<Visitor> getAllVisitors();

    @Query("SELECT * FROM visitors WHERE id = :id")
    Visitor getVisitorById(int id);
}

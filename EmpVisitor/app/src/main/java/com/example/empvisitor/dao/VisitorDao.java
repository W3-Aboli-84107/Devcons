////package com.example.empvisitor.dao;
////
////import androidx.lifecycle.LiveData;
////import androidx.room.Dao;
////import androidx.room.Insert;
////import androidx.room.Query;
////import androidx.room.Update;
////import androidx.room.Delete;
////
////import com.example.empvisitor.model.Visitor;
////
////import java.util.List;
////
////@Dao
////public interface VisitorDao {
////
////    // Insert a new visitor
////    @Insert
////    void insertVisitor(Visitor visitor);
////
////    // Update an existing visitor
////    @Update
////    void updateVisitor(Visitor visitor);
////
////    // Delete a specific visitor
////    @Delete
////    void deleteVisitor(Visitor visitor);
////
////    // Get all visitors, ordered by newest first
////    @Query("SELECT * FROM visitors ORDER BY id DESC")
////    LiveData<List<Visitor>> getAllVisitors();
////
////    // Get a specific visitor by ID
////    @Query("SELECT * FROM visitors WHERE id = :id LIMIT 1")
////    LiveData<Visitor> getVisitorById(int id);
////
////    // Delete all visitors
////    @Query("DELETE FROM visitors")
////    void deleteAllVisitors();
////}
//
//package com.example.empvisitor.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.example.empvisitor.model.Visitor;
//
//import java.util.List;
//
//@Dao
//public interface VisitorDao {
//
//    @Insert
//    void insertVisitor(Visitor visitor);
//
//    @Update
//    void updateVisitor(Visitor visitor);
//
//    @Delete
//    void deleteVisitor(Visitor visitor);
//
//    @Query("SELECT * FROM visitors ORDER BY id DESC")
//    List<Visitor> getAllVisitors();
//}

package com.example.empvisitor.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.empvisitor.model.Visitor;

import java.util.List;

@Dao
public interface VisitorDao {

    @Insert
    void insert(Visitor visitor);

    @Update
    void update(Visitor visitor);

    @Delete
    void delete(Visitor visitor);

    @Query("SELECT * FROM visitor_table")
    List<Visitor> getAllVisitors();
}

package com.example.mydoctor.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiseasesDao {

    @Query("SELECT name FROM diseases WHERE symptoms LIKE '%' || :symptom || '%'")
    List<String> diseaseDiagnosis(String symptom);

    @Query("SELECT precautions FROM diseases WHERE symptoms LIKE '%' || :symptom || '%'")
    List<String> prescription(String symptom);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Diseases diseases);
}

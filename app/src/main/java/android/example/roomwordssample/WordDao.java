package android.example.roomwordssample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {

    // insère un mot
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    // supprime tous les mots
    @Query("DELETE FROM word_table")
    void deleteAll();

    // supprime un mot
    @Delete
    void deleteWord(Word word);

    // requête qui obtient tous les mots du word_table, triés par ordre alphabétique
    // liveData écoute tous changements de données
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    // requête pour obtenir un seul mot
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();

    @Update
    void update(Word... word);
}

package zc.xtyz.spring.db.interfaces;

import zc.xtyz.spring.db.objects.MP3;

import java.util.List;

public interface MP3DAO {

    void insert(MP3 mp3);

    void delete(int id);

    MP3 getMP3ByID(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMP3ListByAuthor(String author);
}

package zc.xtyz.spring.db.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import zc.xtyz.spring.db.interfaces.MP3DAO;
import zc.xtyz.spring.db.objects.MP3;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
@Component("sqlLite")

public class SQLLite implements MP3DAO{
 private JdbcTemplate jdbcTemplate;
 @Autowired
 public void setDataSource(DataSource dataSource){
     this.jdbcTemplate = new JdbcTemplate(dataSource);
 }



    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[]{ mp3.getName(),mp3.getAuthor()});
    }
    public void insert (List<MP3> mp3List){
        String sql = "insert into mp3 (name, author) VALUES (?,?)";
        Iterator<MP3> iterator = mp3List.iterator();
        while (iterator.hasNext()){
            MP3 mp3 = iterator.next();
            jdbcTemplate.update(sql,new Object[]{ mp3.getName(),mp3.getAuthor()});
        }

        }


    public void delete(int id) {
        String sql = "DELETE FROM mp3 WHERE (rowid)= (2)";
        jdbcTemplate.update(sql,id);
    }

    public MP3 getMP3ByID(int id) {
        String sql = "SELECT * FROM MP3 WHERE (rowid) =3";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, new MP3RowMapper());
    }


    public List<MP3> getMP3ListByName(String name) {
        String sql = "select * from mp3 where upper(name) like :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", "%" + name.toUpperCase() + "%");

//      return jdbcTemplate.query(sql, params, new MP3RowMapper());
        return null;
    }

    @Override
    public List<MP3> getMP3ListByAuthor(String author) {
        return null;
    }

    public static final class MP3RowMapper implements RowMapper<MP3>{
     public MP3 mapRow(ResultSet rs, int rowNum) throws SQLException{
         MP3 mp3 = new MP3();
         mp3.setName(rs.getString("author"));
         mp3.setAuthor(rs.getString("name"));
         return mp3;
     }


    }
}

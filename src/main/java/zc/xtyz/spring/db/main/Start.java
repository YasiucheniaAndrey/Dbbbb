package zc.xtyz.spring.db.main;

/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zc.xtyz.spring.db.implementation.SQLLite;
import zc.xtyz.spring.db.objects.MP3;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main (String[] args){
        *//*MP3 mp3 = new MP3();
        mp3.setName("Димка Билан");
        mp3.setAuthor("Не могу жить без тебя");*//*
        *//*ArrayList<MP3> mp3list = new ArrayList();
        for (Integer i = 0; i <=5; i++){
            MP3 mp33 = new MP3();
            mp33.setName(i.toString());
            mp33.setAuthor(i.toString());
            mp3list.add(mp33);
        }*//*

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLLite sqlLite = (SQLLite)context.getBean("sqlLite");
        *//*sqlLite.insert(mp3list);*//*
        MP3 mp3 = sqlLite.getMP3ByID(2);
        System.out.println(mp3.getAuthor() + "  "+ mp3.getName());
        System.out.println(sqlLite.getMP3ListByAuthor("Ivan"));

    }
}*/

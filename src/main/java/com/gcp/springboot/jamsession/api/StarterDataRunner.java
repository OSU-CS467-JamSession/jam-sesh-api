package com.gcp.springboot.jamsession.api;

import java.time.LocalDate;
import java.util.*;

import com.gcp.springboot.jamsession.api.genre.Genre;
import com.gcp.springboot.jamsession.api.genre.GenreRepository;
import com.gcp.springboot.jamsession.api.instrument.Instrument;
import com.gcp.springboot.jamsession.api.instrument.InstrumentRepository;
import com.gcp.springboot.jamsession.api.login.Login;
import com.gcp.springboot.jamsession.api.login.LoginRepository;
import com.gcp.springboot.jamsession.api.session.Session;
import com.gcp.springboot.jamsession.api.session.SessionRepository;
import com.gcp.springboot.jamsession.api.user.User;
import com.gcp.springboot.jamsession.api.user.UserRepository;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
// only runs when "create" property is enabled
@ConditionalOnProperty(
        name = {"spring.jpa.hibernate.dll-auto"},
        havingValue = "create")
public class StarterDataRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepo;

    @Autowired
    InstrumentRepository instrumentRepo;
    
    @Autowired
    GenreRepository genreRepo;

    @Autowired
    SessionRepository sessionRepo;

    @Override
    public void run(String... args) throws Exception {
        // ---------------- Users (part 1) ------------------
        User user1 = new User("marcos1994@yahoo.com",
                "Robert", "Scott", null,
                04101, "Portland", "ME",
                3);
        User user2 = new User("kaylah2004@hotmail.com",
                "Danielle", "Randall", null,
                94041, "Mountain View", "CA",
                1);
        User user3 = new User("elva1988@gmail.com",
                "Meggan", "Smith", null,
                32096, "Titusville", "FL",
                5);
        User user4 = new User("solon1997@hotmail.com",
                "Lisa", "Desrochers", null,
                33614, "Tampa", "FL",
                2);

        // ---------------- Logins ------------------
        Login login1 = new Login("2023-02-07", false, null, "p1assword");
        Login login2 = new Login("2023-02-08", false, null, "p2assword");
        Login login3 = new Login("2023-02-08", false, null, "p3assword");
        Login login4 = new Login("2023-02-10", false, null, "p4assword");
        // Assign login to user
        user1.setLogin(login1);
        user2.setLogin(login2);
        user3.setLogin(login3);
        user4.setLogin(login4);
        // Assign user to login
        login1.setUser(user1);
        login2.setUser(user2);
        login3.setUser(user3);
        login4.setUser(user4);
        // Logins are saved when users are saved automatically

        // --------------- Instruments -------------------
        // Create instruments for assigning to users
        Instrument instrument1 = new Instrument("Violin", "Strings");
        Instrument instrument2 = new Instrument("Guitar", "Strings");
        Instrument instrument3 = new Instrument ("Drums", "Percussion");
        Instrument instrument4 = new Instrument ("Piano", "Keyboard");
        Instrument instrument5 = new Instrument ("Trumpet", "Brass/Wind");
        // Assign instruments to users
        user1.getInstruments().add(instrument1);
        user1.getInstruments().add(instrument2);
        user1.getInstruments().add(instrument5);
        user2.getInstruments().add(instrument1);
        user3.getInstruments().add(instrument1);
        user4.getInstruments().add(instrument3);
        user4.getInstruments().add(instrument4);
        // Assign users to instruments
        instrument1.getUsers().add(user1);
        instrument2.getUsers().add(user1);
        instrument5.getUsers().add(user1);
        instrument1.getUsers().add(user2);
        instrument1.getUsers().add(user3);
        instrument3.getUsers().add(user4);
        instrument4.getUsers().add(user4);
        // Save instruments
        System.out.println("-------- Creating instruments --------");
        instrumentRepo.save(instrument1);
        instrumentRepo.save(instrument2);
        instrumentRepo.save(instrument3);
        instrumentRepo.save(instrument4);
        instrumentRepo.save(instrument5);
        // Create and save additional instruments
        instrumentRepo.saveAll(Arrays.asList(
            new Instrument ("Cello", "Strings"),
            new Instrument ("Harp", "Strings"),
            new Instrument ("Veena", "Strings"),
            new Instrument ("Sitar", "Strings"),
            new Instrument ("Viola", "Strings"),
            new Instrument ("Mandolin", "Strings"),
            new Instrument ("Banjo", "Strings"),
            new Instrument ("Ukulele", "Strings"),
            new Instrument ("Lute", "Strings"),
            new Instrument ("Mridangam", "Percussion"),
            new Instrument ("Tabla", "Percussion"),
            new Instrument ("Xylophone", "Percussion"),
            new Instrument ("Snare drum", "Percussion"),
            new Instrument ("Cymbal", "Percussion"),
            new Instrument ("Triangle", "Percussion"),
            new Instrument ("Bass drum", "Percussion"),
            new Instrument ("Maracas", "Percussion"),
            new Instrument ("Chimes", "Percussion"),
            new Instrument ("Tambourine", "Percussion"),
            new Instrument ("Timpani", "Percussion"),
            new Instrument ("Marimba", "Percussion"),
            new Instrument ("Harmonium", "Keyboard"),
            new Instrument ("Celeste", "Keyboard"),
            new Instrument ("Pipe organ", "Keyboard"),
            new Instrument ("Accordion", "Keyboard"),
            new Instrument ("Claviola", "Keyboard"),
            new Instrument ("Harpsichord", "Keyboard"),
            new Instrument ("Organ", "Keyboard"),
            new Instrument ("Synthesiser", "Keyboard"),
            new Instrument ("Harmonica", "Keyboard"),
            new Instrument ("Flute", "Brass/Wind"),
            new Instrument ("Saxophone", "Brass/Wind"),
            new Instrument ("Mouth organ", "Brass/Wind"),
            new Instrument ("Piccolo", "Brass/Wind"),
            new Instrument ("Trombone", "Brass/Wind"),
            new Instrument ("French horn", "Brass/Wind"),
            new Instrument ("Tuba", "Brass/Wind"),
            new Instrument ("Euphonium", "Brass/Wind"),
            new Instrument ("Cornet", "Brass/Wind"),
            new Instrument ("Oboe", "Brass/Wind"),
            new Instrument ("Clarinet", "Brass/Wind"),
            new Instrument ("Bassoon", "Brass/Wind")
        ));

        // --------------- Genres -------------------
        // Create genres for assigning to users
        Genre genre1 = new Genre("Hip hop");
        Genre genre2 = new Genre("Country");
        Genre genre3 = new Genre("Rock");
        Genre genre4 = new Genre("Classical");
        // Assign genres to users
        user1.getGenres().add(genre1);
        user1.getGenres().add(genre2);
        user1.getGenres().add(genre3);
        user2.getGenres().add(genre3);
        user2.getGenres().add(genre4);
        user3.getGenres().add(genre1);
        user4.getGenres().add(genre1);
        // Assign users to genres
        genre1.getUsers().add(user1);
        genre2.getUsers().add(user1);
        genre3.getUsers().add(user1);
        genre3.getUsers().add(user2);
        genre4.getUsers().add(user2);
        genre1.getUsers().add(user3);
        genre1.getUsers().add(user4);
        // Save genres
        System.out.println("-------------- Creating genres ---------------");
        genreRepo.save(genre1);
        genreRepo.save(genre2);
        genreRepo.save(genre3);
        genreRepo.save(genre4);
        // Create and save additional genres
        genreRepo.saveAll(Arrays.asList(
            new Genre("Blues"),
            new Genre("Electronic"),
            new Genre("Folk"),
            new Genre("Jazz"),
            new Genre("Pop"),
            new Genre("R&B"),
            new Genre("Metal"),
            new Genre("Punk"),
            new Genre("African"),
            new Genre("Asian"),
            new Genre("Middle Eastern"),
            new Genre("Caribbean"),
            new Genre("Latin")
        ));

        // ----------- Users (part 2) --------------
        // Saves user to database with relevant login, instrument(s), etc.
        System.out.println("------ Creating users and logins ----------------");
        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);

        // ----------------- Sessions ----------------
        Session session1 = new Session("Rock n roll meetup");
        Session session2 = new Session("Jazz lessons from a pro");
        Session session3 = new Session("Midwest emo creative sesh");
        Session session4 = new Session("Let's just chill and listen to music");
        Session session5 = new Session("Classical music concert");
        Session session6 = new Session("Looking for a drummer");

        // Assign users to sessions
        session1.setUser(user1);
        session2.setUser(user1);
        session3.setUser(user1);
        session4.setUser(user2);
        session5.setUser(user3);
        session6.setUser(user4);

        // Save sessions
        System.out.println("------------- Creating sessions -----------");
        sessionRepo.saveAll(Arrays.asList(session1, session2, session3, session4, session5, session6));
    }
}
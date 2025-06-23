package hangman.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GAME", schema = "BERDOTT")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "BERDOTT.GAME_SEQ", allocationSize = 1)
    @Column(name = "IDGA", nullable = false)
    private Long idga;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "WORD", nullable = false)
    private String word;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "DATECRE", nullable = false)
    private Timestamp dateCre;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AttemptEntity> attempts = new ArrayList<>();

    // Getters and setters
    public Long getIdga() {
        return idga;
    }

    public void setIdga(Long idga) {
        this.idga = idga;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateCre() {
        return dateCre;
    }

    public void setDateCre(Timestamp dateCre) {
        this.dateCre = dateCre;
    }

    public List<AttemptEntity> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<AttemptEntity> attempts) {
        this.attempts = attempts;
    }
}
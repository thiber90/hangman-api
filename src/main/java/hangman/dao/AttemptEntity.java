package hangman.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "ATTEMPT")
public class AttemptEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL AUTO_INCREMENT
    @Column(name = "IDAT", nullable = false)
    private Long idat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDGA", nullable = false)
    @JsonBackReference
    private GameEntity game;

    @Column(name = "LETTER", nullable = false)
    private String letter;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "DATECRE", nullable = false)
    private Timestamp dateCre;

    // Getters and setters
    public Long getIdat() {
        return idat;
    }

    public void setIdat(Long idat) {
        this.idat = idat;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
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
}

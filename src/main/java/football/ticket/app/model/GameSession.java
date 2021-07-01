package football.ticket.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Game game;
    @ManyToOne
    private Stadium stadium;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getMovie() {
        return game;
    }

    public void setMovie(Game game) {
        this.game = game;
    }

    public Stadium getCinemaHall() {
        return stadium;
    }

    public void setCinemaHall(Stadium stadium) {
        this.stadium = stadium;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSession{"
                + "id=" + id
                + ", movie=" + game
                + ", cinemaHall=" + stadium
                + ", showTime=" + showTime + '}';
    }
}

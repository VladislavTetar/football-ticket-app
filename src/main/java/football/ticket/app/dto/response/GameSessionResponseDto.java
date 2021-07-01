package football.ticket.app.dto.response;

public class GameSessionResponseDto {
    private Long gameSessionId;
    private Long gameId;
    private String gameTitle;
    private Long stadiumId;
    private String showTime;

    public Long getMovieSessionId() {
        return gameSessionId;
    }

    public void setMovieSessionId(Long movieSessionId) {
        this.gameSessionId = movieSessionId;
    }

    public Long getMovieId() {
        return gameId;
    }

    public void setMovieId(Long movieId) {
        this.gameId = movieId;
    }

    public String getMovieTitle() {
        return gameTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.gameTitle = movieTitle;
    }

    public Long getCinemaHallId() {
        return stadiumId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.stadiumId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}

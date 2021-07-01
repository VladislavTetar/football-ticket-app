package football.ticket.app.dto.response;

public class GameResponseDto {
    private Long gameId;
    private String gameTitle;
    private String gameDescription;

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

    public String getMovieDescription() {
        return gameDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.gameDescription = movieDescription;
    }
}

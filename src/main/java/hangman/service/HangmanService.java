package hangman.service;



import hangman.dao.AttemptEntity;
import hangman.dao.GameEntity;

import java.util.List;
import java.util.Optional;

public interface HangmanService {
    GameEntity createGame(GameEntity game);
    Optional<GameEntity> getGameById(Long id);
    Optional<GameEntity> getGameByName(String name);
    List<GameEntity> getAllGames();
    GameEntity updateGame(GameEntity game);
    void deleteGame(Long id);

    AttemptEntity createAttempt(Long gameId, AttemptEntity attempt);
    List<AttemptEntity> getAttemptsByGameName(String  gameName);
}
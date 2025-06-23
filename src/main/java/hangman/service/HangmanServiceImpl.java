package hangman.service;



import hangman.dao.AttemptEntity;
import hangman.dao.AttemptRepository;
import hangman.dao.GameEntity;
import hangman.dao.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangmanServiceImpl implements HangmanService {

    private final GameRepository gameRepository;
    private final AttemptRepository attemptRepository;

    @Autowired
    public HangmanServiceImpl(GameRepository gameRepository, AttemptRepository attemptRepository) {
        this.gameRepository = gameRepository;
        this.attemptRepository = attemptRepository;
    }

    @Override
    public GameEntity createGame(GameEntity game) {
        return gameRepository.save(game);
    }

    @Override
    public Optional<GameEntity> getGameById(Long id) {
        return gameRepository.findByIdga(id);
    }

    @Override
    public Optional<GameEntity> getGameByName(String name) {
        return gameRepository.findByName(name);
    }

    @Override
    public List<GameEntity> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public GameEntity updateGame(GameEntity game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public AttemptEntity createAttempt(Long gameId, AttemptEntity attempt) {
        Optional<GameEntity> gameOptional = gameRepository.findByIdga(gameId);
        if (gameOptional.isPresent()) {
            attempt.setGame(gameOptional.get());
            return attemptRepository.save(attempt);
        } else {
            throw new RuntimeException("Game not found with id: " + gameId);
        }
    }

    @Override
    public List<AttemptEntity> getAttemptsByGameName(String gameName) {
        return attemptRepository.findAttemptsByGameName(gameName);
    }
}
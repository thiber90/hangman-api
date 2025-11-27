package hangman.resource;


import hangman.dao.AttemptEntity;
import hangman.dao.GameEntity;
import hangman.service.HangmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class HangmanController {

    private final HangmanService gameService;

    @Autowired
    public HangmanController(HangmanService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameEntity> createGame(@RequestBody GameEntity game) {
        GameEntity createdGame = gameService.createGame(game);
        return ResponseEntity.ok(createdGame);
    }

    @GetMapping("/{name}")
    public ResponseEntity<GameEntity> getGameByName(@PathVariable String name) {
        Optional<GameEntity> game = gameService.getGameByName(name);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GameEntity>> getAllGames() {
        List<GameEntity> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameEntity> updateGame(@PathVariable Long id, @RequestBody GameEntity game) {
        game.setIdga(id); // Ensure the ID is set to the path variable
        GameEntity updatedGame = gameService.updateGame(game);
        return ResponseEntity.ok(updatedGame);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{gameId}/attempts")
    public ResponseEntity<AttemptEntity> createAttempt(@PathVariable Long gameId, @RequestBody AttemptEntity attempt) {
        AttemptEntity createdAttempt = gameService.createAttempt(gameId, attempt);
        return ResponseEntity.ok(createdAttempt);
    }

    @GetMapping("/attempts")
    public ResponseEntity<List<AttemptEntity>> getAttemptsByGameName(@RequestParam String gameName) {
        List<AttemptEntity> attempts = gameService.getAttemptsByGameName(gameName);
        return ResponseEntity.ok(attempts);
    }
}

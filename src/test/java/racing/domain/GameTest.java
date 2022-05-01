package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.exception.GameException;

class GameTest {

    @DisplayName("경기용 차가 N대 준비된다.")
    @Test
    void numberOfCars() {
        final List<String> namesOfCars = getDefaultNamesOfCars();
        final Game game = new Game(NumberOfRound.of(5), getDefaultRule(), namesOfCars);

        assertThat(game.getCars().numberOfCars()).isEqualTo(namesOfCars.size());
    }

    @DisplayName("경기를 N번 진행한다.")
    @Test
    void proceedRound() {
        final Game game = new Game(NumberOfRound.of(5), getDefaultRule(), getDefaultNamesOfCars());

        int count = 0;
        while (game.isLeftRound()) {
            game.proceedRound();
            count++;
        }

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("경기를 진행하면 라운드 수가 1 감소된다.")
    @Test
    void proceedRound_decrease() {
        final Game game = new Game(NumberOfRound.of(1), getDefaultRule(), getDefaultNamesOfCars());

        game.proceedRound();

        assertThat(game.isLeftRound()).isFalse();
    }

    @DisplayName("라운드가 남아있으면 경기를 진행한다.")
    @Test
    void is_left_round() {
        final Game game = new Game(NumberOfRound.of(1), getDefaultRule(), getDefaultNamesOfCars());

        game.proceedRound();
    }

    @DisplayName("라운드가 남아있지 않으면 경기를 진행하지 않는다. exception 발생")
    @Test
    void is_not_left_round() {
        final Game game = new Game(NumberOfRound.of(0), getDefaultRule(), getDefaultNamesOfCars());

        assertThatThrownBy(game::proceedRound)
                .isInstanceOf(GameException.class)
                .hasMessageContaining("종료");
    }

    GameRule getDefaultRule() {
        return () -> true;
    }

    List<String> getDefaultNamesOfCars() {
        return Arrays.asList("solar", "holar", "cola");
    }
}

package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.NumberOfRound;
import racing.domain.RandomGameRule;
import racing.domain.GameRule;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Stadium {

    public static void main(String[] args) {
        final List<String> nameOfCars = InputView.inputNameOfCars();
        final NumberOfRound numberOfRound = InputView.inputNumberOfRound();
        final GameRule gameRule = new RandomGameRule();

        Game game = new Game(numberOfRound, gameRule, nameOfCars);
        final List<Car> cars = game.getCars();
        while (game.isLeftRound()) {
            game.proceedRound();
            ResultView.print(cars);
        }

        ResultView.printWinner(game.findWinner());
    }
}

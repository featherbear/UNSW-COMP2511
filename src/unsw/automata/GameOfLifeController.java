package unsw.automata;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GameOfLifeController {

	private GameOfLife game;

	@FXML
	private GridPane grid;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnTick;

	@FXML
	void handlePlayButton(MouseEvent event) {

	}

	@FXML
	void handleTickButton(MouseEvent event) {
		game.tick();
	}

	@FXML
	void initialize() {
		game = new GameOfLife();
		int dimension = game.dimension;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				CheckBox checkbox = new CheckBox();
				grid.add(checkbox, i, j);

				BooleanProperty prop = game.cellProperty(i, j);
				prop.addListener((observable, oldValue, newValue) -> {
					checkbox.setSelected(newValue);
				});

				checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
					prop.set(newValue);
				});
			}
		}
	}

}

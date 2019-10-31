package unsw.automata;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class GameOfLifeController {

	private GameOfLife game;

	@FXML
	private GridPane grid;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnTick;

	private boolean ticking = false;
	private Timeline timeline;

	@FXML
	void handlePlayButton(MouseEvent event) {
		if (ticking) {
			timeline.stop();
			btnPlay.setText("Play");
		} else {
			timeline.play();
			btnPlay.setText("Stop");
		}

		ticking = !ticking;
	}

	@FXML
	void handleTickButton(MouseEvent event) {
		game.tick();
	}

	public GameOfLifeController() {
		timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> {
			game.tick();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
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

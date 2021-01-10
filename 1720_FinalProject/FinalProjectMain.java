
import java.awt.Polygon;

import javax.swing.ImageIcon;

import com.sun.javafx.tk.Toolkit;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FinalProjectMain extends Application {

	private final int WIDTH = 1920;
	private final int HEIGHT = 3072;

	public StackPane stack;
	public Scene myScene;

	private Button buttonForStars;
	private Image starsI;
	private ImageView starsIV;
	private Label labelForStars;

	private Button buttonForUFO;
	private Image ufoI;
	private ImageView ufoIV;
	private Label labelForUFO;
	private Label labelForUFOTwo;

	private Button buttonForMeteor;
	private Image meteorsI;
	private ImageView meteorsIV;
	private Label labelForMeteor;
	private Label labelForMeteorTwo;
	private double orgSceneX;
	private double orgSceneY;
	private double orgTranslateX;
	private double orgTranslateY;

	private Button resetButton;
	private Button quitButton;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.centerOnScreen();
		primaryStage.setTitle("'Explore Space' - Done By: Zohair Ahmed, Arujen Segar and Jie Gao");

		stack = new StackPane();
		stack.setAlignment(Pos.TOP_LEFT);
		stack.setStyle("-fx-background-color: #000000");

		buttonForStars = new Button("Travel through Space?");
		buttonForStars.setTranslateX(10);
		buttonForStars.setTranslateY(10);
		buttonForStars.setOnMouseClicked(new addStars());
		buttonForStars.setOnMouseEntered(new labelForStarEnter());
		buttonForStars.setOnMouseExited(new labelForStarExit());
		stack.getChildren().add(buttonForStars);

		buttonForUFO = new Button("Add Controllable UFO");
		buttonForUFO.setTranslateX(WIDTH - 275);
		buttonForUFO.setTranslateY(10);
		buttonForUFO.setOnMouseEntered(new labelForUFOEnter());
		buttonForUFO.setOnMouseExited(new labelForUFOExit());
		buttonForUFO.setOnMouseClicked(new addUFO());
		stack.getChildren().add(buttonForUFO);

		buttonForMeteor = new Button("Add Dragable Meteors");
		buttonForMeteor.setAlignment(Pos.TOP_CENTER);
		buttonForMeteor.setTranslateX(((WIDTH) / 2) - 137);
		buttonForMeteor.setTranslateY(10);
		buttonForMeteor.setOnMouseEntered(new labelForMeteorEnter());
		buttonForMeteor.setOnMouseExited(new labelForMeteorExit());
		buttonForMeteor.setOnMouseClicked(new addMeteors());
		stack.getChildren().add(buttonForMeteor);

		resetButton = new Button("Reset?");
		resetButton.setTranslateX(50);
		resetButton.setTranslateY(1000);
		resetButton.setScaleX(1.5);
		resetButton.setScaleY(1.5);
		resetButton.setOnMouseClicked(new resetScene());
		stack.getChildren().add(resetButton);

		quitButton = new Button("Quit?");
		quitButton.setTranslateX(1700);
		quitButton.setTranslateY(1000);
		quitButton.setScaleX(1.5);
		quitButton.setScaleY(1.5);
		quitButton.setOnMouseClicked(new quitScene());
		stack.getChildren().add(quitButton);

		myScene = new Scene(stack, WIDTH, HEIGHT);
		myScene.setOnKeyPressed(new moveUFO());
		primaryStage.setMaximized(true);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	public class addStars implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			if (event.MOUSE_CLICKED != null) {

				for (int i = 0; i < 100; i++) {

					buttonForStars.toFront();
					buttonForUFO.toFront();
					buttonForMeteor.toFront();
					resetButton.toFront();
					quitButton.toFront();

					double randomPositionX = (int) (Math.random() * WIDTH);
					double randomPositionY = (int) (Math.random() * HEIGHT);

					double randomScale = (Math.random() * 0.1);

					starsI = new Image(".//finalProject/Icons/star.png");
					starsIV = new ImageView();
					starsIV.setImage(starsI);
					starsIV.setTranslateX(randomPositionX);
					starsIV.setTranslateY(randomPositionY);

					ScaleTransition scaleStars = new ScaleTransition();
					scaleStars.setNode(starsIV);
					scaleStars.setFromX(0);
					scaleStars.setFromY(0);
					scaleStars.setToX(randomScale);
					scaleStars.setToY(randomScale);
					scaleStars.setDuration(Duration.millis(5000));
					scaleStars.play();

					RotateTransition rotateStars = new RotateTransition();
					rotateStars.setNode(starsIV);
					rotateStars.setByAngle(360);
					rotateStars.setCycleCount(Animation.INDEFINITE);
					rotateStars.setDuration(Duration.millis(1000));
					rotateStars.play();

					TranslateTransition translateStars = new TranslateTransition();
					translateStars.setNode(starsIV);
					translateStars.setByX(-2 * WIDTH);
					translateStars.setDuration(Duration.millis(20000));
					translateStars.play();

					stack.getChildren().add(starsIV);

				}
			}
		}
	}

	public class labelForStarEnter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			labelForStars = new Label();
			labelForStars.toFront();
			labelForStars.setText("Click this button to travel the galaxy!");
			labelForStars.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			labelForStars.setTextFill(Color.rgb(255, 255, 255));
			labelForStars.setTranslateX(10);
			labelForStars.setTranslateY(40);
			stack.getChildren().add(labelForStars);

		}
	}

	public class labelForStarExit implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().remove(labelForStars);

		}
	}

	public class addMeteors implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			for (int i = 0; i < 10; i++) {
				meteorsI = new Image(".//finalProject/Icons/meteor.gif");
				meteorsIV = new ImageView();
				meteorsIV.setImage(meteorsI);
				meteorsIV.setTranslateX(Math.random() * WIDTH - WIDTH - WIDTH / 2);
				meteorsIV.setTranslateY(Math.random() * HEIGHT - 200);
				meteorsIV.setScaleX(0.25);
				meteorsIV.setScaleY(0.25);
				meteorsIV.setCursor(Cursor.MOVE);

				TranslateTransition translateMeteors = new TranslateTransition();
				translateMeteors.setNode(meteorsIV);
				translateMeteors.setByX(WIDTH);
				translateMeteors.setDelay(Duration.millis(1000));
				translateMeteors.setDuration(Duration.millis(3000));
				translateMeteors.play();

				meteorsIV.setOnMousePressed(new pressMeteors());
				meteorsIV.setOnMouseDragged(new dragMeteors());
				stack.getChildren().add(meteorsIV);
			}

			buttonForMeteor.setOnMouseClicked(null);
			buttonForMeteor.setOnMouseEntered(new labelForMeteorExit());

			if (buttonForMeteor.getOnMouseClicked() == null) {
				stack.getChildren().remove(labelForMeteor);
				buttonForMeteor.setOnMouseExited(new theMeteorIsPresentExit());
				buttonForMeteor.setOnMouseEntered(new theMeteorIsPresentEnter());
			}

		}
	}

	public class pressMeteors implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();
			orgTranslateX = ((ImageView) (event.getSource())).getTranslateX();
			orgTranslateY = ((ImageView) (event.getSource())).getTranslateY();

		}
	}

	public class dragMeteors implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			double offsetX = event.getSceneX() - orgSceneX;
			double offsetY = event.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((ImageView) (event.getSource())).setTranslateX(newTranslateX);
			((ImageView) (event.getSource())).setTranslateY(newTranslateY);

		}
	}

	public class labelForMeteorEnter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			labelForMeteor = new Label();
			labelForMeteor.toFront();
			labelForMeteor.setText("Click this button to add movable meteors!");
			labelForMeteor.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			labelForMeteor.setTextFill(Color.WHITE);
			labelForMeteor.setTranslateX(WIDTH / 5 + 50);
			labelForMeteor.setTranslateY(40);
			stack.getChildren().add(labelForMeteor);

		}
	}

	public class labelForMeteorExit implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().remove(labelForMeteor);

		}
	}

	public class theMeteorIsPresentEnter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			labelForMeteorTwo = new Label();
			labelForMeteorTwo.toFront();
			labelForMeteorTwo.setText(
					"\t\t\tDon't ask for more meteors, all the power your console has will become extinct!\nJust click 'Reset?'"
							+ " and this button again to change the positions of the meteors, but you could drag them too!");
			labelForMeteorTwo.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			labelForMeteorTwo.setTextFill(Color.rgb(255, 255, 255));
			labelForMeteorTwo.setTranslateX(WIDTH / 5);
			labelForMeteorTwo.setTranslateY(40);
			stack.getChildren().add(labelForMeteorTwo);

		}
	}

	public class theMeteorIsPresentExit implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().remove(labelForMeteorTwo);

		}
	}

	public class addUFO implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			ufoI = new Image(".//finalProject/Icons/ufo.gif");
			ufoIV = new ImageView();
			ufoIV.setImage(ufoI);
			ufoIV.setScaleX(0.25);
			ufoIV.setScaleY(0.25);

			TranslateTransition translateUFO = new TranslateTransition();
			translateUFO.setNode(ufoIV);
			translateUFO.setFromX(WIDTH + WIDTH / 2);
			translateUFO.setFromY(80);
			translateUFO.setToX(20);
			translateUFO.setDuration(Duration.millis(500));
			translateUFO.play();

			ufoIV.setOnKeyPressed(new moveUFO());
			stack.getChildren().add(ufoIV);
			buttonForUFO.setOnMouseClicked(null);
			buttonForUFO.setOnMouseEntered(new labelForUFOExit());

			if (buttonForUFO.getOnMouseClicked() == null) {
				stack.getChildren().remove(labelForUFO);
				buttonForUFO.setOnMouseExited(new theUFOIsPresentExit());
				buttonForUFO.setOnMouseEntered(new theUFOIsPresentEnter());
			}
		}
	}

	public class moveUFO implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
			// TODO Auto-generated method stub

			ufoIV.toFront();

			KeyCode code = event.getCode();

			switch (code) {
			case UP:
				TranslateTransition translateStarUpKey = new TranslateTransition();
				translateStarUpKey.setDuration(Duration.millis(1000));
				translateStarUpKey.setNode(ufoIV);
				translateStarUpKey.setByY(translateStarUpKey.getByY() - 100);
				translateStarUpKey.setAutoReverse(false);
				translateStarUpKey.play();
				break;
			case DOWN:
				TranslateTransition translateStarDownKey = new TranslateTransition();
				translateStarDownKey.setDuration(Duration.millis(1000));
				translateStarDownKey.setNode(ufoIV);
				translateStarDownKey.setByY(translateStarDownKey.getByY() + 100);
				translateStarDownKey.setAutoReverse(false);
				translateStarDownKey.play();
				break;
			case LEFT:
				TranslateTransition translateStarLeftKey = new TranslateTransition();
				translateStarLeftKey.setDuration(Duration.millis(1000));
				translateStarLeftKey.setNode(ufoIV);
				translateStarLeftKey.setByX(translateStarLeftKey.getByX() - 100);
				translateStarLeftKey.setAutoReverse(false);
				translateStarLeftKey.play();
				break;
			case RIGHT:
				TranslateTransition translateStarRightKey = new TranslateTransition();
				translateStarRightKey.setDuration(Duration.millis(1000));
				translateStarRightKey.setNode(ufoIV);
				translateStarRightKey.setByX(translateStarRightKey.getByX() + 100);
				translateStarRightKey.setAutoReverse(false);
				translateStarRightKey.play();
				break;
			}
		}
	}

	public class labelForUFOEnter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			labelForUFO = new Label();
			labelForUFO.toFront();
			labelForUFO.setText("Click this button to create a UFO you can CONTROL \n\t\t\tusing the arrow keys!");
			labelForUFO.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			labelForUFO.setTextFill(Color.rgb(255, 255, 255));
			labelForUFO.setTranslateX(WIDTH / 3 + 10);
			labelForUFO.setTranslateY(40);
			stack.getChildren().add(labelForUFO);

		}
	}

	public class labelForUFOExit implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().remove(labelForUFO);

		}
	}

	public class theUFOIsPresentEnter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			labelForUFOTwo = new Label();
			labelForUFOTwo.toFront();
			labelForUFOTwo
					.setText("   The UFO is present, you don't need to click this...\n\t\t\tJust move the arrow keys");
			labelForUFOTwo.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			labelForUFOTwo.setTextFill(Color.rgb(255, 255, 255));
			labelForUFOTwo.setTranslateX(WIDTH / 3 + 10);
			labelForUFOTwo.setTranslateY(40);
			stack.getChildren().add(labelForUFOTwo);

		}
	}

	public class theUFOIsPresentExit implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().remove(labelForUFOTwo);

		}
	}

	public class resetScene implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			stack.getChildren().clear();

			buttonForStars = new Button("Travel through Space?");
			buttonForStars.setTranslateX(10);
			buttonForStars.setTranslateY(10);
			buttonForStars.setOnMouseClicked(new addStars());
			buttonForStars.setOnMouseEntered(new labelForStarEnter());
			buttonForStars.setOnMouseExited(new labelForStarExit());
			stack.getChildren().add(buttonForStars);

			buttonForUFO = new Button("Add Controllable UFO");
			buttonForUFO.setTranslateX(WIDTH - 350);
			buttonForUFO.setTranslateY(10);
			buttonForUFO.setOnMouseEntered(new labelForUFOEnter());
			buttonForUFO.setOnMouseExited(new labelForUFOExit());
			buttonForUFO.setOnMouseClicked(new addUFO());
			stack.getChildren().add(buttonForUFO);

			buttonForMeteor = new Button("Add Dragable Meteors");
			buttonForMeteor.setAlignment(Pos.TOP_CENTER);
			buttonForMeteor.setTranslateX((WIDTH - 350) / 2);
			buttonForMeteor.setTranslateY(10);
			buttonForMeteor.setOnMouseEntered(new labelForMeteorEnter());
			buttonForMeteor.setOnMouseExited(new labelForMeteorExit());
			buttonForMeteor.setOnMouseClicked(new addMeteors());
			stack.getChildren().add(buttonForMeteor);

			resetButton = new Button("Reset?");
			resetButton.setTranslateX(30);
			resetButton.setTranslateY(9 * (HEIGHT / 10));
			resetButton.setScaleX(1.5);
			resetButton.setScaleY(1.5);
			resetButton.setOnMouseClicked(new resetScene());
			stack.getChildren().add(resetButton);

			quitButton = new Button("Quit?");
			quitButton.setTranslateX(WIDTH - 250);
			quitButton.setTranslateY(9 * (HEIGHT / 10));
			quitButton.setScaleX(1.5);
			quitButton.setScaleY(1.5);
			quitButton.setOnMouseClicked(new quitScene());
			stack.getChildren().add(quitButton);

		}
	}

	public class quitScene implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub

			Stage primaryStage = (Stage) quitButton.getScene().getWindow();
			primaryStage.close();

		}
	}

}

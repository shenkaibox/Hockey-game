
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class hockey_twoplayer implements Initializable , EventHandler<KeyEvent>{
	@FXML
	public Canvas canvas;
	@FXML
	public Pane pane;
	//variable
	private int width = 500;
	private int height = 400;
	private int PLAYER_HEIGHT = 50;
	private int PLAYER_WIDTH = 10;
	private double BALL_R = 20;//直徑
	private double ballYSpeed = 1;
	private double ballXSpeed = 1;
	private double playerOneYPos = height / 2;
	private double playerTwoYPos = height / 2;
	private double ballXPos = width / 2;
	private double ballYPos = height / 2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted;
	private int playerOneXPos = 15;
	private double playerTwoXPos = width - PLAYER_WIDTH - 15;
	private int i;
	
	public void run(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		gc.setFill(Color.YELLOW);
		gc.fillRect(0, 0, 500, 8);    
	    gc.fillRect(0, 392, 500, 8);  
	    gc.fillRect(0, 0, 8, 100);    
	    gc.fillRect(0, 300, 8, 100);  
	    gc.fillRect(492, 0, 8, 100);  
	    gc.fillRect(492, 300, 8, 100);
	    //讓球棍在球門之間
	    if(playerOneYPos < 100) {
	    	playerOneYPos = 100;
	    }
	    if(playerOneYPos > 250) {
	    	playerOneYPos = 250;
		}
	    //電腦只在球門間移動
		if(playerTwoYPos < 100) {
			playerTwoYPos = 100;
	    }else if(playerTwoYPos > 250) {
	    	playerTwoYPos = 250;
	    }
			
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("Verdana",30));
		
			
		if(gameStarted) {
			//set ball movement
			if(i == 0) {
				ballXPos+=ballXSpeed;
				ballYPos+=ballYSpeed;
			}else if(i == 1){
				ballXPos-=ballXSpeed;
				ballYPos-=ballYSpeed;
			}else if(i == 2){
				ballXPos+=ballXSpeed;
				ballYPos-=ballYSpeed;
			}else if(i == 3) {
				ballXPos-=ballXSpeed;
				ballYPos+=ballYSpeed;
			}

			//畫球
			gc.fillOval(ballXPos, ballYPos, BALL_R , BALL_R);		
			} else {
			//設置開始的文字
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("PRESSED ENTER", width / 2, height / 2);
				
			//重置起點 
			ballXPos = width / 2;
			ballYPos = height / 2;
				
			//重置球速
			ballXSpeed = 2;
			ballYSpeed = 2;
				
		}
			
		//讓球在視窗範圍裡
		if(ballYPos > height - 28 || ballYPos < 18) {
			ballYSpeed *= -1;
		}
		if(ballXPos > width - 28 && ballYPos > 272 || ballXPos > width - 28  && ballYPos < 108) {
			ballXSpeed *= -1;
		}
		if(ballXPos < 28 && ballYPos > 272 || ballXPos < 28  && ballYPos < 108) {
			ballXSpeed *= -1;	
		}
			
		//電腦得分
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
			if(scoreP2 == 5) {
				Main.currentStage.setScene(Main.Twopalyer_p2win);
			}
		}
		//玩家得分
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
			if(scoreP1 == 5) {
				Main.currentStage.setScene(Main.Twopalyer_p1win);
			}
		}
			
		//讓球碰到棍反彈
		if((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos > 128 || (ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos < 272) {
			if(ballYPos >=  playerOneYPos - 25 && ballYPos <= playerOneYPos + 50) {
				ballYSpeed += 1 * Math.signum(ballYSpeed);
				ballXSpeed += 1 * Math.signum(ballXSpeed);
				ballXSpeed *= -1;
				ballYSpeed *= -1;
				if(ballXSpeed >= 5) {
					ballXSpeed = 5;
				}else if(ballYSpeed >= 5) {
					ballYSpeed = 5;
				}
			}
			}else if(ballXPos + BALL_R > playerTwoXPos) {
				if(ballYPos >=  playerTwoYPos - 25 && ballYPos <= playerTwoYPos + 50) {
					ballYSpeed += 1 * Math.signum(ballYSpeed);
					ballXSpeed += 1 * Math.signum(ballXSpeed);
					ballXSpeed *= -1;
					ballYSpeed *= -1;
					if(ballXSpeed >= 5) {
						ballXSpeed = 5;
					}else if(ballYSpeed >= 5) {
						ballYSpeed = 5;
					}
				}
			}
			
			//畫分數
			gc.fillText(scoreP1 + "             " + scoreP2, width / 2, 100);
			//設置玩家1和玩家2
			gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
			gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		//pane.getChildren().add(canvas);
		//動畫 
		Timeline fps = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		fps.setCycleCount(Timeline.INDEFINITE);
		fps.play();
		
	}

	@Override
	public void handle(KeyEvent e) {
		if(e.getCode() == KeyCode.W) {
			playerOneYPos -= 15;
		}
		if(e.getCode() == KeyCode.S) {
			playerOneYPos += 15;
		}
		if (e.getCode() == KeyCode.ENTER) {
			gameStarted = true;
			Random rand = new Random();
			i = rand.nextInt(4);
		}
		if (e.getCode() == KeyCode.UP) {
			playerTwoYPos -= 15;
		}
		if(e.getCode() == KeyCode.DOWN) {
			playerTwoYPos += 15;
		}
		
	}
}

package game.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by TADimitrov on 3/30/2016.
 */
public class Menu extends BasicGameState {
    private int stateID;
    private Image background;
    private Image playButton;
    private Image saveButton;
    private Image loadButton;
    private Image exitButton;
    private Image playButtonNormal;
    private Image playButtonHover;
    private Image saveButtonNormal;
    private Image saveButtonHover;
    private Image loadButtonNormal;
    private Image loadButtonHover;
    private Image exitButtonNormal;
    private Image exitButtonHover;

    public Menu(int state) {
        this.setStateID(state);
    }

    @Override
    public int getID() {
        return this.stateID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.setBackground();
        this.setButtons();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        this.drawBackgound();
        this.drawButtonsNormal();

        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        g.drawString("X" + xpos, 50, 100);
        g.drawString("Y" + ypos, 50, 150);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        this.buttonsFunctionality(xpos, ypos,stateBasedGame);
    }

    private void buttonsFunctionality(int x, int y, StateBasedGame stateBasedGame) {
        boolean isPlayButtonSelected = (x >= 270 && x <= 555) && (y >= 205 && y <= 260);
        boolean isSaveButtonSelected = (x >= 270 && x <= 555) && (y >= 140 && y <= 195);
        boolean isLoadButtonSelected = (x >= 270 && x <= 555) && (y >= 75 && y <= 130);
        boolean isExitButtonSelected = (x >= 270 && x <= 555) && (y >= 10 && y <= 65);
        if (isPlayButtonSelected) {
            this.playButton = this.playButtonHover;
            if (Mouse.isButtonDown(0)) {
                stateBasedGame.enterState(1);
            }
        } else {
            this.playButton = this.playButtonNormal;
        }

        if (isSaveButtonSelected) {
            this.saveButton = this.saveButtonHover;
        } else {
            this.saveButton = this.saveButtonNormal;
        }

        if (isLoadButtonSelected) {
            this.loadButton = this.loadButtonHover;
        } else {
            this.loadButton = this.loadButtonNormal;
        }

        if (isExitButtonSelected) {
            this.exitButton = this.exitButtonHover;
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        } else {
            this.exitButton = this.exitButtonNormal;
        }
    }

    private void drawBackgound() {
        this.background.draw(0, 0);
    }

    private void drawButtonsNormal() {
        this.playButton.draw(270, 340);
        this.saveButton.draw(270, 405);
        this.loadButton.draw(270, 470);
        this.exitButton.draw(270, 535);
    }

    private void setBackground() {
        try {
            this.background = new Image("res/menu/tyrael.jpg");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void setButtons() {
        try {
            this.playButton = new Image("res/menu/play_normal.png");
            this.saveButton = new Image("res/menu/save_normal.png");
            this.loadButton = new Image("res/menu/load_normal.png");
            this.exitButton = new Image("res/menu/exit_normal.png");
            this.playButtonNormal = new Image("res/menu/play_normal.png");
            this.playButtonHover = new Image("res/menu/play_hover.png");
            this.saveButtonNormal = new Image("res/menu/save_normal.png");
            this.saveButtonHover = new Image("res/menu/save_hover.png");
            this.loadButtonNormal = new Image("res/menu/load_normal.png");
            this.loadButtonHover = new Image("res/menu/load_hover.png");
            this.exitButtonNormal = new Image("res/menu/exit_normal.png");
            this.exitButtonHover = new Image("res/menu/exit_hover.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void setStateID(int stateID) {
        this.stateID = stateID;
    }
}

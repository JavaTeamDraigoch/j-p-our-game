package game.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
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
    private Image[] diabloFrames;
    private Animation title;
    private int[] titleDuration;

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
        this.setTitle();
        this.setButtons();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        this.drawBackgound();
        this.drawTitle();
        this.drawButtons();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        this.buttonsFunctionality(xpos, ypos, stateBasedGame);
    }

    private void buttonsFunctionality(int x, int y, StateBasedGame stateBasedGame) {
        boolean isPlayButtonSelected = (x >= 257 && x <= 542) && (y >= 205 && y <= 260);
        boolean isSaveButtonSelected = (x >= 257 && x <= 542) && (y >= 140 && y <= 195);
        boolean isLoadButtonSelected = (x >= 257 && x <= 542) && (y >= 75 && y <= 130);
        boolean isExitButtonSelected = (x >= 257 && x <= 542) && (y >= 10 && y <= 65);
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

    private void drawButtons() {
        this.playButton.draw(257, 340);
        this.saveButton.draw(257, 405);
        this.loadButton.draw(257, 470);
        this.exitButton.draw(257, 535);
    }

    private void drawTitle() {
        this.title.draw(225, 40);
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

    private void setTitle() {
        try {
            this.diabloFrames = new Image[]{new Image("res/menu/diablo_fire_frame_1.png"), new Image("res/menu/diablo_fire_frame_2.png"), new Image("res/menu/diablo_fire_frame_3.png")};
            this.titleDuration = new int[]{500, 500, 500};
            this.title = new Animation(this.diabloFrames, titleDuration);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void setStateID(int stateID) {
        this.stateID = stateID;
    }
}

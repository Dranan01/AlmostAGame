/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Yogo.YogoGame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author franm
 */
public class Hud {
    public Stage stage;
    private Viewport viewport;
    
    private int health;
    private float timeCount;
    
    Label healthLabel;
    Label timeLabel;

    public Hud(SpriteBatch sb) {
    
        timeCount = 0f;
        health = 100;
        
        viewport = new FitViewport(YogoGame.V_WIDTH,YogoGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        healthLabel = new Label(String.format("%03d", health), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label(String.format("%06f", timeCount),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        
        table.add(healthLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        
        stage.addActor(table);
    
    }
    
    
    
    
    
}

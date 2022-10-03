/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Yogo;

import View.YogoScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 *
 * @author franm
 */
public class YogoGame extends Game {
    public static final int V_WIDTH = 480;
    public static final int V_HEIGHT = 300;
    
    public SpriteBatch batch;

    
    
    
    
    @Override
    public void create() {
     batch = new SpriteBatch();
     setScreen(new YogoScreen(this));
     

    }
    public void render(){
        super.render();
    }
    
}

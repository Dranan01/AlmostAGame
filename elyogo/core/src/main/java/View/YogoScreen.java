/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Yogo.YogoGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author franm
 */
public class YogoScreen implements Screen {

    private YogoGame game;
    private OrthographicCamera camera;
    private Viewport gamePort;
    private Hud hud;
    private Stage stage;

    //variables de tiledMap
    private TmxMapLoader loader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    final float pixelsPerTile = 16;

    
    //variables de box2d
    private World world;
    private Box2DDebugRenderer b2dr;
    
    
    public YogoScreen(YogoGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        gamePort = new FillViewport(YogoGame.V_WIDTH, YogoGame.V_HEIGHT, camera);
        hud = new Hud(game.batch);
        loader = new TmxMapLoader();
        map = loader.load("level1Yogo.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        
        camera.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);
        camera.position.y = 151;
        camera.position.x = 198;

    }

    public void handleInput(float dt) {
        if (Gdx.input.isTouched()) {
            camera.position.x += 100 * dt;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.position.x += 300 * dt;
        }
        mapRenderer.setView(camera);
    }

    public void update(float dt) {
        handleInput(dt);
        camera.update();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        mapRenderer.setView(camera);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

    }

    @Override
    public void resize(int width, int height) {

        gamePort.update(width, height);

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

}

package com.example.try_dodgefireball;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.LayerManager;
import com.example.try_gameengine.scene.Scene;
import com.example.try_gameengine.scene.SceneManager;
import com.example.try_gameengine.stage.Stage;

public class GameActivity extends Stage{
	SceneManager sceneManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		initStage();
	}
	
	@Override
	public SceneManager initSceneManager() {
		// TODO Auto-generated method stub
		if(CommonUtil.screenHeight<=0){
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			
			CommonUtil.screenHeight = dm.heightPixels;
			CommonUtil.screenWidth = dm.widthPixels;
			CommonUtil.statusBarHeight = CommonUtil.getStatusBarHeight(this);
			CommonUtil.screenHeight -= CommonUtil.statusBarHeight;
		}
		BitmapUtil.initBitmap(this);
	
		LayerManager.getInstance().setLayerBySenceIndex(0);
		Scene scene = new MyScene(this, "a", 1, Scene.RESUME);
//		LayerManager.setLayerBySenceIndex(1);
//		Scene scene2 = new MyScene2(this, "b", 2, Scene.RESTART);
		
		sceneManager = new SceneManager();
		sceneManager.addScene(scene);
//		sceneManager.addScene(scene2);
		
		sceneManager.startScene(0);
		
		return sceneManager;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();
//		sceneManager.previous();
		sceneManager.previous();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
}

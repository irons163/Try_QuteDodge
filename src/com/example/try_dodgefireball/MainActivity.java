package com.example.try_dodgefireball;

import com.example.try_gameengine.framework.Config;
import com.example.try_gameengine.framework.Config.DestanceType;
import com.example.try_gameengine.scene.SceneManager;
import com.example.try_gameengine.stage.BaseStage;
import com.example.try_gameengine.stage.Stage;
import com.example.try_gameengine.stage.StageManager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Stage {
	
	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StageManager.changeStage(MainActivity.this, GameActivity.class, false);
			}
		});
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		CommonUtil.screenHeight = dm.heightPixels;
		CommonUtil.screenWidth = dm.widthPixels;
		CommonUtil.statusBarHeight = CommonUtil.getStatusBarHeight(this);
		CommonUtil.screenHeight -= CommonUtil.statusBarHeight;
		
		Config.enableFPSInterval = true;
		Config.fps = 40;
		Config.showFPS = true;
		Config.destanceType = DestanceType.ScreenPersent;
		Config.currentScreenWidth = CommonUtil.screenWidth;
		Config.currentScreenHeight = CommonUtil.screenHeight;
		
		BitmapUtil.initBitmap(this);
		
		StageManager.init(this);
//		StageManager.addStage("");
//		StageManager.addStage("");
//		StageManager.startStage(0);
		initStage();
	}
	
	@Override
	public SceneManager initSceneManager() {
		// TODO Auto-generated method stub
		SceneManager sceneManager = new SceneManager();
		return sceneManager;
	}

}

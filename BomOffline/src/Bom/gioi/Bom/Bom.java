package Bom.gioi.Bom;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.content.Context;
import Bom.gioi.InterfaceSprite.InterfaceSprite;

public class Bom implements InterfaceSprite{

	//Vị trí của quả bom
	public float pX = -100, pY = -100;//Mặc định ban đầu luôn là -100 để bom nằm ngoài màn hình
	
	//Animation dùng để tạo hiệu ứng
	public AnimatedSprite Bom_AnimatedSprite;
	
	//Biến load ảnh và lưu ảnh vào bộ nhớ.
	public TiledTextureRegion Bom_TiledTextureRegion;
	private BitmapTextureAtlas Bom_BitmapTextureAtlas;	
	
	//==========================================================================================
	/**
	 * Phương thức khởi dựng với vị trí được chuyền vào.
	 */
	public Bom(float pX, float pY){
		this.pX = pX;
		this.pY = pY;
	}
	//==========================================================================================
	/**
	 * Phương thức onLoadResources
	 */
	@Override
	public void onLoadResources(Engine mEngine, Context mContext) {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/Bom/");
		this.Bom_BitmapTextureAtlas = new BitmapTextureAtlas(128, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);				
		this.Bom_TiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.Bom_BitmapTextureAtlas, mContext, "bom.png", 0, 0, 4, 1);
		mEngine.getTextureManager().loadTexture(this.Bom_BitmapTextureAtlas);	
		
	}
	//==========================================================================================
	/**
	 * Phương thức onLoadScene
	 */
	@Override
	public void onLoadScene(Scene mScene) {
		Bom_AnimatedSprite = new AnimatedSprite(pX, pY, Bom_TiledTextureRegion);
		Bom_AnimatedSprite.animate(100);
		mScene.attachChild(Bom_AnimatedSprite);
		
	}
	//==========================================================================================
	/**
	 * Phương thức di chuyển đối tượng bom đến vị trí pX,pY. Đặt trạng thái của bom là hiện thị
	 */
	public void moveNewXY(float pX, float pY){
		this.pX = pX;
		this.pY = pY;
		Bom_AnimatedSprite.setPosition(pX, pY);
		Bom_AnimatedSprite.setVisible(true);//Đặt trạng thái hiện thị
	}

}

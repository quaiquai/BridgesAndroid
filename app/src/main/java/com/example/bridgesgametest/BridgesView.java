package com.example.bridgesgametest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;

public class BridgesView extends View {

    private ShapeDrawable shape;
    private Bitmap randShape;

    // Objects for the display and point.
    private Display display;
    private Point point;

    // User defined width and height of the grid.
    private int gridWidth;
    private int gridHeight;

    // Sprite width and height set dynamically based on screen size.
    private int spriteWidth;
    private int spriteHeight;

    // Width and height of the display in pixels.
    private int displayWidth;
    private int displayHeight;

    // A sprite image will be loaded into the bitShape object.
    // In order to resize the sprite for different screens it must be
    // loaded into the updatedBitShape object after the dimensions have been determined.
    private Bitmap updatedSprite;

    private int buttonWidth;

    private int WIDTH;
    private int HEIGHT;

    private Bitmap bitmapImage;


    public BridgesView(Context context) {
        super(context);
        //bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton);
//        WIDTH = bitmapImage.getWidth() / 9;
//        HEIGHT = bitmapImage.getHeight() / 4;
    }

    @Override
    protected void onDraw(Canvas canvas){
//        if(this.shape != null) {
//            shape.draw(canvas);
//        }
//        if(this.randShape != null) {
//            canvas.drawBitmap(randShape, 0, 0, null);
//        }

        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                canvas.drawBitmap(updatedSprite, ((i * spriteWidth)+(buttonWidth/2)), (j * spriteHeight), null);
            }
        }

    }

    public void generateGridParams(int width, int height, String baseShape){
        // Get users grid size.
        setGridWidth(width);
        setGridHeight(height);
        // Get display size.
        loadDisplay();
        setPoint(display);
        // Get display pixel values.
        setDisplayWidth(point.x);
        setDisplayHeight(point.y);
        // Get sprite size params.
        setSpriteWidth(displayWidth);
        setSpriteHeight(displayHeight);
        // Get sprite
        setShape(baseShape);
    }

    // Set display and point object.
    public void loadDisplay(){
        display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
    }
    public Display getDisplay(){
        return display;
    }
    public void setPoint(Display d){
        point = new Point();
        d.getSize(point);
    }

    // Setter for display height and width in pixels.
    // Save 1/3rd of the width space for buttons. This will be split in half to have space
    // on both sides of the grid.
    public void setDisplayWidth(int w){
        buttonWidth = w/3;
        displayWidth = w-buttonWidth;
    }
    public void setDisplayHeight(int h){
        displayHeight = h;
    }

    // Setter for grid height and width
    public void setGridWidth(int gw){
        gridWidth = gw;
    }
    public void setGridHeight(int gh){
        gridHeight = gh;
    }

    // Getters and setters for sprite width and height.
    // Knowing that we want a 30x30 grid we can scale the sprites to fit screens dynamically.
    // First consider the ideal size of a sprite in a 30x30 grid that exists in a 900x900 display.
    // Divide the target display height or width by the base display height or width to get the scale value.
    // Multiply the height or width of the sprite from the 30x30 grid by the scale value to get the new size.
    // I've used the values 90x90 and 3x3 to represent the base size 900x900 and 30x30. This allows the formula to work on
    // displays smaller than 900x900.
    // This formula will not work on displays smaller than 90x90.
    public void setSpriteWidth(int targetDisplayW){
        int baseDimensionWidth = 90;
        int baseSpriteWidth = 3;
        int scaleValueWidth = targetDisplayW/baseDimensionWidth;
        spriteWidth = baseSpriteWidth * scaleValueWidth;
    }
    public void setSpriteHeight(int targetDisplayH){
        int baseDimensionHeight = 90;
        int baseSpriteHeight = 3;
        int scaleValueHeight = targetDisplayH/baseDimensionHeight;
        spriteHeight = baseSpriteHeight * scaleValueHeight;
    }

    public void setShape(String sh, int w, int h){
        switch(sh){
            case "oval":
                shape = new ShapeDrawable(new OvalShape());
                shape.getPaint().setColor(0xff74AC23);
                shape.setBounds(10,10,310,60);
                break;
            case "square":
                bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton);
                randShape = createSubImageAt(w,h, WIDTH, HEIGHT);
            case "circle":
                randShape = BitmapFactory.decodeResource(getResources(), R.drawable.white_square);
                break;

        }
        // Resize the sprite to fill one space in the grid.
        updatedSprite = Bitmap.createScaledBitmap(randShape, spriteWidth, spriteHeight, false);
    }

    public void setShape(String sh){
        switch(sh){
            case "oval":
                shape = new ShapeDrawable(new OvalShape());
                shape.getPaint().setColor(0xff74AC23);
                shape.setBounds(10,10,310,60);
                break;
            case "circle":
                randShape = BitmapFactory.decodeResource(getResources(), R.drawable.white_square);
                break;

        }
        // Resize the sprite to fill one space in the grid.
        updatedSprite = Bitmap.createScaledBitmap(randShape, spriteWidth, spriteHeight, false);
    }

    protected Bitmap createSubImageAt(int row, int col, int w, int h)  {
        // createBitmap(bitmap, x, y, width, height).
        Bitmap subImage = Bitmap.createBitmap(bitmapImage, col* w, row* h ,w,h);
        return subImage;
    }
}

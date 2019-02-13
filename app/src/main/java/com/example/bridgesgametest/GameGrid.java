package com.example.bridgesgametest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.Canvas;


public class GameGrid {

    private int currentXCell;
    private int currentYCell;

    private MainThread thread;


    private ShapeDrawable shape;
    private Bitmap randShape;

    // Objects for the display and point.
    private Display display;
    private Point point;
    private Boolean gridCreated = false;

    // User defined width and height of the grid.
    private int gridWidth;
    private int gridHeight;

    // Sprite width and height set dynamically based on screen size.
    private int cellWidth;
    private int cellHeight;

    private int spriteWidth;
    private int spriteHeight;

    // Width and height of the display in pixels.
    private int displayWidth;
    private int displayHeight;

    // A sprite image will be loaded into the bitShape object.
    // In order to resize the sprite for different screens it must be
    // loaded into the updatedBitShape object after the dimensions have been determined.
    private Bitmap updatedSprite;

    // Button values set after the grid has been built so that the left over space for buttons
    // can be set dynamically.
    private int buttonSpaceWidth;
    private Bitmap btnLeft;
    private Bitmap btnRight;
    private Bitmap btnUp;
    private Bitmap btnDown;
    private Bitmap btnX;
    private Bitmap btnY;

    private int WIDTH;
    private int HEIGHT;

    private Context context;

    private Bitmap bitmapImage;

    public GameGrid(Context context,int width, int height){
        // Get users grid size.
        this.context = context;
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

    }

    public void draw(Canvas canvas, int xpos, int ypos){
        setShape("circle");
        canvas.drawBitmap(updatedSprite, ((xpos * spriteWidth)+(buttonSpaceWidth/2)), (ypos * spriteHeight), null);
    }

    // Set display and point object.
    public void loadDisplay(){
        display = ((Activity) this.context).getWindowManager().getDefaultDisplay();
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
        buttonSpaceWidth = w/3;
        displayWidth = w-buttonSpaceWidth;
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
                bitmapImage = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.skeleton);
                randShape = createSubImageAt(w,h, WIDTH, HEIGHT);
            case "circle":
                randShape = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.white_square);
                break;

        }
        // Resize the sprite to fill one space in the grid.
        updatedSprite = Bitmap.createScaledBitmap(randShape, cellWidth, cellHeight, false);
    }

    public void setShape(String sh){
        switch(sh){
            case "oval":
                shape = new ShapeDrawable(new OvalShape());
                shape.getPaint().setColor(0xff74AC23);
                shape.setBounds(10,10,310,60);
                break;
            case "circle":
                randShape = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.white_square);
                break;

        }
        // Resize the sprite to fill one space in the grid.
        updatedSprite = Bitmap.createScaledBitmap(randShape, spriteWidth, spriteHeight, false);
    }

    // Generates the buttons including images and sizes creating buttons 2x the size of the grid
    // cells so they can be clicked easily.
//    public void generateButtons(){
//        btnLeft = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.left);
//        btnLeft = Bitmap.createScaledBitmap(btnLeft, (cellWidth*2), (cellHeight*2), false);
//        btnRight = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.right);
//        btnRight = Bitmap.createScaledBitmap(btnRight, (cellWidth*2), (cellHeight*2), false);
//        btnUp = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.up);
//        btnUp = Bitmap.createScaledBitmap(btnUp, (cellWidth*2), (cellHeight*2), false);
//        btnDown = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.down);
//        btnDown = Bitmap.createScaledBitmap(btnDown, (cellWidth*2), (cellHeight*2), false);
//        btnX = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.x);
//        btnX = Bitmap.createScaledBitmap(btnX, (cellWidth*2), (cellHeight*2), false);
//        btnY = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.y);
//        btnY = Bitmap.createScaledBitmap(btnY, (cellWidth*2), (cellHeight*2), false);
//    }

    // Partitions the button space to determine where on the screen the buttons will sit in relation
    // to the game grid.dio
    public void generateButtonMappings(Canvas c){
        int cellHeightDouble = cellHeight+cellHeight;
        int cellWidthDouble = cellWidth+cellWidth;
        int horizontalLineCenter = displayHeight/2;
        int leftPaneVerticalLineCenter = (buttonSpaceWidth/4)+20;
        int rightPaneVerticalLineCenter = displayWidth+(buttonSpaceWidth/2);

        int btnLeftLeft = (leftPaneVerticalLineCenter/2)-cellWidthDouble;
        int btnLeftTop = horizontalLineCenter;

        int btnRightLeft = btnLeftLeft+(cellWidthDouble*2);
        int btnRightTop = btnLeftTop;

        int btnUpLeft = btnLeftLeft+cellWidthDouble;
        int btnUpTop = btnLeftTop-cellHeightDouble;

        int btnDownLeft = btnLeftLeft+cellWidthDouble;
        int btnDownTop = btnLeftTop+cellHeightDouble;

        int btnXLeft = rightPaneVerticalLineCenter+cellWidthDouble;
        int btnXTop = horizontalLineCenter-cellHeightDouble;

        int btnYLeft = btnXLeft - cellWidthDouble;
        int btnYTop = horizontalLineCenter+cellHeightDouble;

        c.drawBitmap(btnDown, btnDownLeft, btnDownTop, null);
        c.drawBitmap(btnUp, btnUpLeft, btnUpTop, null);
        c.drawBitmap(btnRight, btnRightLeft, btnRightTop, null);
        c.drawBitmap(btnLeft, btnLeftLeft, btnLeftTop, null);
        c.drawBitmap(btnX, btnXLeft, btnXTop, null);
        c.drawBitmap(btnY, btnYLeft, btnYTop, null);
    }

    public Bitmap getUpBtn(){
        return btnUp;
    }
    public Bitmap getDownBtn(){
        return btnDown;
    }

    protected Bitmap createSubImageAt(int row, int col, int w, int h)  {
        // createBitmap(bitmap, x, y, width, height).
        Bitmap subImage = Bitmap.createBitmap(bitmapImage, col* w, row* h ,w,h);
        return subImage;
    }
}



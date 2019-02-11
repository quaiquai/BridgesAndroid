package com.example.bridgesgametest;
import android.content.Context;
import android.graphics.Bitmap;
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

    private int WIDTH;
    private int HEIGHT;

    private Bitmap bitmapImage;


    public BridgesView(Context context) {
        super(context);
        bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.skeleton);
        WIDTH = bitmapImage.getWidth() / 9;
        HEIGHT = bitmapImage.getHeight() / 4;
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(this.shape != null) {
            shape.draw(canvas);
        }
        if(this.randShape != null) {
            canvas.drawBitmap(randShape, 0, 0, null);
        }

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
        }
    }

    protected Bitmap createSubImageAt(int row, int col, int w, int h)  {
        // createBitmap(bitmap, x, y, width, height).
        Bitmap subImage = Bitmap.createBitmap(bitmapImage, col* w, row* h ,w,h);
        return subImage;
    }
}

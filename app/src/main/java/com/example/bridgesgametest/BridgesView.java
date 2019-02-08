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


    public BridgesView(Context context) {
        super(context);
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

    public void setShape(String sh){
        switch(sh){
            case "oval":
                shape = new ShapeDrawable(new OvalShape());
                shape.getPaint().setColor(0xff74AC23);
                shape.setBounds(10,10,310,60);
                break;
            case "square":
                randShape = BitmapFactory.decodeResource(getResources(), R.drawable.white_square);
        }
    }
}

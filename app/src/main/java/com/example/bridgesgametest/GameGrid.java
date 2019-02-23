package com.example.bridgesgametest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GameGrid extends Fragment {

    // dimensions
    public int gridX;
    public int gridY;

    private Bitmap bitmapImage;
    private Bitmap subImage;

    //width and height for the sprite sheet
    private int WIDTH;
    private int HEIGHT;

    public int[] dimensions;

    // Array of gridCells as ImageViews from XML game_grid.
    public ImageView[][] GameGrid = new ImageView[30][30];

    // A single cell ImageView object so cells can be accessed one at a time.
    public ImageView singleCell;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.game_grid, parent, false);

        bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.symbols);
        WIDTH = bitmapImage.getWidth() / 16;
        HEIGHT = bitmapImage.getHeight() / 16;

        gridX = 30;
        gridY = 30;
        dimensions = new int[] {gridX, gridY};

        connectCells(v);

        return v;
    }

    // Set ImageView objects of game_grid xml to corresponding GameGrid ImageView array.
    public void connectCells(View v){
        String cellNameBase = "gameCell";
        String cellName;
        int cellCounter = 1;
        int cellID;

        for (int i = 0; i < 30; i++){
            for (int j = 0; j < 30; j++){
                cellName = cellNameBase+(cellCounter);
                cellID = getResources().getIdentifier(cellName, "id", getActivity().getPackageName());
                GameGrid[i][j] = v.findViewById(cellID);
                GameGrid[i][j].setBackgroundColor(Color.GREEN);
                cellCounter++;
            }
        }
    }

    // Draw object at specified grid location. Color neutral.
    public void drawObject(int x, int y, NamedSymbol spriteName){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        GameGrid[x][y].setImageBitmap(sprite);//set bitmap image
    }

    // Draw object at specified grid location. Color hexValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, NamedColor colorHex){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        GameGrid[x][y].setImageBitmap(sprite);
        setFGColor(x, y, colorHex);//set bitmap color
    }

    // Draw object at specified grid location. Color rgbValue.
    public void drawObject(int x, int y, NamedSymbol spriteName, int red, int blue, int green){
        Bitmap sprite = setSprite(spriteName);//will get the subimage based on the sprite name
        GameGrid[x][y].setImageBitmap(sprite);
        setFGColor(x, y, red, blue, green);//set the bitmaps color
    }

    // Return grid dimensions to user.
    public int[] getDimensions(){
        return dimensions;
    }

    // Set background color of a grid cell using androidAPI value.
    public void setBGColor(int x, int y, NamedColor colorHex){
        int col = colorHex.getColor();
        GameGrid[x][y].setBackgroundColor(col);
    }

    // Set background colors of a grid cell using rgb values.
    public void setBGColor(int x, int y, int r, int g, int b){
        GameGrid[x][y].setBackgroundColor(Color.rgb(r, g, b));
    }

    // Set foreground color of a grid cell using androidAPI value.
    public void setFGColor(int x, int y, NamedColor colorHex){
        int col = colorHex.getColor();
        GameGrid[x][y].setColorFilter(col);//sets image view to new bitmap
    }

    // Set foreground color of a grid cell using rgb values.
    public void setFGColor(int x, int y, int r, int g, int b){
        //Bitmap sprite = ((BitmapDrawable)GameGrid[x][y].getDrawable()).getBitmap(); //gets the bitmap at certain imageview
        //sprite.eraseColor(Color.rgb(r,g,b));//sets color of pixels to input rgb
        GameGrid[x][y].setColorFilter(Color.rgb(r,g,b));//sets image view to new bitmap
    }

    private Bitmap setSprite(NamedSymbol spriteName){
        switch(spriteName){
            case A:
                subImage = Bitmap.createBitmap(bitmapImage, 1* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case B:
                subImage = Bitmap.createBitmap(bitmapImage, 2* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case C:
                subImage = Bitmap.createBitmap(bitmapImage, 3* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case D:
                subImage = Bitmap.createBitmap(bitmapImage, 4* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case E:
                subImage = Bitmap.createBitmap(bitmapImage, 5* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case F:
                subImage = Bitmap.createBitmap(bitmapImage, 6* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case G:
                subImage = Bitmap.createBitmap(bitmapImage, 7* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case H:
                subImage = Bitmap.createBitmap(bitmapImage, 8* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case I:
                subImage = Bitmap.createBitmap(bitmapImage, 9* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case J:
                subImage = Bitmap.createBitmap(bitmapImage, 10* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
    /**
            case K:
                subImage = Bitmap.createBitmap(bitmapImage, 11* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case L:
                subImage = Bitmap.createBitmap(bitmapImage, 12* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case M:
                subImage = Bitmap.createBitmap(bitmapImage, 13* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case N:
                subImage = Bitmap.createBitmap(bitmapImage, 14* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case O:
                subImage = Bitmap.createBitmap(bitmapImage, 15* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case P:
                subImage = Bitmap.createBitmap(bitmapImage, 16* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case Q:
                subImage = Bitmap.createBitmap(bitmapImage, 17* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case R:
                subImage = Bitmap.createBitmap(bitmapImage, 18* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case S:
                subImage = Bitmap.createBitmap(bitmapImage, 19* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case T:
                subImage = Bitmap.createBitmap(bitmapImage, 20* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case U:
                subImage = Bitmap.createBitmap(bitmapImage, 21* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case V:
                subImage = Bitmap.createBitmap(bitmapImage, 22* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case W:
                subImage = Bitmap.createBitmap(bitmapImage, 23* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case X:
                subImage = Bitmap.createBitmap(bitmapImage, 24* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case Y:
                subImage = Bitmap.createBitmap(bitmapImage, 25* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case Z:
                subImage = Bitmap.createBitmap(bitmapImage, 26* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case a:
                subImage = Bitmap.createBitmap(bitmapImage, 27* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case b:
                subImage = Bitmap.createBitmap(bitmapImage, 28* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case c:
                subImage = Bitmap.createBitmap(bitmapImage, 29* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case d:
                subImage = Bitmap.createBitmap(bitmapImage, 30* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case e:
                subImage = Bitmap.createBitmap(bitmapImage, 31* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case f:
                subImage = Bitmap.createBitmap(bitmapImage, 32* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case g:
                subImage = Bitmap.createBitmap(bitmapImage, 33* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case h:
                subImage = Bitmap.createBitmap(bitmapImage, 34* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case i:
                subImage = Bitmap.createBitmap(bitmapImage, 35* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case j:
                subImage = Bitmap.createBitmap(bitmapImage, 36* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case k:
                subImage = Bitmap.createBitmap(bitmapImage, 37* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case l:
                subImage = Bitmap.createBitmap(bitmapImage, 38* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case m:
                subImage = Bitmap.createBitmap(bitmapImage, 39* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case n:
                subImage = Bitmap.createBitmap(bitmapImage, 40* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case o:
                subImage = Bitmap.createBitmap(bitmapImage, 41* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case p:
                subImage = Bitmap.createBitmap(bitmapImage, 42* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case q:
                subImage = Bitmap.createBitmap(bitmapImage, 43* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case r:
                subImage = Bitmap.createBitmap(bitmapImage, 44* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case s:
                subImage = Bitmap.createBitmap(bitmapImage, 45* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case t:
                subImage = Bitmap.createBitmap(bitmapImage, 46* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case u:
                subImage = Bitmap.createBitmap(bitmapImage, 47* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case v:
                subImage = Bitmap.createBitmap(bitmapImage, 48* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case w:
                subImage = Bitmap.createBitmap(bitmapImage, 49* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case x:
                subImage = Bitmap.createBitmap(bitmapImage, 50* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case y:
                subImage = Bitmap.createBitmap(bitmapImage, 51* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case z:
                subImage = Bitmap.createBitmap(bitmapImage, 52* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case zero:
                subImage = Bitmap.createBitmap(bitmapImage, 53* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case one:
                subImage = Bitmap.createBitmap(bitmapImage, 54* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case two:
                subImage = Bitmap.createBitmap(bitmapImage, 55* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case three:
                subImage = Bitmap.createBitmap(bitmapImage, 56* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case four:
                subImage = Bitmap.createBitmap(bitmapImage, 57* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case five:
                subImage = Bitmap.createBitmap(bitmapImage, 58* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case six:
                subImage = Bitmap.createBitmap(bitmapImage, 59* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case seven:
                subImage = Bitmap.createBitmap(bitmapImage, 60* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case eight:
                subImage = Bitmap.createBitmap(bitmapImage, 61* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case nine:
                subImage = Bitmap.createBitmap(bitmapImage, 62* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case circle:
                subImage = Bitmap.createBitmap(bitmapImage, 63* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case square:
                subImage = Bitmap.createBitmap(bitmapImage, 64* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case diamond:
                subImage = Bitmap.createBitmap(bitmapImage, 65* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case downtriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 66* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case uptriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 67* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case lefttriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 68* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case righttriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 69* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case man:
                subImage = Bitmap.createBitmap(bitmapImage, 70* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case woman:
                subImage = Bitmap.createBitmap(bitmapImage, 71* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case cat:
                subImage = Bitmap.createBitmap(bitmapImage, 72* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case pawn:
                subImage = Bitmap.createBitmap(bitmapImage, 73* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bishop:
                subImage = Bitmap.createBitmap(bitmapImage, 74* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case knight:
                subImage = Bitmap.createBitmap(bitmapImage, 75* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case king:
                subImage = Bitmap.createBitmap(bitmapImage, 76* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case queen:
                subImage = Bitmap.createBitmap(bitmapImage, 77* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case rook:
                subImage = Bitmap.createBitmap(bitmapImage, 78* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case rightarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 79* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case leftarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 80* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case uparrow:
                subImage = Bitmap.createBitmap(bitmapImage, 81* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case downarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 82* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case hexagram:
                subImage = Bitmap.createBitmap(bitmapImage, 83* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case droplet:
                subImage = Bitmap.createBitmap(bitmapImage, 84* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case heart:
                subImage = Bitmap.createBitmap(bitmapImage, 85* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case lightning:
                subImage = Bitmap.createBitmap(bitmapImage, 86* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case thoughtcloud:
                subImage = Bitmap.createBitmap(bitmapImage, 87* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case speechbubble:
                subImage = Bitmap.createBitmap(bitmapImage, 88* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case flower:
                subImage = Bitmap.createBitmap(bitmapImage, 89* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case stripedsquare:
                subImage = Bitmap.createBitmap(bitmapImage, 90* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case screw:
                subImage = Bitmap.createBitmap(bitmapImage, 91* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case xcircle:
                subImage = Bitmap.createBitmap(bitmapImage, 92* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case diamondtop:
                subImage = Bitmap.createBitmap(bitmapImage, 93* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case sword:
                subImage = Bitmap.createBitmap(bitmapImage, 94* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case viking:
                subImage = Bitmap.createBitmap(bitmapImage, 95* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case space:
                subImage = Bitmap.createBitmap(bitmapImage, 96* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case crosshair:
                subImage = Bitmap.createBitmap(bitmapImage, 97* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case waves:
                subImage = Bitmap.createBitmap(bitmapImage, 98* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case rain:
                subImage = Bitmap.createBitmap(bitmapImage, 99* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case drink:
                subImage = Bitmap.createBitmap(bitmapImage, 100* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case paperclip:
                subImage = Bitmap.createBitmap(bitmapImage, 101* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case elephant:
                subImage = Bitmap.createBitmap(bitmapImage, 102* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case cowboyhat:
                subImage = Bitmap.createBitmap(bitmapImage, 103* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case hat:
                subImage = Bitmap.createBitmap(bitmapImage, 104* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case flag:
                subImage = Bitmap.createBitmap(bitmapImage, 105* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bomb:
                subImage = Bitmap.createBitmap(bitmapImage, 106* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case polarbear:
                subImage = Bitmap.createBitmap(bitmapImage, 107* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case giraffe:
                subImage = Bitmap.createBitmap(bitmapImage, 108* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bug1:
                subImage = Bitmap.createBitmap(bitmapImage, 109* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bug2:
                subImage = Bitmap.createBitmap(bitmapImage, 110* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bug3:
                subImage = Bitmap.createBitmap(bitmapImage, 111* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case fish:
                subImage = Bitmap.createBitmap(bitmapImage, 113* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case duck:
                subImage = Bitmap.createBitmap(bitmapImage, 114* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case sloth:
                subImage = Bitmap.createBitmap(bitmapImage, 115* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bird:
                subImage = Bitmap.createBitmap(bitmapImage, 116* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case apple:
                subImage = Bitmap.createBitmap(bitmapImage, 117* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case carrot:
                subImage = Bitmap.createBitmap(bitmapImage, 118* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case lemon:
                subImage = Bitmap.createBitmap(bitmapImage, 110* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case pumpkin:
                subImage = Bitmap.createBitmap(bitmapImage, 120* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case onion:
                subImage = Bitmap.createBitmap(bitmapImage, 108* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case potionbottle:
                subImage = Bitmap.createBitmap(bitmapImage, 109* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case potion:
                subImage = Bitmap.createBitmap(bitmapImage, 110* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case bowarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 111* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case magnifying:
                subImage = Bitmap.createBitmap(bitmapImage, 112* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case fire:
                subImage = Bitmap.createBitmap(bitmapImage, 113* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case boldO:
                subImage = Bitmap.createBitmap(bitmapImage, 114* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
            case monitor:
                subImage = Bitmap.createBitmap(bitmapImage, 114* WIDTH, 0* HEIGHT ,WIDTH ,HEIGHT);
                break;
  **/
        }
        return subImage;
    }
}

package com.example.bridgesgametest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public enum NamedSymbol {
    none,
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z,
    a,
    b,
    c,
    d,
    e,
    f,
    g,
    h,
    i,
    j,
    k,
    l,
    m,
    n,
    o,
    p,
    q,
    r,
    s,
    t,
    u,
    v,
    w,
    x,
    y,
    z,
    zero,
    one,
    two,
    three,
    four,
    five,
    six,
    seven,
    eight,
    nine,
    empty0,
    circle,
    square,
    diamond,
    triangle_down,
    triangle_up,
    triangle_left,
    triangle_right,
    man,
    woman,
    cat,
    pawn,
    knight,
    bishop,
    rook,
    queen,
    king,
    arrow_right,
    arrow_left,
    arrow_up,
    arrow_down,
    star,
    droplet,
    heart,
    lightning,
    thoughtbubble,
    speechbubble,
    flower,
    square_thatch,
    circle_x,
    circle_x2,
    circle_segment,
    empty1,
    sword,
    horn_helmet,
    astro_helmet,
    target,
    empty2,
    waves,
    rain,
    drink,
    paperclip,
    elephant,
    cowboyhat,
    ballcap,
    flag,
    bomb,
    bear,
    giraffe,
    bug1,
    bug2,
    bug3,
    magnifying_glass,
    fishes,
    duck,
    sloth,
    bird,
    apple,
    carrot,
    lemon,
    pepper,
    onion,
    potion1,
    potion2,
    bow_and_arrow,
    campfire,
    donut,
    monitor;

    // Objects for sprite sheet and selected sprite.
    public Bitmap bitmapImage;
    public Bitmap subImage;

    //width and height for the sprite sheet
    public int WIDTH;
    public int HEIGHT;

    public Bitmap setSprite(Bitmap spriteSheet) {

        // Passed sprite sheet.
        bitmapImage = spriteSheet;

        // Width and height of sprite as compared to sprite sheet.
        WIDTH = bitmapImage.getWidth() / 16;
        HEIGHT = bitmapImage.getHeight() / 16;

        // "this" refers to the NamedSymbol object that is being used to call this method.
        // It will look like:
        // NamedSymbol ns = NamedSymbol.someSymbol;
        // Bitmap myBitmap = ns.setSprite(spriteSheetResourceDrawable);
        switch (this) {
            case none:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case A:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case B:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case C:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case D:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case E:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case F:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case G:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case H:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case I:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case J:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case K:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case L:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case M:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case N:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case O:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case P:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Q:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case R:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case S:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case T:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case U:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case V:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case W:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case X:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Y:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Z:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case a:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case b:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case c:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case d:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case e:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case f:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case g:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case h:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case i:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case j:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case k:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case l:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case m:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case n:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case o:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case p:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case q:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case r:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case s:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case t:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case u:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT);
                break;
            case v:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case w:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case x:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case y:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case z:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case zero:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case one:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case two:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case three:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case four:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case five:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case six:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case seven:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case eight:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case nine:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case empty0:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT);
                break;
            case circle:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case square:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case diamond:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case triangle_down:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case triangle_up:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case triangle_left:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case triangle_right:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case man:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case woman:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case cat:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case pawn:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case knight:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bishop:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case rook:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case queen:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case king:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT);
                break;
            case arrow_right:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case arrow_left:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case arrow_up:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case arrow_down:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case star:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case droplet:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case heart:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case lightning:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case thoughtbubble:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case speechbubble:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case flower:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case square_thatch:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case circle_x:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case circle_x2:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case circle_segment:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case empty1:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT);
                break;
            case sword:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case horn_helmet:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case astro_helmet:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case target:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case empty2:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case waves:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case rain:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case drink:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case paperclip:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case elephant:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case cowboyhat:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case ballcap:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case flag:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bomb:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bear:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case giraffe:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug1:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug2:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug3:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case magnifying_glass:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case fishes:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case duck:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case sloth:
                subImage = Bitmap.createBitmap(bitmapImage, 6 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bird:
                subImage = Bitmap.createBitmap(bitmapImage, 7 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case apple:
                subImage = Bitmap.createBitmap(bitmapImage, 8 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case carrot:
                subImage = Bitmap.createBitmap(bitmapImage, 9 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case lemon:
                subImage = Bitmap.createBitmap(bitmapImage, 10 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case pepper:
                subImage = Bitmap.createBitmap(bitmapImage, 11 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case onion:
                subImage = Bitmap.createBitmap(bitmapImage, 12 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case potion1:
                subImage = Bitmap.createBitmap(bitmapImage, 13 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case potion2:
                subImage = Bitmap.createBitmap(bitmapImage, 14 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bow_and_arrow:
                subImage = Bitmap.createBitmap(bitmapImage, 15 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT);
                break;
            case campfire:
                subImage = Bitmap.createBitmap(bitmapImage, 0 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT);
                break;
            case donut:
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT);
                break;
            case monitor:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT);
                break;
        }
        return subImage;
    }

    // Using NamedSymbol.setColor(NamedColor), the user can change the base color of the bitmap.
    // This bitmap being displayed in an ImageView with a setFGColor() will filter this color while it is
    // inside that ImageView. However, its base color will remain the same and will be shown when it moves out
    // of the filtered ImageView.
    public void setColor(NamedColor color){

        Paint p = new Paint();
        p.setColorFilter(new PorterDuffColorFilter(color.getHex(), PorterDuff.Mode.SRC_IN));
        Canvas c = new Canvas(this.subImage);
        c.drawBitmap(this.subImage, 0, 0, p);

    }
}
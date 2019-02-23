package com.example.bridgesgametest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public enum NamedSymbol {
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
    circle,
    square,
    diamond,
    downtriangle,
    uptriangle,
    lefttriangle,
    righttriangle,
    man,
    woman,
    cat,
    pawn,
    bishop,
    knight,
    king,
    queen,
    rook,
    rightarrow,
    leftarrow,
    uparrow,
    downarrow,
    hexagram,
    droplet,
    heart,
    lightning,
    thoughtcloud,
    speechbubble,
    flower,
    stripedsquare,
    screw,
    xcircle,
    diamondtop,
    sword,
    viking,
    space,
    crosshair,
    waves,
    rain,
    drink,
    paperclip,
    elephant,
    cowboyhat,
    hat,
    flag,
    bomb,
    polarbear,
    giraffe,
    bug1,
    bug2,
    bug3,
    magnifying,
    fish,
    duck,
    sloth,
    bird,
    apple,
    carrot,
    lemon,
    pumpkin,
    onion,
    potionbottle,
    potion,
    bowarrow,
    fire,
    boldO,
    monitor,
    none;

    // Objects for sprite sheet and selected sprite.
    private Bitmap bitmapImage;
    private Bitmap subImage;

    //width and height for the sprite sheet
    private int WIDTH;
    private int HEIGHT;

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
                subImage = Bitmap.createBitmap(bitmapImage, 1 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Q:
                subImage = Bitmap.createBitmap(bitmapImage, 2 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case R:
                subImage = Bitmap.createBitmap(bitmapImage, 3 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case S:
                subImage = Bitmap.createBitmap(bitmapImage, 4 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
            case T:
                subImage = Bitmap.createBitmap(bitmapImage, 5 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT);
                break;
                /**
            case U:
                subImage = Bitmap.createBitmap(bitmapImage, 21 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case V:
                subImage = Bitmap.createBitmap(bitmapImage, 22 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case W:
                subImage = Bitmap.createBitmap(bitmapImage, 23 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case X:
                subImage = Bitmap.createBitmap(bitmapImage, 24 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Y:
                subImage = Bitmap.createBitmap(bitmapImage, 25 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case Z:
                subImage = Bitmap.createBitmap(bitmapImage, 26 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case a:
                subImage = Bitmap.createBitmap(bitmapImage, 27 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case b:
                subImage = Bitmap.createBitmap(bitmapImage, 28 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case c:
                subImage = Bitmap.createBitmap(bitmapImage, 29 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case d:
                subImage = Bitmap.createBitmap(bitmapImage, 30 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case e:
                subImage = Bitmap.createBitmap(bitmapImage, 31 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case f:
                subImage = Bitmap.createBitmap(bitmapImage, 32 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case g:
                subImage = Bitmap.createBitmap(bitmapImage, 33 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case h:
                subImage = Bitmap.createBitmap(bitmapImage, 34 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case i:
                subImage = Bitmap.createBitmap(bitmapImage, 35 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case j:
                subImage = Bitmap.createBitmap(bitmapImage, 36 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case k:
                subImage = Bitmap.createBitmap(bitmapImage, 37 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case l:
                subImage = Bitmap.createBitmap(bitmapImage, 38 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case m:
                subImage = Bitmap.createBitmap(bitmapImage, 39 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case n:
                subImage = Bitmap.createBitmap(bitmapImage, 40 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case o:
                subImage = Bitmap.createBitmap(bitmapImage, 41 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case p:
                subImage = Bitmap.createBitmap(bitmapImage, 42 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case q:
                subImage = Bitmap.createBitmap(bitmapImage, 43 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case r:
                subImage = Bitmap.createBitmap(bitmapImage, 44 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case s:
                subImage = Bitmap.createBitmap(bitmapImage, 45 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case t:
                subImage = Bitmap.createBitmap(bitmapImage, 46 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case u:
                subImage = Bitmap.createBitmap(bitmapImage, 47 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case v:
                subImage = Bitmap.createBitmap(bitmapImage, 48 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case w:
                subImage = Bitmap.createBitmap(bitmapImage, 49 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case x:
                subImage = Bitmap.createBitmap(bitmapImage, 50 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case y:
                subImage = Bitmap.createBitmap(bitmapImage, 51 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case z:
                subImage = Bitmap.createBitmap(bitmapImage, 52 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case zero:
                subImage = Bitmap.createBitmap(bitmapImage, 53 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case one:
                subImage = Bitmap.createBitmap(bitmapImage, 54 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case two:
                subImage = Bitmap.createBitmap(bitmapImage, 55 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case three:
                subImage = Bitmap.createBitmap(bitmapImage, 56 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case four:
                subImage = Bitmap.createBitmap(bitmapImage, 57 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case five:
                subImage = Bitmap.createBitmap(bitmapImage, 58 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case six:
                subImage = Bitmap.createBitmap(bitmapImage, 59 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case seven:
                subImage = Bitmap.createBitmap(bitmapImage, 60 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case eight:
                subImage = Bitmap.createBitmap(bitmapImage, 61 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case nine:
                subImage = Bitmap.createBitmap(bitmapImage, 62 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case circle:
                subImage = Bitmap.createBitmap(bitmapImage, 63 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case square:
                subImage = Bitmap.createBitmap(bitmapImage, 64 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case diamond:
                subImage = Bitmap.createBitmap(bitmapImage, 65 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case downtriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 66 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case uptriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 67 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case lefttriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 68 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case righttriangle:
                subImage = Bitmap.createBitmap(bitmapImage, 69 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case man:
                subImage = Bitmap.createBitmap(bitmapImage, 70 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case woman:
                subImage = Bitmap.createBitmap(bitmapImage, 71 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case cat:
                subImage = Bitmap.createBitmap(bitmapImage, 72 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case pawn:
                subImage = Bitmap.createBitmap(bitmapImage, 73 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bishop:
                subImage = Bitmap.createBitmap(bitmapImage, 74 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case knight:
                subImage = Bitmap.createBitmap(bitmapImage, 75 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case king:
                subImage = Bitmap.createBitmap(bitmapImage, 76 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case queen:
                subImage = Bitmap.createBitmap(bitmapImage, 77 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case rook:
                subImage = Bitmap.createBitmap(bitmapImage, 78 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case rightarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 79 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case leftarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 80 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case uparrow:
                subImage = Bitmap.createBitmap(bitmapImage, 81 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case downarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 82 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case hexagram:
                subImage = Bitmap.createBitmap(bitmapImage, 83 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case droplet:
                subImage = Bitmap.createBitmap(bitmapImage, 84 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case heart:
                subImage = Bitmap.createBitmap(bitmapImage, 85 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case lightning:
                subImage = Bitmap.createBitmap(bitmapImage, 86 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case thoughtcloud:
                subImage = Bitmap.createBitmap(bitmapImage, 87 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case speechbubble:
                subImage = Bitmap.createBitmap(bitmapImage, 88 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case flower:
                subImage = Bitmap.createBitmap(bitmapImage, 89 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case stripedsquare:
                subImage = Bitmap.createBitmap(bitmapImage, 90 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case screw:
                subImage = Bitmap.createBitmap(bitmapImage, 91 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case xcircle:
                subImage = Bitmap.createBitmap(bitmapImage, 92 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case diamondtop:
                subImage = Bitmap.createBitmap(bitmapImage, 93 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case sword:
                subImage = Bitmap.createBitmap(bitmapImage, 94 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case viking:
                subImage = Bitmap.createBitmap(bitmapImage, 95 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case space:
                subImage = Bitmap.createBitmap(bitmapImage, 96 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case crosshair:
                subImage = Bitmap.createBitmap(bitmapImage, 97 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case waves:
                subImage = Bitmap.createBitmap(bitmapImage, 98 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case rain:
                subImage = Bitmap.createBitmap(bitmapImage, 99 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case drink:
                subImage = Bitmap.createBitmap(bitmapImage, 100 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case paperclip:
                subImage = Bitmap.createBitmap(bitmapImage, 101 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case elephant:
                subImage = Bitmap.createBitmap(bitmapImage, 102 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case cowboyhat:
                subImage = Bitmap.createBitmap(bitmapImage, 103 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case hat:
                subImage = Bitmap.createBitmap(bitmapImage, 104 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case flag:
                subImage = Bitmap.createBitmap(bitmapImage, 105 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bomb:
                subImage = Bitmap.createBitmap(bitmapImage, 106 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case polarbear:
                subImage = Bitmap.createBitmap(bitmapImage, 107 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case giraffe:
                subImage = Bitmap.createBitmap(bitmapImage, 108 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug1:
                subImage = Bitmap.createBitmap(bitmapImage, 109 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug2:
                subImage = Bitmap.createBitmap(bitmapImage, 110 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bug3:
                subImage = Bitmap.createBitmap(bitmapImage, 111 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case fish:
                subImage = Bitmap.createBitmap(bitmapImage, 113 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case duck:
                subImage = Bitmap.createBitmap(bitmapImage, 114 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case sloth:
                subImage = Bitmap.createBitmap(bitmapImage, 115 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bird:
                subImage = Bitmap.createBitmap(bitmapImage, 116 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case apple:
                subImage = Bitmap.createBitmap(bitmapImage, 117 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case carrot:
                subImage = Bitmap.createBitmap(bitmapImage, 118 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case lemon:
                subImage = Bitmap.createBitmap(bitmapImage, 110 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case pumpkin:
                subImage = Bitmap.createBitmap(bitmapImage, 120 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case onion:
                subImage = Bitmap.createBitmap(bitmapImage, 108 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case potionbottle:
                subImage = Bitmap.createBitmap(bitmapImage, 109 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case potion:
                subImage = Bitmap.createBitmap(bitmapImage, 110 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case bowarrow:
                subImage = Bitmap.createBitmap(bitmapImage, 111 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case magnifying:
                subImage = Bitmap.createBitmap(bitmapImage, 112 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case fire:
                subImage = Bitmap.createBitmap(bitmapImage, 113 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case boldO:
                subImage = Bitmap.createBitmap(bitmapImage, 114 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
            case monitor:
                subImage = Bitmap.createBitmap(bitmapImage, 114 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT);
                break;
                 **/
        }
        return subImage;
    }
}

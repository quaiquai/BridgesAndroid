package com.example.bridgesgametest;

import android.graphics.Color;

public enum NamedColor {
    aliceblue,
    antiquewhite,
    aqua,
    aquamarine,
    azure,
    beige,
    bisque,
    black,
    blanchedalmond,
    blue,
    blueviolet,
    brown,
    burlywood,
    cadetblue,
    chartreuse,
    chocolate,
    coral,
    cornflowerblue,
    cornsilk,
    crimson,
    cyan,
    darkblue,
    darkcyan,
    darkgoldenrod,
    darkgray,
    darkgreen,
    darkgrey,
    darkkhaki,
    darkmagenta,
    darkolivegreen,
    darkorange,
    darkorchid,
    darkred,
    darksalmon,
    darkseagreen,
    darkslateblue,
    darkslategray,
    darkslategrey,
    darkturquoise,
    darkviolet,
    deeppink,
    deepskyblue,
    dimgray,
    dimgrey,
    dodgerblue,
    firebrick,
    floralwhite,
    forestgreen,
    fuchsia,
    gainsboro,
    ghostwhite,
    gold,
    goldenrod,
    gray,
    grey,
    green,
    greenyellow,
    honeydew,
    hotpink,
    indianred,
    indigo,
    ivory,
    khaki,
    lavender,
    lavenderblush,
    lawngreen,
    lemonchiffon,
    lightblue,
    lightcoral,
    lightcyan,
    lightgoldenrodyellow,
    lightgray,
    lightgreen,
    lightgrey,
    lightpink,
    lightsalmon,
    lightseagreen,
    lightskyblue,
    lightslategray,
    lightslategrey,
    lightsteelblue,
    lightyellow,
    lime,
    limegreen,
    linen,
    magenta,
    maroon,
    mediumaquamarine,
    mediumblue,
    mediumorchid,
    mediumpurple,
    mediumseagreen,
    mediumslateblue,
    mediumspringgreen,
    mediumturquoise,
    mediumvioletred,
    midnightblue,
    mintcream,
    mistyrose,
    moccasin,
    navajowhite,
    navy,
    oldlace,
    olive,
    olivedrab,
    orange,
    orangered,
    orchid,
    palegoldenrod,
    palegreen,
    paleturquoise,
    palevioletred,
    papayawhip,
    peachpuff,
    peru,
    pink,
    plum,
    powderblue,
    purple,
    red,
    rosybrown,
    royalblue,
    saddlebrown,
    salmon,
    sandybrown,
    seagreen,
    seashell,
    sienna,
    silver,
    skyblue,
    slateblue,
    slategray,
    slategrey,
    snow,
    springgreen,
    steelblue,
    tan,
    teal,
    thistle,
    tomato,
    turquoise,
    violet,
    wheat,
    white,
    whitesmoke,
    yellow,
    yellowgreen;

    public int colorHex;
    public int colorRed;
    public int colorGreen;
    public int colorBlue;

    public int getHex(){
        setValues(this);
        return colorHex;
    }

    public int getRed(){
        setValues(this);
        return colorRed;
    }

    public int getGreen(){
        setValues(this);
        return colorGreen;
    }

    public int getBlue(){
        setValues(this);
        return colorBlue;
    }

    private void setValues(NamedColor c){
        switch(c){
            case aliceblue:
                colorHex = Color.parseColor("#f048ff");
                colorRed = 240;
                colorGreen = 248;
                colorBlue = 255;
                break;
            case antiquewhite:
                colorHex = Color.parseColor("#faebd7");
                colorRed = 250;
                colorGreen = 235;
                colorBlue = 215;
                break;
            case aqua:
                colorHex = Color.parseColor("#66cdaa");
                colorRed = 102;
                colorGreen = 205;
                colorBlue = 170;
                break;
            case aquamarine:
                colorHex = Color.parseColor("#7fffd4");
                colorRed = 127;
                colorGreen = 255;
                colorBlue = 212;
                break;
            case azure:
                colorHex = Color.parseColor("#f0ffff");
                colorRed = 240;
                colorGreen = 255;
                colorBlue = 255;
                break;
            case beige:
                colorHex = Color.parseColor("#f5f5dc");
                colorRed = 245;
                colorGreen = 245;
                colorBlue = 220;
                break;
            case bisque:
                colorHex = Color.parseColor("#ffe4c4");
                colorRed = 255;
                colorGreen = 228;
                colorBlue = 196;
                break;
            case black:
                colorHex = Color.parseColor("#000000");
                colorRed = 0;
                colorGreen = 0;
                colorBlue = 0;
                break;
            case blanchedalmond:
                colorHex = Color.parseColor("#ffebcd");
                colorRed = 255;
                colorGreen = 235;
                colorBlue = 205;
                break;
            case blue:
                colorHex = Color.parseColor("#0000ff");
                colorRed = 0;
                colorGreen = 0;
                colorBlue = 255;
                break;
            case blueviolet:
                colorHex = Color.parseColor("#8a2be2");
                colorRed = 138;
                colorGreen = 43;
                colorBlue = 226;
                break;
            case brown:
                colorHex = Color.parseColor("#a52a2a");
                colorRed = 165;
                colorGreen = 42;
                colorBlue = 42;
                break;
            case burlywood:
                colorHex = Color.parseColor("#deb887");
                colorRed = 222;
                colorGreen = 184;
                colorBlue = 135;
                break;
            case cadetblue:
                colorHex = Color.parseColor("#5f9ea0");
                colorRed = 95;
                colorGreen = 158;
                colorBlue = 160;
                break;
            case chartreuse:
                colorHex = Color.parseColor("#7fff00");
                colorRed = 127;
                colorGreen = 255;
                colorBlue = 0;
                break;
            case chocolate:
                colorHex = Color.parseColor("#d2691e");
                colorRed = 210;
                colorGreen = 105;
                colorBlue = 30;
                break;
            case coral:
                colorHex = Color.parseColor("#ff7f50");
                colorRed = 255;
                colorGreen = 127;
                colorBlue = 80;
                break;
            case cornflowerblue:
                colorHex = Color.parseColor("#6495ed");
                colorRed = 100;
                colorGreen = 149;
                colorBlue = 237;
                break;
            case cornsilk:
                colorHex = Color.parseColor("#fff8dc");
                colorRed = 255;
                colorGreen = 248;
                colorBlue = 220;
                break;
            case crimson:
                colorHex = Color.parseColor("#990000");
                colorRed = 153;
                colorGreen = 0;
                colorBlue = 0;
                break;
            case cyan:
                colorHex = Color.parseColor("#00ffff");
                colorRed = 0;
                colorGreen = 255;
                colorBlue = 255;
                break;
            case darkblue:
                colorHex = Color.parseColor("#191970");
                colorRed = 25;
                colorGreen = 25;
                colorBlue = 112;
                break;
            case darkcyan:
                colorHex = Color.parseColor("#008B8B");
                colorRed = 0;
                colorGreen = 139;
                colorBlue = 139;
                break;
            case darkgoldenrod:
                colorHex = Color.parseColor("#b8860b");
                colorRed = 184;
                colorGreen = 134;
                colorBlue = 11;
                break;
            case darkgray:
                colorHex = Color.parseColor("#A9A9A9");
                colorRed = 192;
                colorGreen = 192;
                colorBlue = 192;
                break;
            case darkgreen:
                colorHex = Color.parseColor("#006400");
                colorRed = 0;
                colorGreen = 100;
                colorBlue = 0;
                break;
            case darkgrey:
                colorHex = Color.parseColor("#A9A9A9");
                colorRed = 192;
                colorGreen = 192;
                colorBlue = 192;
                break;
            case darkkhaki:
                colorHex = Color.parseColor("#bdb76b");
                colorRed = 189;
                colorGreen = 183;
                colorBlue = 107;
                break;
            case darkmagenta:
                colorHex = Color.parseColor("#FF00FF");
                colorRed = 255;
                colorGreen = 0;
                colorBlue = 255;
                break;
            case darkolivegreen:
                colorHex = Color.parseColor("#556B2F");
                colorRed = 85;
                colorGreen = 107;
                colorBlue = 35;
                break;
            case darkorange:
                colorHex = Color.parseColor("#FF8C00");
                colorRed = 255;
                colorGreen = 140;
                colorBlue = 0;
                break;
            case darkorchid:
                colorHex = Color.parseColor("#9932CC");
                colorRed = 153;
                colorGreen = 50;
                colorBlue = 204;
                break;
            case darkred:
                colorHex = Color.parseColor("#8B0000");
                colorRed = 139;
                colorGreen = 0;
                colorBlue = 0;
                break;
            case darksalmon:
                colorHex = Color.parseColor("#E9967A");
                colorRed = 233;
                colorGreen = 150;
                colorBlue = 122;
                break;
            case darkseagreen:
                colorHex = Color.parseColor("#8FBC8F");
                colorRed = 143;
                colorGreen = 188;
                colorBlue = 143;
                break;
            case darkslateblue:
                colorHex = Color.parseColor("#483D8B");
                colorRed = 72;
                colorGreen = 61;
                colorBlue = 139;
                break;
            case darkslategray:
                colorHex = Color.parseColor("#2F4F4F");
                colorRed = 47;
                colorGreen = 79;
                colorBlue = 79;
                break;
            case darkslategrey:
                colorHex = Color.parseColor("#2F4F4F");
                colorRed = 47;
                colorGreen = 79;
                colorBlue = 79;
                break;
            case darkturquoise:
                colorHex = Color.parseColor("#00CED1");
                colorRed = 0;
                colorGreen = 206;
                colorBlue = 209;
                break;
            case darkviolet:
                colorHex = Color.parseColor("#9400D3");
                colorRed = 148;
                colorGreen = 0;
                colorBlue = 211;
                break;
            case deeppink:
                colorHex = Color.parseColor("#FF1493");
                colorRed = 255;
                colorGreen = 20;
                colorBlue = 147;
                break;
            case deepskyblue:
                colorHex = Color.parseColor("#00BFFF");
                colorRed = 0;
                colorGreen = 191;
                colorBlue = 255;
                break;
            case dimgray:
                colorHex = Color.parseColor("#696969");
                colorRed = 105;
                colorGreen = 105;
                colorBlue = 105;
                break;
            case dimgrey:
                colorHex = Color.parseColor("#696969");
                colorRed = 105;
                colorGreen = 105;
                colorBlue = 105;
                break;
            case dodgerblue:
                colorHex = Color.parseColor("#1E90FF");
                colorRed = 30;
                colorGreen = 144;
                colorBlue = 255;
                break;
            case firebrick:
                colorHex = Color.parseColor("#B22222");
                colorRed = 178;
                colorGreen = 34;
                colorBlue = 34;
                break;
            case floralwhite:
                colorHex = Color.parseColor("#FFFAF0");
                colorRed = 255;
                colorGreen = 250;
                colorBlue = 240;
                break;
            case forestgreen:
                colorHex = Color.parseColor("#228B22");
                colorRed = 34;
                colorGreen = 139;
                colorBlue = 34;
                break;
            case fuchsia:
                colorHex = Color.parseColor("#FF00FF");
                colorRed = 255;
                colorGreen = 0;
                colorBlue = 255;
                break;
            case gainsboro:
                colorHex = Color.parseColor("#DCDCDC");
                colorRed = 220;
                colorGreen = 220;
                colorBlue = 220;
                break;
            case ghostwhite:
                colorHex = Color.parseColor("#F8F8FF");
                colorRed = 248;
                colorGreen = 248;
                colorBlue = 255;
                break;
            case gold:
                colorHex = Color.parseColor("#FFD700");
                colorRed = 255;
                colorGreen = 215;
                colorBlue = 0;
                break;
            case goldenrod:
                colorHex = Color.parseColor("#DAA520");
                colorRed = 218;
                colorGreen = 165;
                colorBlue = 32;
                break;
            case gray:
                colorHex = Color.parseColor("#808080");
                colorRed = 128;
                colorGreen = 128;
                colorBlue = 128;
                break;
            case grey:
                colorHex = Color.parseColor("#808080");
                colorRed = 128;
                colorGreen = 128;
                colorBlue = 128;
                break;
            case green:
                colorHex = Color.parseColor("#008000");
                colorRed = 0;
                colorGreen = 128;
                colorBlue = 0;
                break;
            case greenyellow:
                colorHex = Color.parseColor("#ADFF2F");
                colorRed = 173;
                colorGreen = 255;
                colorBlue = 47;
                break;
            case honeydew:
                colorHex = Color.parseColor("#F0FFF0");
                colorRed = 240;
                colorGreen = 255;
                colorBlue = 240;
                break;
            case hotpink:
                colorHex = Color.parseColor("#FF69B4");
                colorRed = 255;
                colorGreen = 105;
                colorBlue = 180;
                break;
            case indianred:
                colorHex = Color.parseColor("#CD5C5C");
                colorRed = 205;
                colorGreen = 92;
                colorBlue = 92;
                break;
            case indigo:
                colorHex = Color.parseColor("#4B0082");
                colorRed = 75;
                colorGreen = 0;
                colorBlue = 130;
                break;
            case ivory:
                colorHex = Color.parseColor("#FFFFF0");
                colorRed = 255;
                colorGreen = 255;
                colorBlue = 240;
                break;
            case khaki:
                colorHex = Color.parseColor("#F0E68C");
                colorRed = 240;
                colorGreen = 230;
                colorBlue = 140;
                break;
            case lavender:
                colorHex = Color.parseColor("#E6E6FA");
                colorRed = 230;
                colorGreen = 230;
                colorBlue = 250;
                break;
            case lavenderblush:
                colorHex = Color.parseColor("#FFF0F5");
                colorRed = 255;
                colorGreen = 240;
                colorBlue = 245;
                break;
            case lawngreen:
                colorHex = Color.parseColor("#7CFC00");
                colorRed = 124;
                colorGreen = 252;
                colorBlue = 0;
                break;
            case lemonchiffon:
                colorHex = Color.parseColor("#FFFACD");
                colorRed = 255;
                colorGreen = 250;
                colorBlue = 205;
                break;
            case lightblue:
                colorHex = Color.parseColor("#ADD8E6");
                colorRed = 173;
                colorGreen = 216;
                colorBlue = 230;
                break;
            case lightcoral:
                colorHex = Color.parseColor("#F08080");
                colorRed = 240;
                colorGreen = 128;
                colorBlue = 128;
                break;
            case lightcyan:
                colorHex = Color.parseColor("#E0FFFF");
                colorRed = 224;
                colorGreen = 255;
                colorBlue = 255;
                break;
            case lightgoldenrodyellow:
                colorHex = Color.parseColor("#FAFAD2");
                colorRed = 250;
                colorGreen = 250;
                colorBlue = 210;
                break;
            case lightgray:
                colorHex = Color.parseColor("#D3D3D3");
                colorRed = 211;
                colorGreen = 211;
                colorBlue = 211;
                break;
            case lightgreen:
                colorHex = Color.parseColor("#90EE90");
                colorRed = 144;
                colorGreen = 238;
                colorBlue = 144;
                break;
            case lightgrey:
                colorHex = Color.parseColor("#D3D3D3");
                colorRed = 211;
                colorGreen = 211;
                colorBlue = 211;
                break;
            case lightpink:
                colorHex = Color.parseColor("#FFB6C1");
                colorRed = 255;
                colorGreen = 182;
                colorBlue = 193;
                break;
            case lightsalmon:
                colorHex = Color.parseColor("#FFA07A");
                colorRed = 255;
                colorGreen = 160;
                colorBlue = 122;
                break;
            case lightseagreen:
                colorHex = Color.parseColor("#20B2AA");
                colorRed = 32;
                colorGreen = 178;
                colorBlue = 170;
                break;
            case lightskyblue:
                colorHex = Color.parseColor("#87CEFA");
                colorRed = 135;
                colorGreen = 206;
                colorBlue = 250;
                break;
            case lightslategray:
                colorHex = Color.parseColor("#778899");
                colorRed = 119;
                colorGreen = 136;
                colorBlue = 153;
                break;
            case lightslategrey:
                colorHex = Color.parseColor("#778899");
                colorRed = 119;
                colorGreen = 136;
                colorBlue = 153;
                break;
            case lightsteelblue:
                colorHex = Color.parseColor("#B0C4DE");
                colorRed = 176;
                colorGreen = 196;
                colorBlue = 222;
                break;
            case lightyellow:
                colorHex = Color.parseColor("#FFFFE0");
                colorRed = 255;
                colorGreen = 255;
                colorBlue = 224;
                break;
            case lime:
                colorHex = Color.parseColor("#00FF00");
                colorRed = 0;
                colorGreen = 255;
                colorBlue = 0;
                break;
            case limegreen:
                colorHex = Color.parseColor("#32CD32");
                colorRed = 50;
                colorGreen = 205;
                colorBlue = 50;
                break;
            case linen:
                colorHex = Color.parseColor("#FAF0E6");
                colorRed = 250;
                colorGreen = 240;
                colorBlue = 230;
                break;
            case magenta:
                colorHex = Color.parseColor("#FF00FF");
                colorRed = 255;
                colorGreen = 0;
                colorBlue = 255;
                break;
            case maroon:
                colorHex = Color.parseColor("#800000");
                colorRed = 128;
                colorGreen = 0;
                colorBlue = 0;
                break;
            case mediumaquamarine:
                colorHex = Color.parseColor("#66CDAA");
                colorRed = 102;
                colorGreen = 205;
                colorBlue = 170;
                break;
            case mediumblue:
                colorHex = Color.parseColor("#0000CD");
                colorRed = 0;
                colorGreen = 0;
                colorBlue = 205;
                break;
            case mediumorchid:
                colorHex = Color.parseColor("#BA55D3");
                colorRed = 186;
                colorGreen = 85;
                colorBlue = 211;
                break;
            case mediumpurple:
                colorHex = Color.parseColor("#9370DB");
                colorRed = 147;
                colorGreen = 43;
                colorBlue = 226;
                break;
            case mediumseagreen:
                colorHex = Color.parseColor("#3CB371");
                colorRed = 60;
                colorGreen = 179;
                colorBlue = 113;
                break;
            case mediumslateblue:
                colorHex = Color.parseColor("#7B68EE");
                colorRed = 123;
                colorGreen = 104;
                colorBlue = 238;
                break;
            case mediumspringgreen:
                colorHex = Color.parseColor("#00FA9A");
                colorRed = 0;
                colorGreen = 250;
                colorBlue = 154;
                break;
            case mediumturquoise:
                colorHex = Color.parseColor("#48D1CC");
                colorRed = 72;
                colorGreen = 209;
                colorBlue = 204;
                break;
            case mediumvioletred:
                colorHex = Color.parseColor("#C71585");
                colorRed = 199;
                colorGreen = 21;
                colorBlue = 133;
                break;
            case midnightblue:
                colorHex = Color.parseColor("#191970");
                colorRed = 25;
                colorGreen = 25;
                colorBlue = 112;
                break;
            case mintcream:
                colorHex = Color.parseColor("#F5FFFA");
                colorRed = 245;
                colorGreen = 255;
                colorBlue = 250;
                break;
            case mistyrose:
                colorHex = Color.parseColor("#FFE4E1");
                colorRed = 255;
                colorGreen = 228;
                colorBlue = 225;
                break;
            case moccasin:
                colorHex = Color.parseColor("#FFE4B5");
                colorRed = 225;
                colorGreen = 228;
                colorBlue = 181;
                break;
            case navajowhite:
                colorHex = Color.parseColor("#FFDEAD");
                colorRed = 255;
                colorGreen = 222;
                colorBlue = 173;
                break;
            case navy:
                colorHex = Color.parseColor("#000080");
                colorRed = 0;
                colorGreen = 0;
                colorBlue = 128;
                break;
            case oldlace:
                colorHex = Color.parseColor("#FDF5E6");
                colorRed = 253;
                colorGreen = 245;
                colorBlue = 230;
                break;
            case olive:
                colorHex = Color.parseColor("#808000");
                colorRed = 128;
                colorGreen = 128;
                colorBlue = 0;
                break;
            case olivedrab:
                colorHex = Color.parseColor("#6B8E23");
                colorRed = 107;
                colorGreen = 142;
                colorBlue = 35;
                break;
            case orange:
                colorHex = Color.parseColor("#FFA500");
                colorRed = 255;
                colorGreen = 165;
                colorBlue = 0;
                break;
            case orangered:
                colorHex = Color.parseColor("#FF4500");
                colorRed = 255;
                colorGreen = 69;
                colorBlue = 0;
                break;
            case orchid:
                colorHex = Color.parseColor("#DA70D6");
                colorRed = 218;
                colorGreen = 112;
                colorBlue = 214;
                break;
            case palegoldenrod:
                colorHex = Color.parseColor("#EEE8AA");
                colorRed = 238;
                colorGreen = 232;
                colorBlue = 170;
                break;
            case palegreen:
                colorHex = Color.parseColor("#98FB98");
                colorRed = 152;
                colorGreen = 251;
                colorBlue = 152;
                break;
            case paleturquoise:
                colorHex = Color.parseColor("#AFEEEE");
                colorRed = 175;
                colorGreen = 238;
                colorBlue = 238;
                break;
            case palevioletred:
                colorHex = Color.parseColor("#DB7093");
                colorRed = 219;
                colorGreen = 112;
                colorBlue = 147;
                break;
            case papayawhip:
                colorHex = Color.parseColor("#FFEFD5");
                colorRed = 255;
                colorGreen = 239;
                colorBlue = 213;
                break;
            case peachpuff:
                colorHex = Color.parseColor("#FFDAB9");
                colorRed = 255;
                colorGreen = 218;
                colorBlue = 185;
                break;
            case peru:
                colorHex = Color.parseColor("#CD853F");
                colorRed = 205;
                colorGreen = 133;
                colorBlue = 63;
                break;
            case pink:
                colorHex = Color.parseColor("#FFC0CB");
                colorRed = 255;
                colorGreen = 192;
                colorBlue = 203;
                break;
            case plum:
                colorHex = Color.parseColor("#DDA0DD");
                colorRed = 221;
                colorGreen = 160;
                colorBlue = 221;
                break;
            case powderblue:
                colorHex = Color.parseColor("#B0E0E6");
                colorRed = 176;
                colorGreen = 224;
                colorBlue = 230;
                break;
            case purple:
                colorHex = Color.parseColor("#800080");
                colorRed = 128;
                colorGreen = 0;
                colorBlue = 128;
                break;
            case red:
                colorHex = Color.parseColor("#FF0000");
                colorRed = 255;
                colorGreen = 0;
                colorBlue = 0;
                break;
            case rosybrown:
                colorHex = Color.parseColor("#BC8F8F");
                colorRed = 188;
                colorGreen = 143;
                colorBlue = 143;
                break;
            case royalblue:
                colorHex = Color.parseColor("#4169E1");
                colorRed = 65;
                colorGreen = 105;
                colorBlue = 225;
                break;
            case saddlebrown:
                colorHex = Color.parseColor("#8B4513");
                colorRed = 139;
                colorGreen = 69;
                colorBlue = 19;
                break;
            case salmon:
                colorHex = Color.parseColor("#FA8072");
                colorRed = 250;
                colorGreen = 128;
                colorBlue = 114;
                break;
            case sandybrown:
                colorHex = Color.parseColor("#F4A460");
                colorRed = 244;
                colorGreen = 164;
                colorBlue = 96;
                break;
            case seagreen:
                colorHex = Color.parseColor("#2E8B57");
                colorRed = 46;
                colorGreen = 139;
                colorBlue = 87;
                break;
            case seashell:
                colorHex = Color.parseColor("#FFF5EE");
                colorRed = 255;
                colorGreen = 245;
                colorBlue = 238;
                break;
            case sienna:
                colorHex = Color.parseColor("#A0522D");
                colorRed = 160;
                colorGreen = 82;
                colorBlue = 45;
                break;
            case silver:
                colorHex = Color.parseColor("#C0C0C0");
                colorRed = 192;
                colorGreen = 192;
                colorBlue = 192;
                break;
            case skyblue:
                colorHex = Color.parseColor("#87CEEB");
                colorRed = 135;
                colorGreen = 206;
                colorBlue = 235;
                break;
            case slateblue:
                colorHex = Color.parseColor("#6A5ACD");
                colorRed = 106;
                colorGreen = 90;
                colorBlue = 205;
                break;
            case slategray:
                colorHex = Color.parseColor("#708090");
                colorRed = 112;
                colorGreen = 128;
                colorBlue = 144;
                break;
            case slategrey:
                colorHex = Color.parseColor("#708090");
                colorRed = 112;
                colorGreen = 128;
                colorBlue = 144;
                break;
            case snow:
                colorHex = Color.parseColor("#FFFAFA");
                colorRed = 255;
                colorGreen = 250;
                colorBlue = 250;
                break;
            case springgreen:
                colorHex = Color.parseColor("#00FF7F");
                colorRed = 0;
                colorGreen = 255;
                colorBlue = 127;
                break;
            case steelblue:
                colorHex = Color.parseColor("#4682B4");
                colorRed = 70;
                colorGreen = 130;
                colorBlue = 180;
                break;
            case tan:
                colorHex = Color.parseColor("#D2B48C");
                colorRed = 210;
                colorGreen = 180;
                colorBlue = 140;
                break;
            case teal:
                colorHex = Color.parseColor("#008080");
                colorRed = 0;
                colorGreen = 128;
                colorBlue = 128;
                break;
            case thistle:
                colorHex = Color.parseColor("#D8BFD8");
                colorRed = 216;
                colorGreen = 191;
                colorBlue = 216;
                break;
            case tomato:
                colorHex = Color.parseColor("#FF6347");
                colorRed = 255;
                colorGreen = 99;
                colorBlue = 71;
                break;
            case turquoise:
                colorHex = Color.parseColor("#40E0D0");
                colorRed = 64;
                colorGreen = 224;
                colorBlue = 208;
                break;
            case violet:
                colorHex = Color.parseColor("#EE82EE");
                colorRed = 238;
                colorGreen = 130;
                colorBlue = 238;
                break;
            case wheat:
                colorHex = Color.parseColor("#F5DEB3");
                colorRed = 245;
                colorGreen = 222;
                colorBlue = 179;
                break;
            case white:
                colorHex = Color.parseColor("#FFFFFF");
                colorRed = 255;
                colorGreen = 255;
                colorBlue = 255;
                break;
            case whitesmoke:
                colorHex = Color.parseColor("#F5F5F5");
                colorRed = 245;
                colorGreen = 245;
                colorBlue = 245;
                break;
            case yellow:
                colorHex = Color.parseColor("#FFFF00");
                colorRed = 255;
                colorGreen = 255;
                colorBlue = 0;
                break;
            case yellowgreen:
                colorHex = Color.parseColor("#9ACD32");
                colorRed = 154;
                colorGreen = 205;
                colorBlue = 50;
                break;
        }
    }
}
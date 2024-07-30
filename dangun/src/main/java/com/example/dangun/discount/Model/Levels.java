package com.example.dangun.discount.Model;

public enum Levels {

    LV1(5),
    LV2(10),
    LV3(15),
    LV4(20),
    LV5(25);

    private int discount;

    Levels(int discount){
        this.discount=discount;
    }

    public static int getDiscount(int level) {

        if (level==1){
            return LV1.discount;
        }
        if (level==2){
            return LV2.discount;
        }
        if (level==3){
            return LV3.discount;
        }
        if (level==4){
            return LV4.discount;
        }
        if (level==5){
            return LV5.discount;
        }

        return 0;
    }


}

package de.noobstudios.cardgame.Controllers;

import de.noobstudios.cardgame.Controllers.Types.CardTypes;

public class CardTypeTransformer {
    static final int[] zeroNums = new int[] {49, 45, 41, 37, 33, 29, 25, 21, 17, 13, 9, 5, 1, 0};
    static final int[] compNums = new int[] {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    /**
     * @param card Card to Convert
     * @return  BaseWeight of Card (from total count of cards int @CardTypes)
     */
    public static int getIntOfBaseGroupEnum(CardTypes card) {
        int cardValue = card.ordinal();
        for (int zeroNum : zeroNums) {
            if (zeroNum <= cardValue) return zeroNum;
        }
        return -1;
    }

    /**
     * @param card Card to get Weight from.
     * @return Absolute weight in comparison to the other cards and the similar weights of the symbols
     */
    public static int getWeightOfBaseGroup(CardTypes card) {
        int tmp = getIntOfBaseGroupEnum(card);
        if (zeroNums.length == compNums.length) {
            for (int i = 0; i < compNums.length; ++i) {
                if (zeroNums[i] == tmp){
                    return compNums[i];
                }
            }
        }
        else return -2;
        return -1;
    }
}

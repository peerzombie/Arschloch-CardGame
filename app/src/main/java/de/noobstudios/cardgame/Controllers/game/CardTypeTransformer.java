/*
 * Copyright (C) 2015 Peer Bölts
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package de.noobstudios.cardgame.Controllers.game;

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

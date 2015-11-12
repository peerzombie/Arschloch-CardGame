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

package de.noobstudios.cardgame.Controllers.Types;


public enum CardTypes {
    //TODO Finish and Check Cards
    //Sondersachen
    Joker,

    //INFO Joker = 0, Everything else is 0+Num-posInArray(PikSchwartz=0, KaroRot=1, HerzRot=2, KreutzSchwarz=3);
    //2
    PikSchwarz2, //1
    KaroRot2,
    HerzRot2,
    KreutzSchwarz2,

    //3
    PikSchwarz3, //5
    KaroRot3,
    HerzRot3,
    KreutzSchwarz3,

    //4
    PikSchwarz4, //9
    KaroRot4,
    HerzRot4,
    KreutzSchwarz4,

    //5
    PikSchwarz5, //13
    KaroRot5,
    HerzRot5,
    KreutzSchwarz5,

    //6
    PikSchwarz6, //17
    KaroRot6,
    HerzRot6,
    KreutzSchwarz6,

    //7
    PikSchwarz7, //21
    KaroRot7,
    HerzRot7,
    KreutzSchwarz7,

    //8
    PikSchwarz8, //25
    KaroRot8,
    HerzRot8,
    KreutzSchwarz8,

    //9
    PikSchwarz9, //29
    KaroRot9,
    HerzRot9,
    KreutzSchwarz9,

    //10
    PikSchwarz10, //33
    KaroRot10,
    HerzRot10,
    KreutzSchwarz10,

    //Bube
    PikSchwarzBube, //37
    KaroRotBube,
    HerzRotBube,
    KreutzSchwarzBube,

    //Dame
    PikSchwarzDame, //41
    KaroRotDame,
    HerzRotDame,
    KreutzSchwarzDame,

    //König
    PikSchwarzKönig, //45
    KaroRotKönig,
    HerzRotKönig,
    KreutzSchwarzKönig,

    //Ass
    PikSchwarzAss, //49
    KaroRotAss,
    HerzRotAss,
    KreutzSchwarzAss

}

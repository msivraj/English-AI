/**
 * Created by msivraj on 7/15/17.
 */
package stuff;

import java.util.Vector;

public class Token {
    private char tokenValue;
    private int letterType; //1 is consonant, 2 is vowel, 3 is special char
    private Alphabet token;

    public Token(Alphabet tokIn, char tokenValueIn, int letterTypeIn){
        token=tokIn;
        tokenValue=tokenValueIn;
        letterType=letterTypeIn;
    }

    enum Alphabet{
        lca, lcb, lcc, lcd, lce, lcf, lcg, lch, lci, lcj, lck, lcl, lcm, lcn, lco,
        lcp, lcq, lcr, lcs, lct, lcu, lcv, lcw, lcx, lcy, lcz, UCA, UCB, UCC, UCD,
        UCE, UCF, UCG, UCH, UCI, UCJ, UCK, UCL, UCM, UCN, UCO, UCP, UCQ, UCR, UCS,
        UCT, UCU, UCV, UCW, UCX, UCY, UCZ, PERIOD, QUOTE, SEMI, COMMA, RPAREN,
        LPAREN, BANG, COLON, QMARK, AMPER, SPACE, ONE, TWO, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, ZERO
    }

    Alphabet getTok(){
        return token;
    }

    char getTokenValue(){
        return tokenValue;
    }

    int getLetterType(){
        return letterType;
    }
}

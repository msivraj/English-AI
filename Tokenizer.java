/**
 * Created by msivraj on 7/15/17.
 */
package stuff;

import java.awt.*;
import java.util.Vector;
import stuff.Token.Alphabet;

import javax.lang.model.type.NullType;
//import stuff.Word;
//import stuff.Punctuation;
//import stuff.Sentence;
//import stuff.Token;

public class Tokenizer {

    private Vector<Token> tokens=new Vector<Token>();
    private Vector<Word>words=new Vector<Word>();
    private Vector<Sentence>sentences=new Vector<Sentence>();
    private Vector<Punctuation>puncts=new Vector<Punctuation>();

    Vector<Token> getTokens() {

        return tokens;
    }

    void createSentences(Vector<Word>wordsIn){
        Sentence aSentence=new Sentence(wordsIn);
        sentences.add(aSentence);

    }

    void createWords(Vector<Token>toks){
        Word aWord=new Word(toks);
        words.add(aWord);
    }

    void createPunctuation(Token tokIn, int locIn){
        Punctuation aPunctuation=new Punctuation(tokIn, locIn);
        puncts.add(aPunctuation);
    }

    void confirmToken(char aChar) {
        boolean isGo;

        isGo = lcConfirmation(aChar);
        if (isGo) {
            isGo = UCConfirmation(aChar);
            if (isGo) {
                isGo = numAndSpecialCharConfirmation(aChar);
            }
        }

    }

    void parseTokens(){
        Vector<Token> toks= new Vector<Token>();

        for(int i=0; i<tokens.size();i++) {
            System.out.println(tokens.elementAt(i).getTok() + "," + i);
            int toDo = 0;
            switch (tokens.elementAt(i).getTok()) {
                case BANG:
                    toDo = 1;
                    break;
                case QMARK:
                    toDo = 1;
                    break;
                case PERIOD:
                    toDo = 1;
                    break;
                case COMMA:
                    toDo = 2;
                    break;
                case COLON:
                    toDo = 2;
                    break;
                case SEMI:
                    toDo = 2;
                    break;
                case LPAREN:
                    toDo = 2;
                    break;
                case RPAREN:
                    toDo = 2;
                    break;
                case AMPER:
                    toDo = 2;
                    break;
                case QUOTE:
                    toDo = 2;
                    break;
                default:
                    break;
            }
            if (toDo == 1) {
                createWords(toks);
                createSentences(words);
                createPunctuation(tokens.elementAt(i), i);
                words.clear();
                toks.clear();
            } else if (toDo == 2) {
                createPunctuation(tokens.elementAt(i), i);
            } else if (tokens.elementAt(i).getTok() == Alphabet.SPACE) {
                if (toks.size() != 0) {
                    createWords(toks);
                    toks.clear();
                }
            } else {
                toks.add(tokens.elementAt(i));
            }
        }
        System.out.println("parse is done");
    }

    boolean lcConfirmation(char aChar) {
        boolean isGo = true;
        boolean isCreateTokens = true;
        Alphabet tokEnum=null;
        int letterType=0;
        switch (aChar) {
            case 'a':
                aChar = 'a';
                tokEnum = Alphabet.lca;
                letterType = 2;
                break;
            case 'b':
                aChar = 'b';
                tokEnum = Alphabet.lcb;
                letterType = 1;
                break;
            case 'c':
                aChar = 'c';
                tokEnum = Alphabet.lcc;
                letterType = 1;
                break;
            case 'd':
                aChar = 'd';
                tokEnum = Alphabet.lcd;
                letterType = 1;
                break;
            case 'e':
                aChar = 'e';
                tokEnum = Alphabet.lce;
                letterType = 2;
                break;
            case 'f':
                aChar = 'f';
                tokEnum = Alphabet.lcf;
                letterType = 1;
                break;
            case 'g':
                aChar = 'g';
                tokEnum = Alphabet.lcg;
                letterType = 1;
                break;
            case 'h':
                aChar = 'h';
                tokEnum = Alphabet.lch;
                letterType = 1;
                break;
            case 'i':
                aChar = 'i';
                tokEnum = Alphabet.lci;
                letterType = 2;
                break;
            case 'j':
                aChar = 'j';
                tokEnum = Alphabet.lcj;
                letterType = 1;
                break;
            case 'k':
                aChar = 'k';
                tokEnum = Alphabet.lck;
                letterType = 1;
                break;
            case 'l':
                aChar = 'l';
                tokEnum = Alphabet.lcl;
                letterType = 1;
                break;
            case 'm':
                aChar = 'm';
                tokEnum = Alphabet.lcm;
                letterType = 1;
                break;
            case 'n':
                aChar = 'n';
                tokEnum = Alphabet.lcn;
                letterType = 1;
                break;
            case 'o':
                aChar = 'o';
                tokEnum = Alphabet.lco;
                letterType = 2;
                break;
            case 'p':
                aChar = 'p';
                tokEnum = Alphabet.lcp;
                letterType = 1;
                break;
            case 'q':
                aChar = 'q';
                tokEnum = Alphabet.lcq;
                letterType = 1;
                break;
            case 'r':
                aChar = 'r';
                tokEnum = Alphabet.lcr;
                letterType = 1;
                break;
            case 's':
                aChar = 's';
                tokEnum = Alphabet.lcs;
                letterType = 1;
                break;
            case 't':
                aChar = 't';
                tokEnum = Alphabet.lct;
                letterType = 1;
                break;
            case 'u':
                aChar = 'u';
                tokEnum = Alphabet.lcu;
                letterType = 1;
                break;
            case 'v':
                aChar = 'v';
                tokEnum = Alphabet.lcv;
                letterType = 1;
                break;
            case 'w':
                aChar = 'w';
                tokEnum = Alphabet.lcw;
                letterType = 1;
                break;
            case 'x':
                aChar = 'x';
                tokEnum = Alphabet.lcx;
                letterType = 1;
                break;
            case 'y':
                aChar = 'y';
                tokEnum = Alphabet.lcy;
                letterType = 2;
                break;
            case 'z':
                aChar = 'z';
                tokEnum = Alphabet.lcz;
                letterType = 1;
                break;
            default:
                isCreateTokens = false;
                break;
        }
        if (isCreateTokens) {
            isGo = createTokens(aChar, tokEnum, letterType);
        }
        return isGo;
    }

    boolean UCConfirmation(char aChar) {
        boolean isGo = true;
        boolean isCreateTokens = true;
        Alphabet tokEnum=null;
        int letterType=0;
        switch (aChar) {
            case 'A':
                aChar = 'A';
                tokEnum = Alphabet.UCA;
                letterType = 2;
                break;
            case 'B':
                aChar = 'B';
                tokEnum = Alphabet.UCB;
                letterType = 1;
                break;
            case 'C':
                aChar = 'C';
                tokEnum = Alphabet.UCC;
                letterType = 1;
                break;
            case 'D':
                aChar = 'D';
                tokEnum = Alphabet.UCD;
                letterType = 1;
                break;
            case 'E':
                aChar = 'E';
                tokEnum = Alphabet.UCE;
                letterType = 2;
                break;
            case 'F':
                aChar = 'F';
                tokEnum = Alphabet.UCF;
                letterType = 1;
                break;
            case 'G':
                aChar = 'G';
                tokEnum = Alphabet.UCG;
                letterType = 1;
                break;
            case 'H':
                aChar = 'H';
                tokEnum = Alphabet.UCH;
                letterType = 1;
                break;
            case 'I':
                aChar = 'I';
                tokEnum = Alphabet.UCI;
                letterType = 2;
                break;
            case 'J':
                aChar = 'J';
                tokEnum = Alphabet.UCJ;
                letterType = 1;
                break;
            case 'K':
                aChar = 'K';
                tokEnum = Alphabet.UCK;
                letterType = 1;
                break;
            case 'L':
                aChar = 'L';
                tokEnum = Alphabet.UCL;
                letterType = 1;
                break;
            case 'M':
                aChar = 'M';
                tokEnum = Alphabet.UCM;
                letterType = 1;
                break;
            case 'N':
                aChar = 'N';
                tokEnum = Alphabet.UCN;
                letterType = 1;
                break;
            case 'O':
                aChar = 'O';
                tokEnum = Alphabet.UCO;
                letterType = 2;
                break;
            case 'P':
                aChar = 'P';
                tokEnum = Alphabet.UCP;
                letterType = 1;
                break;
            case 'Q':
                aChar = 'Q';
                tokEnum = Alphabet.UCQ;
                letterType = 1;
                break;
            case 'R':
                aChar = 'R';
                tokEnum = Alphabet.UCR;
                letterType = 1;
                break;
            case 'S':
                aChar = 'S';
                tokEnum = Alphabet.UCS;
                letterType = 1;
                break;
            case 'T':
                aChar = 'T';
                tokEnum = Alphabet.UCT;
                letterType = 1;
                break;
            case 'U':
                aChar = 'U';
                tokEnum = Alphabet.UCQ;
                letterType=2;
                break;
            case 'V':
                aChar = 'V';
                tokEnum = Alphabet.UCV;
                letterType = 1;
                break;
            case 'W':
                aChar = 'W';
                tokEnum = Alphabet.UCW;
                letterType = 1;
                break;
            case 'X':
                aChar = 'X';
                tokEnum = Alphabet.UCX;
                letterType = 1;
                break;
            case 'Y':
                aChar = 'Y';
                tokEnum = Alphabet.UCY;
                letterType = 2;
                break;
            case 'Z':
                aChar = 'Z';
                tokEnum = Alphabet.UCZ;
                letterType = 1;
                break;
            default:
                isCreateTokens = false;
                break;
        }
        if (isCreateTokens) {
            isGo = createTokens(aChar, tokEnum, letterType);
        }

        return isGo;
    }

    boolean numAndSpecialCharConfirmation(char aChar) {
        boolean isGo = true;
        boolean isCreateTokens = true;
        Alphabet tokEnum=null;
        int letterType=0;
        switch (aChar) {
            case '!':
                aChar = '!';
                tokEnum = Alphabet.BANG;
                letterType = 3;
                break;
            case '(':
                aChar = '(';
                tokEnum = Alphabet.LPAREN;
                letterType = 3;
                break;
            case ')':
                aChar = ')';
                tokEnum = Alphabet.RPAREN;
                letterType = 3;
                break;
            case '&':
                aChar = '&';
                tokEnum = Alphabet.AMPER;
                letterType = 3;
                break;
            case '.':
                aChar = '.';
                tokEnum = Alphabet.PERIOD;
                letterType = 3;
                break;
            case ',':
                aChar = ',';
                tokEnum = Alphabet.COMMA;
                letterType = 3;
                break;
            case ';':
                aChar = ';';
                tokEnum = Alphabet.SEMI;
                letterType = 3;
                break;
            case ':':
                aChar = ':';
                tokEnum = Alphabet.COLON;
                letterType = 3;
                break;
            case '"':
                aChar = '"';
                tokEnum = Alphabet.QUOTE;
                letterType = 3;
                break;
            case ' ':
                aChar = ' ';
                tokEnum = Alphabet.SPACE;
                letterType = 3;
                break;
            case '?':
                aChar = '?';
                tokEnum = Alphabet.QMARK;
                letterType = 3;
                break;
            case '1':
                aChar = '1';
                tokEnum = Alphabet.ONE;
                letterType = 3;
                break;
            case '2':
                aChar = '2';
                tokEnum = Alphabet.TWO;
                letterType = 3;
                break;
            case '3':
                aChar = '3';
                tokEnum = Alphabet.THREE;
                letterType = 3;
                break;
            case '4':
                aChar = '4';
                tokEnum = Alphabet.FOUR;
                letterType = 3;
                break;
            case '5':
                aChar = '5';
                tokEnum = Alphabet.FIVE;
                letterType = 3;
                break;
            case '6':
                aChar = '6';
                tokEnum = Alphabet.SIX;
                letterType = 3;
                break;
            case '7':
                aChar = '7';
                tokEnum = Alphabet.SEVEN;
                letterType = 3;
                break;
            case '8':
                aChar = '8';
                tokEnum = Alphabet.EIGHT;
                letterType = 3;
                break;
            case '9':
                aChar = '9';
                tokEnum = Alphabet.NINE;
                letterType = 3;
                break;
            case '0':
                aChar = '0';
                tokEnum = Alphabet.ZERO;
                letterType = 3;
                break;
            default:
                isCreateTokens = false;
                break;
        }
        if (isCreateTokens) {
            isGo = createTokens(aChar, tokEnum, letterType);
        }
        return isGo;
    }

    boolean createTokens(char aChar, Alphabet tok, int myInt) {
        boolean isGo = false;
        Token aToken = new Token(tok, aChar, myInt);

        tokens.add(aToken);

        System.out.println("happy");

        return isGo;
    }

    void printTokens(){
        for(int i=0; i<tokens.size();i++){
            System.out.println(tokens.elementAt(i).getTokenValue());
        }
    }
}

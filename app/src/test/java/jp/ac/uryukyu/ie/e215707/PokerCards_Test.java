package jp.ac.uryukyu.ie.e215707;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PokerCards_Test {
    
    @Test void num_Cards(){
        PlayingCards n = new PlayingCards();
        n.playcards();
        assertEquals(n.getCards().size(), 42);
    }
}
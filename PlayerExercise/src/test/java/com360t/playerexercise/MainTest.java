package com360t.playerexercise;

import static com360t.playerexercise.TestUsefulFunctions.getLastNum;
import static com360t.playerexercise.TestUsefulFunctions.isLastDigit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for the Player class.
 */
public class MainTest {
    Player p1 = new Player("p1");
    Player p2 = new Player("p2");
    String message1 = "Hi!";
    String message2 = "A Message With a number at the End. 5";

    /**
     * Test that two players are not equal to each other.
     */
    @Test
    public void testPlayersNotEqual() {
        assertFalse(p1.equals(p2));
    }

    /**
     * Test that a player's reply message contains the right number.
     *
     * Sends a message from player 1 to player 2, and then makes the players
     * reply to each other multiple times. Checks that the last received message
     * of each player contains the correct message number.
     */
    @Test
    public void testReplyHasRightNum() {

        p1.sendMessage(p2, message1);
        for (int i = 0; i < 5; i++) {
            p2.reply(p1);
            p1.reply(p2);
        }
        String lastRecvMessP1 = p1.getLastReceivedMessage();
        int lastRecvNumP1 = (isLastDigit(lastRecvMessP1)) ? getLastNum(lastRecvMessP1) + 1 : 1;
        String lastRecvMessP2 = p2.getLastReceivedMessage();
        int lastRecvNumP2 = (isLastDigit(lastRecvMessP2)) ? getLastNum(lastRecvMessP2) + 1 : 1;

        assertTrue(lastRecvNumP1 == p2.getNumberOfSentMessages());
        assertTrue(lastRecvNumP2 == p1.getNumberOfSentMessages());
    }



}

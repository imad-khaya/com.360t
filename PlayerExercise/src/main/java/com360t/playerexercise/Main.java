package com360t.playerexercise;

import java.util.Scanner;

/**
 * A simple program that demonstrates the use of the Player class to send and receive messages between two players.
 */
public class Main {

    /**
     * The entry point of the program. (Main Method)
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstMessage;
        System.out.println(
                "Please enter the message you want the player initiator to send to the other player: "
        );
        firstMessage = sc.nextLine();
        Player initiator = new Player("Initiator");
        Player player2 = new Player("Player2");
        startConversation(initiator, player2, firstMessage);
    }

    /**
     * Starts a conversation between two players by sending a message from the initiator to the other player,
     * and then alternating replies until the stop condition is fulfilled.
     * It should be noted that the code here isn't optimized for the condition when more than 10 is!
     * Because here is the design is more required than the technology! It had been ignored
     *
     * @param initiator the player who initiates the conversation
     * @param player2 the player who receives the first message and replies to it
     * @param message the message to send from the initiator to the other player
     */
    private static void startConversation(Player initiator, Player player2, String message) {
        initiator.sendMessage(player2, message);
        System.out.println("Player 2 received message: " + player2.getLastReceivedMessage());
        while (!isStopConditionFulfilled(initiator)){
            player2.reply(initiator);
            System.out.println("Initiator received message: " + initiator.getLastReceivedMessage());
            if(isStopConditionFulfilled(initiator)) break;
            initiator.reply(player2);
            System.out.println("Player 2 received message: " + player2.getLastReceivedMessage());

        }
    }

    /**
     * Checks if the stop condition is fulfilled for a given player.
     *
     * @param player the player to check for the stop condition
     * @return true if the player has received and sent at least 10 messages, false otherwise
     */
    private static boolean isStopConditionFulfilled(Player player){
        return (player.getNumberOfReceivedMessages() >= 10 && player.getNumberOfSentMessages() >= 10);
    }
}

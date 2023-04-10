package com360t.playerexercise;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Represents a player in a messaging system.
 */
public class Player {

    /**
     * The player's name.
     */
    private final String name;

    /**
     * The messages received by the player.
     */
    private ArrayList<String> messagesReceived = new ArrayList<>();

    /**
     * The messages sent by the player.
     */
    private ArrayList<String> messagesSent = new ArrayList<>();

    /**
     * Constructs a new player with the given name.
     *
     * @param name The player's name.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the number of messages sent by the player.
     *
     * @return The number of messages sent.
     */
    public int getNumberOfSentMessages(){
        return messagesSent.size();
    }

    /**
     * Gets the number of messages received by the player.
     *
     * @return The number of messages received.
     */
    public int getNumberOfReceivedMessages() {
        return messagesReceived.size();
    }

    /**
     * Gets the last message received by the player.
     *
     * @return The last message received.
     * @throws NoSuchElementException If no messages have been received yet.
     */
    public String getLastReceivedMessage() {
        return messagesReceived.get(messagesReceived.size()-1);
    }

    /**
     * Gets the last received message concatenated with the number of messages sent by the player.
     *
     * @return The last received message with the number of messages sent appended to the end.
     */
    public String getLastReceivedMessageConcatenated() {
        int numberOfSentMessages = getNumberOfSentMessages();
        String lastReceivedMessage = getLastReceivedMessage();
        String messageWithoutNumSent = lastReceivedMessage.substring(0, lastReceivedMessage.length()-1);
        if (getNumberOfSentMessages() == 0) return String.format("%s%d", lastReceivedMessage, numberOfSentMessages);

        return String.format("%s%d", messageWithoutNumSent, numberOfSentMessages);
    }

    /**
     * Sends a message to another player.
     *
     * @param otherPlayer The player to send the message to.
     * @param message The message to send.
     */
    public void sendMessage(Player otherPlayer, String message){
        otherPlayer.receiveMessage(message);
        messagesSent.add(message);
    }


    /**
     * Receives a message from another player.
     *
     * @param message The message received.
     */
    private void receiveMessage(String message){
        this.messagesReceived.add(message);
    }




    /**
     * Replies to the last message received by sending the concatenated message to the sender.
     *
     * @param otherPlayer The player to send the reply to.
     */
    public void reply(Player otherPlayer){
        String messageToSend = getLastReceivedMessageConcatenated();
        sendMessage(otherPlayer, messageToSend);
    }
}

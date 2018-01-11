package com.gamebros.purepazaak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.gamebros.purepazaak.entity.Card;
import com.gamebros.purepazaak.entity.Player;
import com.gamebros.purepazaak.entity.SideDeck;
import com.gamebros.purepazaak.enumerable.PlayerEnum;
import com.gamebros.purepazaak.enumerable.WinnerEnum;
import com.gamebros.purepazaak.factory.SideDeckFactory;

public class MainCli {
  public static void main(String[] args) {
    SideDeckFactory factory = new SideDeckFactory();

    Player playerOne = new Player(factory.build());
    Player playerTwo = new Player(factory.build());

    Match match = new Match(playerOne, playerTwo);
    match.newSet();

    Scanner keyboard = new Scanner(System.in);
    String input;

    System.out.println("Starting!");
    while (match.getWinner() == null) {
      MatchSet set = match.getCurrentSet();

      while (set.getWinner() == WinnerEnum.NONE) {
        PlayerEnum currentPlayer = match.getCurrentSet().getCurrentPlayer();
        ArrayList<Card> sideDeck = match.getPlayerDeck(currentPlayer);
        Board board = set.getBoard(currentPlayer);
        Card lastCard = board.getCards().get(board.getCards().size() - 1);

        System.out.println(currentPlayer + " drew a " + lastCard.getValue() + ".");

        do {
          if (board.getTotal() == 20) {
            match.getCurrentSet().stand();

            break;
          }

          System.out.println(Arrays.toString(
              sideDeck
                .stream()
                .map(card -> card.getValue())
                .collect(Collectors.toList())
                .toArray()
          ));

          System.out.print(board.getTotal() + " > ");
          input = keyboard.next();

          switch (input) {
            case "1":
            case "2":
            case "3":
            case "4":
              board.addCard(sideDeck.remove(Integer.parseInt(input) - 1));

              break;
            case "s":
              match.getCurrentSet().stand();

              break;
            case "e":
              match.getCurrentSet().endTurn();

              if (board.getTotal() > 20) {
                match.getCurrentSet().stand();
              }

              break;
          }
        } while (!input.equals("e") && !input.equals("s"));
      }

      System.out.println(set.getWinner() + " wins!");

      match.newSet();
    }
  }
}

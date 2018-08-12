package com.github.nomad145.purepazaak.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.github.nomad145.purepazaak.core.card.CardInterface;
import com.github.nomad145.purepazaak.core.entity.Player;
import com.github.nomad145.purepazaak.core.entity.SideDeck;
import com.github.nomad145.purepazaak.core.enumerable.PlayerEnum;
import com.github.nomad145.purepazaak.core.enumerable.WinnerEnum;
import com.github.nomad145.purepazaak.core.factory.SideDeckFactory;

public class MainCli {
  public static void main(String[] args) {
    SideDeckFactory factory = new SideDeckFactory();

    SideDeck playerOneSideDeck = factory.build();
    SideDeck playerTwoSideDeck = factory.build();

    Player playerOne = new Player(playerOneSideDeck);
    Player playerTwo = new Player(playerTwoSideDeck);

    Match match = new Match(playerOne, playerTwo);
    match.createNewSet();

    Scanner keyboard = new Scanner(System.in);
    String input;

    System.out.println("Starting!");
    while (match.getWinner() == null) {
      MatchSet set = match.getCurrentSet();

      while (set.getWinner() == WinnerEnum.NONE) {
        PlayerEnum currentPlayer = match.getCurrentSet().getCurrentPlayer();
        ArrayList<CardInterface> sideDeck = match.getCurrentPlayerDeck();
        Board board = set.getCurrentBoard();
        CardInterface lastCard = board.getCards().get(board.getCards().size() - 1);

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

      match.createNewSet();
    }
  }
}

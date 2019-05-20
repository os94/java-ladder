package ladderGame.view;

import ladderGame.constant.Contants;
import ladderGame.domain.*;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public static void printLadder(Ladder ladder, GameData gameData) {
        System.out.println(NEW_LINE + Contants.MESSAGE_LADDER_RESULT + NEW_LINE);
        printMembers(gameData);
        emptyLine();
        printLadderShape(ladder, gameData);
        printGoals(gameData);
        emptyLine();
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + Contants.MESSAGE_GAME_RESULT);
    }

    public static void printDestination(String result) {
        System.out.println(result);
    }

    public static void printDestination(String name, String result) {
        System.out.println(name + " : " + result);
    }

    private static void printMembers(GameData gameData) {
        for (Member member : gameData.getMembers()) {
            System.out.printf("%6s", member.getName());
        }
    }

    private static void printGoals(GameData gameData) {
        for (Goal goal : gameData.getGoals()) {
            System.out.printf("%6s", goal.getGoal());
        }
    }

    private static void printLadderShape(Ladder ladder, GameData gameData) {
        for (Row row : ladder.getRows()) {
            printRow(row, gameData.getCountOfPerson());
        }
    }

    private static void printRow(Row row, int columnNumber) {
        System.out.print(Contants.MESSAGE_INDENT + Contants.MESSAGE_COLUMN);
        for (int index = 0; index < columnNumber - 1; index++) {
            printBridge(row, index);
            System.out.print(Contants.MESSAGE_COLUMN);
        }
        emptyLine();
    }

    private static void printBridge(Row row, int index) {
        if (row.isConnected(index)) {
            System.out.print(Contants.MESSAGE_BRIDGE);
        }
        if (!row.isConnected(index)) {
            System.out.print(Contants.MESSAGE_BLANK);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }
}
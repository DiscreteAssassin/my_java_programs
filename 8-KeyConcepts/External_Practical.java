
import java.util.*;
enum Symbol {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

class Card {
    private Symbol symbol;
    private String value;

    public Card(Symbol symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

}

public class External_Practical {
    private Map<Symbol, Set<Card>> cardCollection;

    public External_Practical() {
        this.cardCollection = new HashMap<>();
        for (Symbol symbol : Symbol.values()) {
            cardCollection.put(symbol, new HashSet<>());
        }
    }

    public void searchCardsBySymbol() {
        System.out.println("Choose a symbol:");
        System.out.println("1. HEARTS");
        System.out.println("2. DIAMONDS");
        System.out.println("3. CLUBS");
        System.out.println("4. SPADES");
        System.out.print("Enter your choice (1-4): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Symbol symbol = getSymbolFromChoice(choice);

        Set<Card> cards = cardCollection.get(symbol);
        if (cards.isEmpty()) {
            System.out.println("No cards found for this symbol.");
        } else {
            System.out.println("Cards for " + symbol + ":");
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    private Symbol getSymbolFromChoice(int choice) {
        switch (choice) {
            case 1:
                return Symbol.HEARTS;
            case 2:
                return Symbol.DIAMONDS;
            case 3:
                return Symbol.CLUBS;
            case 4:
                return Symbol.SPADES;
            default:
                System.out.println("Invalid choice. Defaulting to HEARTS.");
                return Symbol.HEARTS;
        }
    }

    public static void main(String[] args) {
        External_Practical manager = new External_Practical();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCard Management System");
            System.out.println("1. Search Cards by Symbol");
            System.out.println("2. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    manager.searchCardsBySymbol();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}



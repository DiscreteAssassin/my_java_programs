
import java.util.*;

// Enum for card symbols
enum Symbol {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

// Class for Card
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

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class enum_Example {
    private Map<Symbol, Set<Card>> cardCollection;

    public enum_Example() {
        this.cardCollection = new HashMap<>();
        for (Symbol symbol : Symbol.values()) {
            cardCollection.put(symbol, new HashSet<>());
        }
    }

    // Method to add a card
    public void addCard() {
        System.out.println("Choose a symbol:");
        System.out.println("1. HEARTS");
        System.out.println("2. DIAMONDS");
        System.out.println("3. CLUBS");
        System.out.println("4. SPADES");
        System.out.print("Enter your choice (1-4): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Symbol symbol = getSymbolFromChoice(choice);

        System.out.print("Enter card value (e.g., Ace, 2, 3, ..., 10, Jack, Queen, King): ");
        String value = scanner.next();

        Card card = new Card(symbol, value);
        cardCollection.get(symbol).add(card);
        System.out.println("Card added successfully!");
    }

    // Method to remove a card
    public void removeCard() {
        System.out.println("Choose a symbol:");
        System.out.println("1. HEARTS");
        System.out.println("2. DIAMONDS");
        System.out.println("3. CLUBS");
        System.out.println("4. SPADES");
        System.out.print("Enter your choice (1-4): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Symbol symbol = getSymbolFromChoice(choice);

        System.out.print("Enter card value (e.g., Ace, 2, 3, ..., 10, Jack, Queen, King): ");
        String value = scanner.next();

        Card cardToRemove = new Card(symbol, value);
        if (cardCollection.get(symbol).remove(cardToRemove)) {
            System.out.println("Card removed successfully!");
        } else {
            System.out.println("Card not found!");
        }
    }

    // Method to search for cards by symbol
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

    // Helper method to get Symbol from user choice
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

    // Main method to run the program
    public static void main(String[] args) {
        enum_Example manager = new enum_Example();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCard Management System");
            System.out.println("1. Add Card");
            System.out.println("2. Remove Card");
            System.out.println("3. Search Cards by Symbol");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    manager.addCard();
                    break;
                case 2:
                    manager.removeCard();
                    break;
                case 3:
                    manager.searchCardsBySymbol();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}


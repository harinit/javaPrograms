package given;

import java.math.BigDecimal;
import java.util.*;

class Position {
    private String accountId;
    private String symbol;
    private long shares;

    public Position(String accountId, String symbol, long shares) {
        this.accountId = accountId;
        this.symbol = symbol;
        this.shares = shares;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getShares() {
        return shares;
    }
}

class Quote {
    private String symbol;
    private BigDecimal price;

    public Quote(String symbol, double price) {
        this.symbol = symbol;
        this.price = BigDecimal.valueOf(price);
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

class PositionService {
    private List<Position> positions;

    public PositionService() {
        // Initializing the list dynamically
        this.positions = new ArrayList<>();

        // Adding positions dynamically
        this.positions.add(new Position("A123", "WMT", 10));
        this.positions.add(new Position("A123", "MCD", 5));
        this.positions.add(new Position("B456", "AAPL", 15));
        this.positions.add(new Position("B456", "GOOGL", 7));
        this.positions.add(new Position("C789", "TSLA", 20));
    }

    public List<Position> getAllPositions() {
        return positions;
    }
}

class QuoteService {
    private List<Quote> previousClosedQuotes;

    public QuoteService() {
        // Initializing the list dynamically
        this.previousClosedQuotes = new ArrayList<>();

        // Adding previous close quotes dynamically using double values
        this.previousClosedQuotes.add(new Quote("WMT", 140.50));
        this.previousClosedQuotes.add(new Quote("MCD", 210.00));
        this.previousClosedQuotes.add(new Quote("AAPL", 144.00));
        this.previousClosedQuotes.add(new Quote("GOOGL", 2700.00));
        this.previousClosedQuotes.add(new Quote("TSLA", 730.00));
        this.previousClosedQuotes.add(new Quote("PB", 138.33)); // Additional example
    }

    public List<Quote> getAllPreviousClosedQuotes() {
        return previousClosedQuotes;
    }
    // Write this method to get the latest price of a given symbol
    public BigDecimal getLatestPrice(String symbol) {
        // Look for the latest price in previousClosedQuotes
        for (Quote quote : previousClosedQuotes) {
            if (quote.getSymbol().equals(symbol)) {
                return quote.getPrice();
            }
        }
        // Default price if not found
        return BigDecimal.ZERO;
    }
}

public class TradingFirm {
    public static void main(String[] args) {
        PositionService positionService = new PositionService();
        QuoteService quoteService = new QuoteService();

        List<Position> positions = positionService.getAllPositions();
        //List<Quote> previousQuotes = quoteService.getAllPreviousClosedQuotes();

        // Map to store total account values
        Map<String, BigDecimal> accountValues = new HashMap<>();

        // Calculate total value per account
        for (Position position : positions) {
            BigDecimal price = quoteService.getLatestPrice(position.getSymbol());
            BigDecimal totalValue = price.multiply(BigDecimal.valueOf(position.getShares()));

            accountValues.put(
                position.getAccountId(),
                accountValues.getOrDefault(position.getAccountId(), BigDecimal.ZERO).add(totalValue)
            );
        }

        // Display results
        System.out.println("Account ID : Total Value");
        for (Map.Entry<String, BigDecimal> entry : accountValues.entrySet()) {
            System.out.printf("%-10s : $%.2f%n", entry.getKey(), entry.getValue());
        }
    }
}

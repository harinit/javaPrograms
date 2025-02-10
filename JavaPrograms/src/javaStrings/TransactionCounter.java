package javaStrings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionCounter {

    enum TransactionStatus {
        PENDING, COMPLETED, FAILED
    }

    static class Transaction {
        String id;
        BigDecimal amount;
        LocalDateTime timestamp;
        TransactionStatus status;

        public Transaction(String id, BigDecimal amount, LocalDateTime timestamp, TransactionStatus status) {
            this.id = id;
            this.amount = amount;
            this.timestamp = timestamp;
            this.status = status;
        }

        public TransactionStatus getStatus() {
            return status;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("T1", new BigDecimal("100.50"), LocalDateTime.now(), TransactionStatus.PENDING),
                new Transaction("T2", new BigDecimal("250.75"), LocalDateTime.now(), TransactionStatus.COMPLETED),
                new Transaction("T3", new BigDecimal("50.25"), LocalDateTime.now(), TransactionStatus.FAILED),
                new Transaction("T4", new BigDecimal("130.00"), LocalDateTime.now(), TransactionStatus.PENDING),
                new Transaction("T5", new BigDecimal("200.00"), LocalDateTime.now(), TransactionStatus.COMPLETED));

        // Count transactions by status
        long pendingCount = transactions.stream().filter(t -> t.getStatus() == TransactionStatus.PENDING).count();
        long completedCount = transactions.stream().filter(t -> t.getStatus() == TransactionStatus.COMPLETED).count();
        long failedCount = transactions.stream().filter(t -> t.getStatus() == TransactionStatus.FAILED).count();
        long totalTransactions = transactions.size(); // Total transactions count

        /*
         * import java.util.Map;
         * import java.util.stream.Collectors;
         * 
         * Map<TransactionStatus, Long> transactionCountMap = transactions.stream()
         * .collect(Collectors.groupingBy(Transaction::getStatus,
         * Collectors.counting()));
         * 
         * System.out.println(transactionCountMap);
         */
        // Sum total amounts for each transaction type
        BigDecimal pendingTotal = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.PENDING)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal completedTotal = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.COMPLETED)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal failedTotal = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.FAILED)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Calculate the total amount of all transactions
        BigDecimal totalAmount = pendingTotal.add(completedTotal).add(failedTotal);

        // Calculate the average amount of transactions
        // BigDecimal averageAmount =
        // totalAmount.divide(BigDecimal.valueOf(totalTransactions), 2,
        // BigDecimal.ROUND_HALF_UP);
        // System.out.println("****");

        BigDecimal totalAmount1 = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total Amount: $" + totalAmount1);

        System.out.println("****");
        // Output results
        System.out.println("Pending Transactions: " + pendingCount + ", Total Amount: $" + pendingTotal);
        System.out.println("Completed Transactions: " + completedCount + ", Total Amount: $" + completedTotal);
        System.out.println("Failed Transactions: " + failedCount + ", Total Amount: $" + failedTotal);
        System.out.println("Total Transactions: " + totalTransactions + ", Total Amount: $" + totalAmount);
    }
}
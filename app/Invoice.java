package app;

public final class Invoice {
  private final String invoiceNumber;
  private final int invoiceAmount;

  public Invoice(String invoiceNumber, int invoiceAmount) {
    this.invoiceNumber = invoiceNumber;
    this.invoiceAmount = invoiceAmount;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public int getInvoiceAmount() {
    return invoiceAmount;
  }

  @Override
  public String toString() {
    return "Invoice #" + invoiceNumber + ": $" + invoiceAmount;
  }
}

package bank.model;

import java.sql.Date;

public class Transaction {
	private long Accno;
    private Date date;
    private String description;
    private Float amount;

    // Getters and Setters
    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date2) {
        this.date = (Date) date2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = (float) amount;
    }

	public long getAccno() {
		return Accno;
	}

	public void setAccno(long accno) {
		Accno = accno;
	}
}

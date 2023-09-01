package org.gsc.medha.dto.notification;

public class Parameter {
    private String type;

    // For text type
    private String text;

	/*
	 * // For currency type private Currency currency;
	 * 
	 * // For date_time type private DateTime dateTime;
	 */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/*
	 * public Currency getCurrency() { return currency; }
	 * 
	 * public void setCurrency(Currency currency) { this.currency = currency; }
	 * 
	 * public DateTime getDateTime() { return dateTime; }
	 * 
	 * public void setDateTime(DateTime dateTime) { this.dateTime = dateTime; }
	 */

    
}


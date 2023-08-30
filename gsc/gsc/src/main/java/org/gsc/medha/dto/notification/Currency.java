package org.gsc.medha.dto.notification;
public class Currency {
    private String fallback_value;
    private String code;
    private int amount_1000;
	public String getFallback_value() {
		return fallback_value;
	}
	public void setFallback_value(String fallback_value) {
		this.fallback_value = fallback_value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getAmount_1000() {
		return amount_1000;
	}
	public void setAmount_1000(int amount_1000) {
		this.amount_1000 = amount_1000;
	}

 
}


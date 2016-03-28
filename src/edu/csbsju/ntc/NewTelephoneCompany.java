package edu.csbsju.ntc;

public class NewTelephoneCompany {
	private int startTime;
	private int duration;
	private static final double FED_TAX = 0.04;
	private static final double COST = 40;
	private static final double HOURS_DISCOUNT = 0.5;
	private static final double DURATION_DISCOUNT = 0.15;

	public double computeCharge() {
		double charge = 0;
		if (startTime < 0 || startTime >= 2400 || startTime % 100 > 59) {
			throw new UnsupportedOperationException("Invalid START TIME");
		} else if (duration <= 0) {
			throw new UnsupportedOperationException("Invalid LENGTH");
		} else if ((startTime < 800) || (startTime >= 1800)) {
			if (duration > 60) {
				charge = duration * COST * HOURS_DISCOUNT * (1 - DURATION_DISCOUNT);
			} else {
				charge = duration * COST * HOURS_DISCOUNT;
			}
		} else {
			if (duration > 60) {
				charge = duration * COST * (1 - DURATION_DISCOUNT);
			} else {
				charge = duration * COST;
			}
		}
		return (charge * (1 + FED_TAX));
	}

	public int getStartTime() {
		return this.startTime;
	}

	public void setStartTime(int hours) {
		this.startTime = hours;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}



}
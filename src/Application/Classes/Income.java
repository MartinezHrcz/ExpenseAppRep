package Application.Classes;

import java.time.LocalDate;

public class Income {

    private String nameOfIncome;

    private int incomeAmount;
    //Description of the income source
    private String desc;
    //used if an income source is reoccuring
    private int dateOfrecurrenceDay;

    //Constructor for every variable
    public Income(String nameOfIncome, int incomeAmount, String desc, int date) {
        this.nameOfIncome = nameOfIncome;
        this.incomeAmount = incomeAmount;
        this.desc = desc;
        this.dateOfrecurrenceDay = date;
    }
    //Constructor without Day of reoccurence
    public Income(String nameOfIncome,int incomeAmount, String desc) {
        this.incomeAmount = incomeAmount;
        this.desc = desc;
    }

    public String getNameOfIncome() {
        return nameOfIncome;
    }

    public int getIncomeAmount() {
        return incomeAmount;
    }

    public String getDesc() {
        return desc;
    }

    public int getDateOfrecurrence() {
        return dateOfrecurrenceDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Income{");
        sb.append("nameOfIncome='").append(nameOfIncome).append('\'');
        sb.append(", incomeAmount=").append(incomeAmount);
        sb.append(", desc='").append(desc).append('\'');
        //Tenary for checking if an income source is reoccuring
        sb.append(", dateOfrecurrence=").append(((Integer)dateOfrecurrenceDay == null) ? "Doesn't reoccur" : dateOfrecurrenceDay);
        sb.append('}');
        return sb.toString();
    }
}

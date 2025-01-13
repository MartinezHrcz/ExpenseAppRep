package Application.Classes;

import java.time.LocalDate;

public class Income {
    private String nameOfIncome;
    private int incomeAmount;
    private String desc;
    private LocalDate dateOfrecurrence;

    public Income(String nameOfIncome, int incomeAmount, String desc, LocalDate date) {
        this.nameOfIncome = nameOfIncome;
        this.incomeAmount = incomeAmount;
        this.desc = desc;
        this.dateOfrecurrence = date;
    }

    public Income(String nameOfIncome,int incomeAmount, String desc) {
        this.incomeAmount = incomeAmount;
        this.desc = desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Income{");
        sb.append("nameOfIncome='").append(nameOfIncome).append('\'');
        sb.append(", incomeAmount=").append(incomeAmount);
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", dateOfrecurrence=").append(dateOfrecurrence == null ? "Doesn't reoccur" : dateOfrecurrence);
        sb.append('}');
        return sb.toString();
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

    public LocalDate getDateOfrecurrence() {
        return dateOfrecurrence;
    }

}

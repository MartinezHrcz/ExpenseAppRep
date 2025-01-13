package Application.Classes;

public class Expenses {

    private String Name;
    private String Desc;
    private double Amount;
    private boolean Checked;
    private boolean Essential;

    public Expenses(String Name, String Desc, double Amount, boolean Essential) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
        this.Essential = Essential;
    }
    public Expenses(String Name, String Desc, double Amount) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    public double getAmount() {
        return Amount;
    }

    public boolean getChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Expenses{");
        sb.append("Name='").append(Name).append('\'');
        sb.append(", Desc='").append(Desc).append('\'');
        sb.append(", Amount=").append(Amount);
        sb.append(", Checked=").append(Checked);
        sb.append(", Essential=").append(this.Essential ? "Essential" : "Non-Essential");
        sb.append('}');
        return sb.toString();
    }

}

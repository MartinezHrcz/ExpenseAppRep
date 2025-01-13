package Application.Classes;

public class Expenses {
    //Name of expense
    private String Name;
    //Description of the expense
    private String Desc;
    //The amont of the expense
    private double Amount;
    //If the expense is payed off
    //When constructed it is allways false
    private boolean Checked;
    //if the expense is true or false
    private boolean Essential;

    //Constructor with every variable
    public Expenses(String Name, String Desc, double Amount, boolean Essential) {
        this.Name = Name;
        this.Desc = Desc;
        this.Amount = Amount;
        this.Checked = false;
        this.Essential = Essential;
    }
    //Constructor without essential variable
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
        //Tenary operator for checkmark or X
        sb.append(", Checked=").append(Checked ? "\u2713" : "X" );
        //Tenary operator for the essential variable
        if((Boolean)Essential != null){
            sb.append(", Essential=").append(this.Essential ? "Essential" : "Non-Essential");
        }
        sb.append('}');
        return sb.toString();
    }

}

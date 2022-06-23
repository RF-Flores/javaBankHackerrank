package banking;

public class Company extends AccountHolder {
	private String companyName;

	public Company(String companyName, int taxId) {
		super(taxId);
		this.companyName = companyName;
	}

	public String getCompanyName() {
        return companyName;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || getClass() != other.getClass()) return false;
		Company otherCompany = (Company) other;
		return this.companyName.equals(otherCompany.companyName)
				&& this.getIdNumber() == otherCompany.getIdNumber();
	}
}

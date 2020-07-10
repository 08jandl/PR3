package at.campus02.pr3.beispiel1;

//
//!!! Diese Datei darf nicht verändert werden !!!
//

public class RechnungsPosition {
	private String bezeichnung;
	private double preis;
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "RechnungsPosition{" +
				"bezeichnung='" + bezeichnung + '\'' +
				", preis=" + preis +
				'}';
	}
}

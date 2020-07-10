package at.campus02.pr3.beispiel1;

import java.util.ArrayList;
import java.util.List;

//
//!!! Diese Datei darf nicht verändert werden !!!
//

public class Rechnung {
	private String rechnungsNr;
	private List<RechnungsPosition> positionen = new ArrayList<RechnungsPosition>();
	
	public String getRechnungsNr() {
		return rechnungsNr;
	}
	public void setRechnungsNr(String rechnungsNr) {
		this.rechnungsNr = rechnungsNr;
	}
	public List<RechnungsPosition> getPositionen() {
		return positionen;
	}
	public void setPositionen(List<RechnungsPosition> positionen) {
		this.positionen = positionen;
	}

	@Override
	public String toString() {
		return "Rechnung{" +
				"rechnungsNr='" + rechnungsNr + '\'' +
				", positionen=" + positionen +
				'}';
	}
}

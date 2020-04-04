package legoset;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Weight {
	@XmlValue
	private double value;
	
	@XmlAttribute
	private String unit;
	
	public Weight(String unit, double value) {
		this.unit = unit;
		this.value = value;
	}
}

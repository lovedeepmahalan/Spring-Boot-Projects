package in.pwskills.nitin.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Billing {

	//SPEL
	@Value("#{item.Idly+item.coffiee+item.dosa}")
	public int totalPrice;
	
	@Autowired
	public ItemInfo item;
	
	@Value("paradice")
	public String hotel;

	@Override
	public String toString() {
		return "Billing [totalPrice=" + totalPrice + ", item=" + item + ", hotel=" + hotel + "]";
	}
	
	
}

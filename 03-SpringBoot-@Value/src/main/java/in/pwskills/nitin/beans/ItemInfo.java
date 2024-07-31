package in.pwskills.nitin.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("item")
@PropertySource("in/pwskills/nitin/cfgs/app.properties")
public class ItemInfo {

	@Value("${idly.price}")
	public Integer Idly;
	
	@Value("${coffiee.price}")
	public Integer coffiee;
	
	@Value("${dosa.price}")
	public Integer dosa;
	@Override
	public String toString() {
		return "ItemInfo [idly="+Idly  + ", coffiee=" + coffiee + ", dosa=" + dosa + "]";
	}
	
	
	
}

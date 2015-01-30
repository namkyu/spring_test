import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ConvertTest implements Converter {

	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		String convertTest = (String) source;
		String value = null;
		if (convertTest.equals("Y")) {
			value = "converted";
		}

		writer.setValue(value);
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return reader.getValue();
	}

	public boolean canConvert(Class type) {
		return type.equals(String.class);
	}

}
package localization;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {

	@Override
	protected String[][] getContents() {
		return new String[][] {
			{ "hello", "Hello"},
			{ "open", "is open" }
		};
	}
}


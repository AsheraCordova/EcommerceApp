package r.android.content;

import java.io.Serializable;
import java.util.HashMap;

public class Intent {
	private HashMap<String, Object> mExtras;

	public Intent putExtra(String name, Object value) {
        if (mExtras == null) {
            mExtras = new HashMap<String, Object>();
        }
        mExtras.put(name, value);
        return this;
    }

	public Serializable getSerializableExtra(
			String localIntentOptionKey) {
		if (mExtras == null) {
			return null;
		}
		return (Serializable) mExtras.get(localIntentOptionKey);
	}
	

	public Object getExtra(
			String localIntentOptionKey) {
		if (mExtras == null) {
			return null;
		}
		return mExtras.get(localIntentOptionKey);
	}

	public String getStringExtra(String localDataKey) {
		if (mExtras == null) {
			return null;
		}
		Object object = mExtras.get(localDataKey);
		
		if (object instanceof String) {
			return  (String) object;
		}
		return null;
	}
}

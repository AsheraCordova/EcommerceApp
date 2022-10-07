package com.ashera.layout;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MultiSelectionSpinner extends androidx.appcompat.widget.AppCompatSpinner implements OnMultiChoiceClickListener {
    private String[] _items = null;
    private OnMultiItemSelectedListener onMultiItemSelectedListener;
    private boolean[] mSelection = null;
    private boolean[] mTmpSelection = null;
    private ArrayAdapter<String> simple_adapter;

	public MultiSelectionSpinner(Context context, com.ashera.layout.MultiSelectionSpinnerImpl widget) {
    	this(context, null, widget);
        
    }
    
    public MultiSelectionSpinner(Context context, int mode, com.ashera.layout.MultiSelectionSpinnerImpl widget) {
        this(context, widget);
    }

    public MultiSelectionSpinner(Context context, AttributeSet attrs, com.ashera.layout.MultiSelectionSpinnerImpl widget) {
        super(context, attrs);

        simple_adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item) {
        	@Override
        	public android.view.View getView(int position, android.view.View convertView,
        			android.view.ViewGroup parent) {
        		View view = super.getView(position, convertView, parent);
        		if (view instanceof TextView) {
        			widget.setAppCompatTextView((TextView) view);
        			widget.resetAttributes();
				}
				return view;
        	}
        };
        super.setAdapter(simple_adapter);
    }

    public MultiSelectionSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}
    
    public MultiSelectionSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public void onClick(DialogInterface dialog, int which, boolean isChecked) {

    }

    @Override
    public boolean performClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (mSelection != null) {
        	mTmpSelection = mSelection.clone();
        }
        builder.setMultiChoiceItems(_items, mTmpSelection, this);
        builder.setPositiveButton(android.R.string.ok, new Dialog.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (mSelection != null) {
					System.arraycopy(mTmpSelection, 0, mSelection, 0, mSelection.length);
				}
				setSelection(getSelectedIndicies());
			}
        	
        });
        builder.setNegativeButton(android.R.string.cancel, new Dialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (onMultiItemSelectedListener != null) {
                    onMultiItemSelectedListener.onNothingSelected(MultiSelectionSpinner.this, getSelectedIndicies());
                }
            }
        });
        builder.show();
        return true;
    }

    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        throw new RuntimeException(
                "setAdapter is not supported by MultiSelectSpinner.");
    }


	public void addItem(String val) {
		if (_items == null) {
			_items = new String[1];
		} else {
			_items = Arrays.copyOf(_items, _items.length + 1);
		}
		if (mSelection == null) {
			mSelection = new boolean[1];
		} else {
			mSelection = Arrays.copyOf(mSelection, mSelection.length + 1);
		}
		_items[_items.length - 1] = val;
		mSelection[mSelection.length - 1] = false;
	}
    public void setItems(List<String> items) {
        _items = items.toArray(new String[items.size() - 1]);
        mSelection = new boolean[_items.length];
        simple_adapter.clear();
        Arrays.fill(mSelection, false);
    }

    public void setSelection(List<Integer> selectedIndicies) {
    	if (mSelection != null) {
	        for (int i = 0; i < mSelection.length; i++) {
	            mSelection[i] = false;
	        }
	        for (int index : selectedIndicies) {
	            if (index >= 0 && index < mSelection.length) {
	                mSelection[index] = true;
	            } else {
	                throw new IllegalArgumentException("Index " + index
	                        + " is out of bounds.");
	            }
	        }
    	}
        simple_adapter.clear();
        simple_adapter.add(getSelectedItemsAsString());

        if (onMultiItemSelectedListener != null) {
            onMultiItemSelectedListener.onItemSelected(this, selectedIndicies);
        }
    }

    public List<String> getSelectedStrings() {
        List<String> selection = new LinkedList<String>();
        if (_items != null) {
	        for (int i = 0; i < _items.length; ++i) {
	            if (mSelection[i]) {
	                selection.add(_items[i]);
	            }
	        }
        }
        return selection;
    }

    public List<Integer> getSelectedIndicies() {
        List<Integer> selection = new LinkedList<Integer>();
        if (_items != null) {
	        for (int i = 0; i < _items.length; ++i) {
	            if (mSelection[i]) {
	                selection.add(i);
	            }
	        }
        }
        return selection;
    }

   
    public String getSelectedItemsAsString() {
        StringBuilder sb = new StringBuilder();
        boolean foundOne = false;
        if (_items != null) {
	        for (int i = 0; i < _items.length; ++i) {
	            if (mSelection[i]) {
	                if (foundOne) {
	                    sb.append(", ");
	                }
	                foundOne = true;
	                sb.append(_items[i]);
	            }
	        }
        }
        
        return sb.toString();
    }

    public void setOnMultiItemSelectedListener(OnMultiItemSelectedListener onMultiItemSelectedListener) {
        this.onMultiItemSelectedListener = onMultiItemSelectedListener;
    }


    /**
     * Interface definition for a callback to be invoked when
     * an item in this view has been selected.
     */
    public interface OnMultiItemSelectedListener {
        /**
         * <p>Callback method to be invoked when an item in this view has been
         * selected. This callback is invoked only when the newly selected
         * position is different from the previously selected position or if
         * there was no selected item.</p>
         *
         * Impelmenters can call getItemAtPosition(position) if they need to access the
         * data associated with the selected item.
         *
         * @param view The view within the AdapterView that was clicked
         * @param positions The position of the view in the adapter
         */
        void onItemSelected(View view, List<Integer> positions);

        /**
         * Callback method to be invoked when the selection disappears from this
         * view. The selection can disappear for instance when touch is activated
         * or when the adapter becomes empty.
         *
         * @param view The view within the AdapterView that was clicked
         * @param positions The position of the view in the adapter
         */
        void onNothingSelected(View view, List<Integer> positions);
    }
}
package com.example.testp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class testfrag extends Fragment implements View.OnClickListener{
	private int position;
	private Button mBtnLayoutChange;
	
	public testfrag() {
		
	}
		
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		if (null != saved) {
			position = saved.getInt("posValue");
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle save) {
		save.putInt("posValue", position);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
    	View view = inflater.inflate(R.layout.mylayout1, container, false);
    	//���oview�W��item
    	mBtnLayoutChange = (Button) view.findViewById(R.id.button1);
    	mBtnLayoutChange.setOnClickListener(this);
	    return view;
	}
	
	@Override
	public void onClick(View v) {
		if (v == mBtnLayoutChange) {
			Fragment fr2 = new testfrag2();
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.fragment1, fr2);
			ft.commit();
		}
	}
}

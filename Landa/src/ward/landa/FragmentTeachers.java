package ward.landa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentTeachers extends Fragment {

	List<Teacher> l;
	
	callbackTeacher tCallback;
	
	public interface callbackTeacher{
		public void OnTeacherItemClick(Teacher t);
	}
	
	
	@Override
	public void onAttach(Activity activity) {
		try {
			tCallback = (callbackTeacher) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement callbackTeacher");
		}
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.teacher_custom_grid, container,
				false);
		l = new ArrayList<Teacher>();

		// ////////////////////Testing//////////////////////////
		Teacher t1=new Teacher(0000, R.drawable.ward, "ward","mail@ward.com","0555","חברתי","CS");
		Teacher t2=new Teacher(111, R.drawable.mohammed, "Mohammed","mail@mohammed.com","015","אקדמי","CS");
		Teacher t3=new Teacher(121, R.drawable.hamed, "Hammed","mail@hamed.com","0555","רכז אקדמי","מתמטיקה");
		Teacher t4=new Teacher(333, R.drawable.stlzbale, "حسن","mail@stlzbale.com","0555","רכז חברתי","CS");
		Teacher t5=new Teacher(888, R.drawable.aiman, "ايمن","mail@aiman.com","0555","אקדמי","כימיה");
		Teacher t6=new Teacher(444, R.drawable.almotna, "Almothana","mail@almotna.com","0555","אקדמי","CS");
		Teacher t7=new Teacher(555, R.drawable.mhde, "Mahade","mail@mhde.com","0555","חברתי","אזרחית");
		Teacher t8=new Teacher(666, R.drawable.gasan, "Ghasan","mail@gasan.com","0555","אקדמי","CS");
		Teacher t9=new Teacher(777, R.drawable.rami, "الله لا يكبرو","mail@rami.com","0555","חברתי","תעשיה ניהוך");	
		l.add(t1);
		l.add(t2);
		l.add(t3);
		l.add(t4);
		l.add(t5);
		l.add(t6);
		l.add(t7);
		l.add(t8);
		l.add(t9);
		GridView gridView = (GridView)root.findViewById(R.id.gridview);
        gridView.setAdapter(new gridAdabter(root.getContext()));
        
        gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				tCallback.OnTeacherItemClick(l.get(arg2));
				
			}
		});
		// ////////////////////Testing//////////////////////////
		return root;
	}

	class gridAdabter extends BaseAdapter {

		LayoutInflater inflater;

		public gridAdabter(Context context) {
			this.inflater = LayoutInflater.from(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public int getCount() {
		
			return 	l.size();
		}

		@Override
		public Object getItem(int arg0) {

			return l.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {

			return l.get(arg0).getID();
		}

		@Override
		public View getView(int pos, View view, ViewGroup viewGroup) {
			// TODO Auto-generated method stub
			View v = view;
			ImageView picture;
			TextView name;

			if (v == null) {
				v = inflater.inflate(R.layout.grid_textimg_item, viewGroup, false);
				v.setTag(R.id.picture, v.findViewById(R.id.picture));
				v.setTag(R.id.text, v.findViewById(R.id.text));
			}
			picture = (ImageView) v.getTag(R.id.picture);
			name = (TextView) v.getTag(R.id.text);

			Teacher teacher = (Teacher) getItem(pos);

			picture.setImageResource(teacher.getImgId());
			name.setText(teacher.toString());

			return v;
		}
	}

}

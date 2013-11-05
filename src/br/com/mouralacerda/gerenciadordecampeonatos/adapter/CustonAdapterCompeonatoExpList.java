package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

import com.example.gerenciadordecampeonatos.R;

public class CustonAdapterCompeonatoExpList extends BaseExpandableListAdapter {

	private Context context;
	private List<CampeonatoModel> groupCampeonatoList;
	private Map<String, List<RodadaModel>> collection;

	public CustonAdapterCompeonatoExpList(Context context, List<CampeonatoModel> groupCampeonatoList,
			Map<String, List<RodadaModel>> collection) {
		this.context = context;
		this.groupCampeonatoList = groupCampeonatoList;
		this.collection = collection;
	}

	@Override
	public RodadaModel getChild(int groupPosition, int childPosition) {
		return collection.get(groupCampeonatoList.get(groupPosition).getNomeCampeonato()).get(
				childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		final RodadaModel childRodada = getChild(groupPosition,
				childPosition);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.layout_item_child_rodada,
					null);
		}

		TextView item = (TextView) convertView
				.findViewById(R.itemChild.childRodada);

		item.setTypeface(null, Typeface.ITALIC);
		item.setText("Rodada " + childRodada.getNumeroRodada());
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		int i = collection.get(groupCampeonatoList.get(groupPosition).getNomeCampeonato()).size();
		return i;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupCampeonatoList.get(groupPosition).getNomeCampeonato();
	}

	@Override
	public int getGroupCount() {
		return groupCampeonatoList.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		String groupCampeonato = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_item_group_campeonato,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.groupCampeonato.groupName);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(groupCampeonato);
        return convertView;
	
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}

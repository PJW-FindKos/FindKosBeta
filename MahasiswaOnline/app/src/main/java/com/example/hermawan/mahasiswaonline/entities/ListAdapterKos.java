package com.example.hermawan.mahasiswaonline.entities;

/**
 * Created by hermawan on 12/06/2015.
 */

import java.util.ArrayList;
import java.util.List;
import com.example.hermawan.mahasiswaonline.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class ListAdapterKos extends BaseAdapter implements Filterable{
    private Context context;
    private List<Kos> list, filterd;

    public ListAdapterKos(Context context, List<Kos> list) {
        this.context = context;
        this.list = list;
        this.filterd = this.list;
    }
    @Override
    public int getCount() {
        return filterd.size();
    }

    @Override
    public Object getItem(int position) {
        return filterd.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.list_row, null);
        }
        Kos kos = filterd.get(position);
        TextView textNama = (TextView) convertView.findViewById(R.id.text_nama);
        textNama.setText(kos.getNamaPemilik());

        TextView textNim = (TextView) convertView.findViewById(R.id.text_nim);
        textNim.setText(kos.getNoHP());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        KosFilter filter = new KosFilter();
        return filter;
    }

    /** Class filter untuk melakukan filter (pencarian) */
    private class KosFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Kos> filteredData = new ArrayList<Kos>();
            FilterResults result = new FilterResults();
            String filterString = constraint.toString().toLowerCase();
            for(Kos kos: list){
                if(kos.getNamaPemilik().toLowerCase().contains(filterString) || kos.getNoHP().toLowerCase().contains(filterString)){
                    filteredData.add(kos);
                }
            }
            result.count = filteredData.size();
            result.values = filteredData;
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterd = (List<Kos>) results.values;
            notifyDataSetChanged();
        }
    }
}


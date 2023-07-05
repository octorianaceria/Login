package com.octoriana201103650.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class CuacaAdapter extends RecyclerView.Adapter {
    private Activity _activity;
    private List<CuacaListModel> _listModelList;
    private CuacaRootModel _rootModel;

    public CuacaAdapter(Activity activity,CuacaRootModel rm) {
        this._activity = activity;
        this._rootModel = rm;

        _listModelList = rm.getListModelList();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cuaca, parent, false);
        return new CuacaViewHolder(view);
    }

    private double toCelcius(double kelvin) {return kelvin - 272.15;}

    private String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CuacaListModel lm = _listModelList.get(position);
        CuacaWeatherModel wm = lm.getWeatherModelList().get(0);
        CuacaMainModel mm = lm.getMainModel();

        String suhu = formatNumber(toCelcius(mm.getTemp_min()),"###.###") + "°C - " +
                formatNumber(toCelcius(mm.getTemp_max()), "###.###") + "°C";

        String iconUrl = "https://openweathermap.org/img/wn" + wm.getIcon() + "@2x.png";
        Picasso.with(_activity).load(iconUrl).into(holder.cuacaImageView);

        String tanggalWaktuWib = formatWib(lm.getDt_txt());

        holder.namaTextView.setText(wm.getMain());
        holder.deskripsiTextView.setText(wm.getDescription());
        holder.tglWaktuTextView.setText((tanggalWaktuWib));
        holder.suhuTextView.setText(suhu);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

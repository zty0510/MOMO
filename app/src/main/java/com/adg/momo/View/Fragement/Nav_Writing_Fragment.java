package com.adg.momo.View.Fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adg.momo.R;
import com.adg.momo.View.Wordlist_Choose;

import es.dmoral.toasty.Toasty;

/**
 * Created by mjj on 2018/9/26
 */
public class Nav_Writing_Fragment extends Fragment {
    private Button btn_dic_gaokao;
    private Button btn_dic_six;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_writing_fragment, container, false);
        btn_dic_gaokao = view.findViewById(R.id.btn_dic_gaokao);
        btn_dic_six = view.findViewById(R.id.btn_dic_six);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_dic_gaokao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Wordlist_Choose.class);
                startActivity(intent);
            }
        });
        btn_dic_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.normal(getActivity(),"敬请期待",Toasty.LENGTH_SHORT).show();
            }
        });
    }
}



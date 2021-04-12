package com.fti.recyclerview;

import java.util.ArrayList;

public class MotorcycleData {
    private static String[] title = new String[]{"Real Madrid", "AC Milan","FC Barcelona", "Bayern Munchen","Chelsea FC","Manchester United","Arsenal FC"};
    private static int[] thumbnail = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    public static ArrayList<MotorcycleModel> getListData(){
        MotorcycleModel motorcycleModel = null;
        ArrayList<MotorcycleModel> list = new ArrayList<>();
        for(int i = 0; i < title.length; i++){
            motorcycleModel = new MotorcycleModel();
            motorcycleModel.setLogoTeam(thumbnail[i]);
            motorcycleModel.setNamaTeam(title[i]);
            list.add(motorcycleModel);
        }
        return list;
    }
}

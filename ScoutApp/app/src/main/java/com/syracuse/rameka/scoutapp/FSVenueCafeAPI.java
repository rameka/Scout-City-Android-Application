package com.syracuse.rameka.scoutapp;

import com.syracuse.rameka.scoutapp.FourSquareVenueCafeModel.FSVenueCafeModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This file acts as an API call to the server.This API could make two requests to the server one is to search the nearby cafes,
 * and the other is to search nearby restaurants in the selected city.
 * NOTE: 1)Four Square API is used throughout the application to search for different details about places.
 *       2)Retrofit is used to make calls to the server from Android Studio
 */

public class FSVenueCafeAPI {
    //Following are the keys received from the foursquare website when registered.
    public static final String CLIENT_ID = "OEP4H5DPW3R43JVQ0NVBU2BGKJEHKLHDB3I4X0TBIH1GYERY";
    public static final String CLIENT_SECRECT = "42O1PNTOG1LXDNMTQ3COTWH1A3GBJOKD4LZ4WZSD23PROG5R";

    public static final String url = "https://api.foursquare.com/v2/";

    public static VenueCafeService venueCafeService = null;

    //Returns retrofit instance for the CafeAPI to make calls to server
    public static VenueCafeService getService(){
        if(venueCafeService ==null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                    .build();
            venueCafeService = retrofit.create(VenueCafeService.class);
        }
        return venueCafeService;
    }

    public interface VenueCafeService{

        //Calls the server to fetch the cafe details in JSON format based on the passed latitude and longitude
        @GET("venues/explore?client_id=JO0RTJORSERKBRXCG4OC1JUWXMDGHEUPDWRU33ILZLRJQW1Y&client_secret=B1W5DDTRZB5LPKU0DEFHYLZFSCNB4R44224X2W0PIX1T22O1&v=20161101&intent=coffee")
        Call<FSVenueCafeModel> searchCafe(@Query("ll") String latlng);

        //Calls the server to fetch the Restaurent details in JSON format based on the passed latitude and longitude
        @GET("venues/explore?client_id=JO0RTJORSERKBRXCG4OC1JUWXMDGHEUPDWRU33ILZLRJQW1Y&client_secret=B1W5DDTRZB5LPKU0DEFHYLZFSCNB4R44224X2W0PIX1T22O1&v=20161101&intent=food")
        Call<FSVenueCafeModel> searchFood(@Query("ll") String latlng);

    }

}

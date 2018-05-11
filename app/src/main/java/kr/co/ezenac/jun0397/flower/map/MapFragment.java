package kr.co.ezenac.jun0397.flower.map;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhn.android.maps.NMapContext;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapProjection;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Store;
import kr.co.ezenac.jun0397.flower.R;

/**
 * Created by Administrator on 2018-03-26.
 */

public class MapFragment extends NMapFragment {

    private static final String CLIENT_ID = "30Y3N27ylFbDbmuIwsya";

    private NMapContext nMapContext;
    private NMapView nMapView;
    private NMapController nMapController;
    private NMapOverlayManager nMapOverlayManager;
    private NMapViewerResourceProvider nMapViewerResourceProvider;

    ArrayList<Store> stores = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nMapContext = new NMapContext(super.getActivity());

        nMapContext.onCreate();


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nMapView = (NMapView)getView().findViewById(R.id.mapView);
        nMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 설정

        nMapContext.setupMapView(nMapView);
    }

    @Override
    public void onStart(){
        super.onStart();
        nMapContext.onStart();

        nMapView.setClickable(true);
        nMapView.displayZoomControls(true);
        nMapView.setEnabled(true);

        nMapView.setOnMapStateChangeListener(onMapStateChangeListener);
        nMapController = nMapView.getMapController();
        nMapViewerResourceProvider = new NMapViewerResourceProvider(getActivity());
        nMapOverlayManager = new NMapOverlayManager(getActivity(), nMapView, nMapViewerResourceProvider);
        NMapProjection nMapProjection;

        int markerId = NMapPOIflagType.PIN;

        Bundle bundle = getArguments();
        ArrayList<Store> list = bundle.getParcelableArrayList("district");


       /* Log.d("args", "getArgs: " +getArguments().getParcelableArrayList("district"));

        Log.d("map","map: " +list);*/
        /*Intent intent = getActivity().getIntent();
        ArrayList<Store> list = (ArrayList<Store>) intent.getSerializableExtra("district");*/


        // set POI data
        NMapPOIdata poiData = new NMapPOIdata(2, nMapViewerResourceProvider);
        poiData.beginPOIdata(2);

        for (int i = 0; i < list.size(); i++) {
            poiData.addPOIitem(list.get(i).getLon(), list.get(i).getLat(), list.get(i).getName(), markerId, 0);

            Log.d("size", "size: " +list.size());
            Log.d("list", "Lon" +i +": " +list.get(i).getLon() +"Lat: " +list.get(i).getLat());
        }

        poiData.endPOIdata();

        // create POI data overlay
        NMapPOIdataOverlay poiDataOverlay = nMapOverlayManager.createPOIdataOverlay(poiData, null);
        // show all POI data
        poiDataOverlay.showAllPOIdata(0);

    }
    @Override
    public void onResume() {
        super.onResume();
        nMapContext.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        nMapContext.onPause();
    }
    @Override
    public void onStop() {
        nMapContext.onStop();
        super.onStop();
    }
    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        nMapContext.onDestroy();
        super.onDestroy();
    }

    NMapView.OnMapStateChangeListener onMapStateChangeListener = new NMapView.OnMapStateChangeListener() {
        @Override
        public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
            if(nMapError == null){
                /*nMapController.setMapCenter(new NGeoPoint(127.0225713, 37.5025202), 14);*/
            } else{
                Log.d("kac", "setError");
            }
        }

        @Override
        public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {

        }

        @Override
        public void onMapCenterChangeFine(NMapView nMapView) {

        }

        @Override
        public void onZoomLevelChange(NMapView nMapView, int i) {

        }

        @Override
        public void onAnimationStateChange(NMapView nMapView, int i, int i1) {

        }
    };
}

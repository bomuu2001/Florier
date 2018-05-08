package kr.co.ezenac.jun0397.flower.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Fragment1 extends Fragment {

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

        ArrayList<Store> list = (ArrayList<Store>) getActivity().getIntent().getSerializableExtra("district");
        /*Intent intent = getActivity().getIntent();
        String district = intent.getStringExtra("district");*/



        // set POI data
        NMapPOIdata poiData = new NMapPOIdata(2, nMapViewerResourceProvider);
        poiData.beginPOIdata(2);
        /*for(int i=0; i<list.size(); i++) {
            poiData.addPOIitem(list.get(i).getLon(), list.get(i).getLat(), list.get(i).getName(), markerId, 0);
        }*/
        poiData.addPOIitem(127.025393, 37.501809, "ezen2", markerId, 0);
        poiData.endPOIdata();

        // create POI data overlay
        NMapPOIdataOverlay poiDataOverlay = nMapOverlayManager.createPOIdataOverlay(poiData, null);
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
                nMapController.setMapCenter(new NGeoPoint(127.0225713, 37.5025202), 14);
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

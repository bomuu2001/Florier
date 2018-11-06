package kr.co.ezenac.jun0397.flower.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhn.android.maps.NMapContext;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapProjection;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;

import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.beans.Store;

public class MapFragment extends NMapFragment {
    private static final String CLIENT_ID = "RZR4oXBL2cFAvo9M7mtF";

    private NMapContext nMapContext;
    private NMapView nMapView;
    private NMapController nMapController;
    private NMapOverlayManager nMapOverlayManager;
    private NMapViewerResourceProvider nMapViewerResourceProvider;

    private NMapPOIdataOverlay.OnStateChangeListener onPOIdataStateChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nmap, container, false);
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
    public void onStart() {
        super.onStart();
        nMapContext.onStart();

        nMapView.setClickable(true);
        nMapView.setEnabled(true);
        // 확대/축소를 위한 줌 컨트롤러 표시 옵션 활성화
        nMapView.setBuiltInZoomControls(true, null);

        nMapView.setOnMapStateChangeListener(onMapStateChangeListener);
        nMapController = nMapView.getMapController();
        nMapViewerResourceProvider = new NMapViewerResourceProvider(getActivity());
        nMapOverlayManager = new NMapOverlayManager(getActivity(), nMapView, nMapViewerResourceProvider);
        NMapProjection nMapProjection;

        int markerId = NMapPOIflagType.PIN;

        // set POI data (핀찍기)
        NMapPOIdata poiData = new NMapPOIdata(2, nMapViewerResourceProvider);
        poiData.beginPOIdata(2);
            //위치 데이터 넘겨옴(선택 지역 꽃집 리스트)
            Bundle bundle = getArguments();
            Log.d("ljy","받는 번들 = "+bundle);
            if(bundle != null) {
                ArrayList<Store> items = bundle.getParcelableArrayList("list");

                Log.d("ljy", "받는 bundle = " + items);
                for (int i = 0; i < items.size(); i++) {
                    poiData.addPOIitem(items.get(i).getLon(), items.get(i).getLat(), items.get(i).getName(), markerId, 0);
                }
            }else{
                return;
            }
        poiData.endPOIdata();

        // create POI data overlay
        NMapPOIdataOverlay poiDataOverlay = nMapOverlayManager.createPOIdataOverlay(poiData, null);
        // show all POI data
        poiDataOverlay.showAllPOIdata(0);

        // set event listener to the overlay
        poiDataOverlay.setOnStateChangeListener(onPOIdataStateChangeListener);

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

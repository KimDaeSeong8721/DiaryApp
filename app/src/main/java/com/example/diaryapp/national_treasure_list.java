package com.example.diaryapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.os.Handler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.ArrayList;

public class national_treasure_list extends Activity{
    int page = 1;


    ArrayList<cultureData> cultureDataList = new ArrayList();

    String url =  "https://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex"+page;
    ListView listView ;
     MyAdapter myAdapter ;
    private final int MSG_A = 0 ;
    private final int MSG_B = 1 ;

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_A :
                    myAdapter.notifyDataSetChanged();
                    break ;
                case MSG_B :
                    break ;
                // TODO : add case.
            }
        }
    } ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.national_treasure_list);
        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapter.notifyDataSetChanged();
            }
        });

         listView = (ListView)findViewById(R.id.nationalListView);
         myAdapter = new MyAdapter(this,cultureDataList);
        listView.setAdapter(myAdapter);


        new Thread(new Runnable() {
        @Override
        public void run() {
                doInBackground();
        }
    }).start();


    }

    protected String doInBackground(Void... params) {

        // parsing할 url 지정(API 키 포함해서)
        try{
            while(true){
                // parsing할 url 지정(API 키 포함해서)

                Handler handler = mHandler ;
                Message message = handler.obtainMessage();
                message.what = MSG_A ;
                //String url_detail = "https://www.cha.go.kr/cha/SearchKindOpenapiDt.do?ccbaKdcd="+11+"&ccbaAsno=+"+00010000+"&ccbaCtcd="+11;
                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                // root tag
                doc.getDocumentElement().normalize();
                //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                // 파싱할 tag

                NodeList nList = doc.getElementsByTagName("item");

                for(int temp = 0; temp < nList.getLength(); temp++){
                    Node nNode = nList.item(temp);
                    if(nNode.getNodeType() == Node.ELEMENT_NODE){
                        Element eElement = (Element) nNode;

                        if( getTagValue("ccmaName",eElement).equals("국보")){

                            String name =   "문화재명  : " + getTagValue("ccbaMnm1", eElement);
                            String district = "지역  : " + getTagValue("ccbaCtcdNm", eElement);
                          //  String longitude = "경도 : " + getTagValue("longitude", eElement);
                            //String latitude =  "위도  : " + getTagValue("latitude", eElement);

                            cultureData culture = new cultureData(name,district);

                            cultureDataList.add(culture);

                        }
                    }   // for end
                }   // if end

                page += 1;
                if(page > 36){
//                    for(int z=0; z<list.size(); z++) {
//                        String tmp[] = (String[])list.get(z);
//                        for(int x=0; x<tmp.length; x++) {
//                            System.out.print("[" + tmp[x] +"] ");
//                        }
//                        System.out.println();
//                    }

                    break;
                }
                handler.sendMessage(message);
            }   // while end

        } catch (Exception e){
            e.printStackTrace();
        }   // try~catch end

        return null;
    }



    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }
}

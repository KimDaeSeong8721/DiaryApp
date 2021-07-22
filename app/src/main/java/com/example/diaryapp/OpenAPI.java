package com.example.diaryapp;

import android.os.AsyncTask;
import android.util.Log;

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

public class OpenAPI extends AsyncTask<Void, Void, String> {
    int page = 1;

    private String url;
    ArrayList<String[]> list = new ArrayList();
    public OpenAPI() {

        this.url =  "https://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex"+page;

    }
    @Override
    protected String doInBackground(Void... params) {

        // parsing할 url 지정(API 키 포함해서)
        try{
            while(true){
                // parsing할 url 지정(API 키 포함해서)

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
                            String longitude = "경도 : " + getTagValue("longitude", eElement);
                            String latitude =  "위도  : " + getTagValue("latitude", eElement);

                            String array[] = {name,district,longitude,latitude};

                            list.add(array);

                        }
                    }   // for end
                }   // if end

                page += 1;
                if(page > 36){
                    for(int z=0; z<list.size(); z++) {
                        String tmp[] = (String[])list.get(z);
                        for(int x=0; x<tmp.length; x++) {
                            System.out.print("[" + tmp[x] +"] ");
                        }
                        System.out.println();
                    }

                    break;
                }
            }   // while end

        } catch (Exception e){
            e.printStackTrace();
        }   // try~catch end

        return null;
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
    }


    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

}
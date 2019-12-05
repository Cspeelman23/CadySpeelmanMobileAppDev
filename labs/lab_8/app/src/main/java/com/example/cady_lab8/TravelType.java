package com.example.cady_lab8;

public class TravelType {
    private String TransportMode;
    private String SiteURL;


    private void setTravelInfo(Integer radioSelect) {
        switch (radioSelect){
            case 0: // air
                TransportMode = "a hot air balloon";
                SiteURL = "http://www.hotairballoonridescolorado.com/?gclid=EAIaIQobChMIp-ulk8CY5gIVENvACh0xFgpvEAAYASAAEgJY3fD_BwE";
                break;
            case 1: // land
                TransportMode = "a train";
                SiteURL = "https://www.colorado.com/articles/complete-guide-colorado-train-trips";
                break;
            case 2: // sea
                TransportMode = "a cruise ship";
                SiteURL = "https://www.carnival.com";
                break;
            default:// none selected
                TransportMode = "a place nearby";
                SiteURL = "https://www.google.com/maps";
        }
    }
    public void setTransportMode(int radioSelect){
        setTravelInfo(radioSelect);
    }
    public void setSiteURL(int radioSelect){
        setTravelInfo(radioSelect);
    }
    public String getTransportMode(){
        return TransportMode;
    }
    public String getSiteURL(){
        return SiteURL;
    }
}

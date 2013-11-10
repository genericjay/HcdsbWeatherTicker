/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hcdsbweatherticker;

import java.io.IOException;
import java.util.LinkedList;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;

/**
 *
 * @author Jay
 */
public class WeatherTickerCache {
    private static final String KEY = "API_KEY"; // API Key
    private static final String HOURLY_REQUEST = "http://api.wunderground.com/api/" + KEY + "/hourly/conditions/astronomy/q/Canada/Oakville.xml";
    private static WeatherTickerCache instance;
    
    public static WeatherTickerCache getInstance() {
        if (instance == null) {
            instance = new WeatherTickerCache();
        }
        return instance;
    }
    
    private long timeSinceRequest; // Time since last hourly update request
    public WeatherTickerCache() {
        load();
    }
    
    private LinkedList<WeatherTickerInfo> dailyInfo = new LinkedList<WeatherTickerInfo>();
    
    private void load() {
        try {
            Builder parser = new Builder();
            Document doc = parser.build(HOURLY_REQUEST);
            Element response = doc.getRootElement();
            
            Element conditions = response.getFirstChildElement("current_observation");
            Element hourlyForecast = response.getFirstChildElement("hourly_forecast");
            Elements hourlyElements = hourlyForecast.getChildElements();
            Element moonPhase = response.getFirstChildElement("moon_phase");
            
            for (int i = 0; i < 12; i++) {
                Element currentHour = hourlyElements.get(i);
                WeatherTickerInfo info = new WeatherTickerInfo();
                info.setGustSpeed((int)Math.round(Double.parseDouble(conditions.getFirstChildElement("wind_gust_kph").getValue())));
                info.setWindDirection(conditions.getFirstChildElement("wind_dir").getValue());
                info.setVisibility(Double.parseDouble(conditions.getFirstChildElement("visibility_km").getValue()));
                info.setDate(currentHour.getFirstChildElement("FCTTIME").getFirstChildElement("pretty").getValue());
                info.setEpoch(Long.parseLong(currentHour.getFirstChildElement("FCTTIME").getFirstChildElement("epoch").getValue()) * 1000);
                info.setCelsius(Integer.parseInt(currentHour.getFirstChildElement("temp").getFirstChildElement("metric").getValue()));
                info.setConditions(currentHour.getFirstChildElement("condition").getValue());
                info.setConditionImage(currentHour.getFirstChildElement("icon_url").getValue());
                info.setWindSpeed(Integer.parseInt(currentHour.getFirstChildElement("wspd").getFirstChildElement("metric").getValue()));
                info.setFeelsLike(Integer.parseInt(currentHour.getFirstChildElement("feelslike").getFirstChildElement("metric").getValue()));
                info.setHumidity(Integer.parseInt(currentHour.getFirstChildElement("humidity").getValue()));
                info.setPressure(Integer.parseInt(currentHour.getFirstChildElement("mslp").getFirstChildElement("metric").getValue()) / 10);
                info.setSunriseHour(Integer.parseInt(moonPhase.getFirstChildElement("sunrise").getFirstChildElement("hour").getValue()));
                info.setSunriseMinute(Integer.parseInt(moonPhase.getFirstChildElement("sunrise").getFirstChildElement("minute").getValue()));
                info.setSunsetHour(Integer.parseInt(moonPhase.getFirstChildElement("sunset").getFirstChildElement("hour").getValue()));
                info.setSunsetMinute(Integer.parseInt(moonPhase.getFirstChildElement("sunset").getFirstChildElement("minute").getValue()));
            
                dailyInfo.add(info);
            }
            timeSinceRequest = System.currentTimeMillis();
        } catch (ParsingException ex) {
            ex.printStackTrace(); // TODO: Additional error handling!
        } catch (IOException ex) {
            ex.printStackTrace(); // TODO: Additional error handling!
        }
    }
    
    /**
     * 
     * @return Returns the most recent hour of weather ticker info
     */
    public WeatherTickerInfo getInfo() {
        if (dailyInfo.size() <= 2) {
            dailyInfo.removeLast();
            load();
        }
        return dailyInfo.getFirst();
    }
}

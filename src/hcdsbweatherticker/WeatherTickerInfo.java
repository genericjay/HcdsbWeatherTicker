/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hcdsbweatherticker;

/**
 *
 * @author Jay
 */
public class WeatherTickerInfo {
    private long epoch;
    private String date;
    private int celsius; // Regular temperature
    private String conditions; // Clear, cloudy, etc.
    private String conditionImage; // Image to weather undeground image for these conditions TODO: Predownload and load from memory.
    private int windSpeed; // Speed in km/h
    private int gustSpeed; // Gust speed in km/h
    private String windDirection; // NNW, NWW, cardinal direction.
    private int humidity; // Relative Humidity %
    private int feelsLike; // Temperature it feels like in degrees celsius
    private double pressure; // Taken from XML in Hectopascals, convert to kilopascals.
    private double visibility; // Visibility in km
    private int sunsetHour; // Hour of the sunset
    private int sunsetMinute; // Minute of the sunset
    private int sunriseHour; // Hour of the sunrise
    private int sunriseMinute; // Minute of the sunrise

    /**
     * @return the epoch
     */
    public long getEpoch() {
        return epoch;
    }
    
    /**
     * @param epoch the epoch to set
     */
    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }
    
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the celsius
     */
    public int getCelsius() {
        return celsius;
    }

    /**
     * @param celsius the celsius to set
     */
    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    /**
     * @return the conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * @return the conditionImage
     */
    public String getConditionImage() {
        return conditionImage;
    }

    /**
     * @param conditionImage the conditionImage to set
     */
    public void setConditionImage(String conditionImage) {
        this.conditionImage = conditionImage;
    }

    /**
     * @return the windSpeed
     */
    public int getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the gustSpeed
     */
    public int getGustSpeed() {
        return gustSpeed;
    }

    /**
     * @param gustSpeed the gustSpeed to set
     */
    public void setGustSpeed(int gustSpeed) {
        this.gustSpeed = gustSpeed;
    }

    /**
     * @return the windDirection
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * @param windDirection the windDirection to set
     */
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * @return the humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the feelsLike
     */
    public int getFeelsLike() {
        return feelsLike;
    }

    /**
     * @param feelsLike the feelsLike to set
     */
    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    /**
     * @return the pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the visibility
     */
    public double getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the sunsetHour
     */
    public int getSunsetHour() {
        return sunsetHour;
    }

    /**
     * @param sunsetHour the sunsetHour to set
     */
    public void setSunsetHour(int sunsetHour) {
        this.sunsetHour = sunsetHour;
    }

    /**
     * @return the sunsetMinute
     */
    public int getSunsetMinute() {
        return sunsetMinute;
    }

    /**
     * @param sunsetMinute the sunsetMinute to set
     */
    public void setSunsetMinute(int sunsetMinute) {
        this.sunsetMinute = sunsetMinute;
    }

    /**
     * @return the sunriseHour
     */
    public int getSunriseHour() {
        return sunriseHour;
    }

    /**
     * @param sunriseHour the sunriseHour to set
     */
    public void setSunriseHour(int sunriseHour) {
        this.sunriseHour = sunriseHour;
    }

    /**
     * @return the sunriseMinute
     */
    public int getSunriseMinute() {
        return sunriseMinute;
    }

    /**
     * @param sunriseMinute the sunriseMinute to set
     */
    public void setSunriseMinute(int sunriseMinute) {
        this.sunriseMinute = sunriseMinute;
    }
    
}

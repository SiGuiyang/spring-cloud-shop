package quick.pager.shop.utils;

/**
 * 经纬度计算工具
 *
 * @author siguiyang
 */
public class LatitudeLongitudeUtil {

    private static final double EARTH_RADIUS = 6378137;

    private static final double RAD = Math.PI / 180.0;

    public static double[] getAround(double lat, double lon, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;

        Double radiusLat = (1 / degree) * (double) raidus;
        double minLat = latitude - radiusLat;
        double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));

        Double radiusLng = (1 / mpdLng) * (double) raidus;
        double minLng = longitude - radiusLng;
        double maxLng = longitude + radiusLng;

        return new double[]{minLat, minLng, maxLat, maxLng};
    }


    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = lat1 * RAD;
        double radLat2 = lat2 * RAD;
        double a = radLat1 - radLat2;
        double b = (lng1 - lng2) * RAD;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        return Math.round(s * 10000) / (double) 10000;
    }
}

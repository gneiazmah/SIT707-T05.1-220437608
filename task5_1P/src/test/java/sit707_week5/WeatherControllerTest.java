package sit707_week5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static double minTemperature;
    private static double maxTemperature;
    private static double averageTemperature;

    @BeforeClass
    public static void setUp() {
        wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();
        hourlyTemperatures = new double[nHours];
        double sumTemp = 0;
        minTemperature = Double.MAX_VALUE;
        maxTemperature = Double.MIN_VALUE;
        for (int i = 0; i < nHours; i++) {
            double temp = wController.getTemperatureForHour(i + 1);
            hourlyTemperatures[i] = temp;
            sumTemp += temp;
            if (temp < minTemperature) minTemperature = temp;
            if (temp > maxTemperature) maxTemperature = temp;
        }
        averageTemperature = sumTemp / nHours;
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "YOUR_STUDENT_ID";
        Assert.assertNotNull("220437608", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "YOUR_NAME";
        Assert.assertNotNull("Azmah", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemperature);
    }

    @Test
    public void testTemperaturePersist() {
        // This test is commented out as it is for task 5.3C.
        // Uncomment and complete it if needed.
        /*
        System.out.println("+++ testTemperaturePersist +++");

        String persistTime = wController.persistTemperature(10, 19.5);
        String now = new SimpleDateFormat("H:m:s").format(new Date());
        System.out.println("Persist time: " + persistTime + ", now: " + now);

        Assert.assertTrue(persistTime.equals(now));

        wController.close();
        */
    }
}

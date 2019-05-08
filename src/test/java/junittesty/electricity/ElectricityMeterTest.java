package junittesty.electricity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricityMeterTest {

    @Test
    public void addKwhNewMetter() {

        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assert.assertTrue(electricityMeter.getKwh() == 1);

    }

    @Test
    public void addKwhNewMetter2() {

        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        Assert.assertTrue(electricityMeter.getKwh() == 5);

    }

    @Test
    public void addKwhNewMetter4() {

        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        Assert.assertTrue(electricityMeter.getKwh() == 13);

    }

    @Test
    public void givenNewMetterWhenFirsAdditionThanProperCounter() {
        //Given
        ElectricityMeter electricityMeter = new ElectricityMeter();
        //When
        electricityMeter.addKwh(1);
        //Than
        Assert.assertTrue(electricityMeter.getKwh() == 1);

    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.setCentsForKwh(90);
        electricityMeter.getHowMoreExpensiveNormalIs();
    }
}
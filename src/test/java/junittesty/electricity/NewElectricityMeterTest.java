package junittesty.electricity;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewElectricityMeterTest {

    static ElectricityMeter electricityMeter;
    static TariffProvider tp;

    @BeforeAll
    static void setUp(){
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
    }

    @Test
    public void givenTariffOnWhenAdditionThenKwhIncreased(){
        //Given
        Mockito.when(tp.isTariffNow()).thenReturn(true);

        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
        //When
        electricityMeter.addKwh(50);
        //Then
        assertEquals(50, electricityMeter.getKwhTariff());
    }

    @RepeatedTest(85)
    void givenMuchAdditionsWhenAdditionsThenNoTariffChange(RepetitionInfo repetitionInfo){
        //Given
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assertions.assertEquals(repetitionInfo.getCurrentRepetition() * 50, electricityMeter.getKwh());
    }
}

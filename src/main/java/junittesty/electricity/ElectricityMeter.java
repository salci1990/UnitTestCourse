package junittesty.electricity;

import java.util.Calendar;

public class ElectricityMeter {

    TariffProvider tp;

    private float kwh = 0;
    private int centsForKwh = 0;

    private boolean tariffOn = false;
    private float kwhTariff = 0;
    private int centsForKwhTariff = 0;

    private int elictricityTariffStartHour = 0;
    private int elictricityTariffEndHour = 0;

    public ElectricityMeter() {
        tp = new TariffProvider() {
            @Override
            public boolean isTariffNow() {
                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                return hour > elictricityTariffStartHour && hour < elictricityTariffEndHour;
            }
        };
    }

    public ElectricityMeter(TariffProvider tp) {
        this.tp = tp;
    }

    public void addKwh(float kwhToAdd){
        if(isTariffNow()){
            kwhTariff += kwhToAdd;
        }else{
            kwh += kwhToAdd;
        }
    }

    public boolean isTariffNow(){
        return tp.isTariffNow();
    }

    int getHowMoreExpensiveNormalIs(){
        return (centsForKwh * 100 /centsForKwhTariff) - 100;
    }

    public float getKwhTariff() {
        return kwhTariff;
    }

    public float getKwh() {
        return kwh;
    }

    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffOn(boolean tariffOn) {
        this.tariffOn = tariffOn;
    }

    void setCentsForKwhTariff(int centsForKwhTariff) {
        this.centsForKwhTariff = centsForKwhTariff;
    }

    void setElictricityTariffStartHour(int elictricityTariffStartHour) {
        this.elictricityTariffStartHour = elictricityTariffStartHour;
    }

    void setElictricityTariffEndHour(int elictricityTariffEndHour) {
        this.elictricityTariffEndHour = elictricityTariffEndHour;
    }
}

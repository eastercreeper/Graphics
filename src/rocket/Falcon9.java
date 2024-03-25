package rocket;

import javax.swing.plaf.ComponentUI;

public class Falcon9 extends Rocket {
    private double mass;
    private double thrust;
    private double fuelMass;
    private double time;

    public double getDt() {
        return dt;
    }

    private double dt;
    private double gravity;
    private double acceleration;
    private double fuelBurnrate;
    private double altitude;
    private double gravConstant = 6.67e-11;
    private double massEarth = 5.972e24;
    private double radiusEarth = 6.3781e6;
    private double Fg;
    private double Fnet;
    private double V;
    private double burnTime = 162;
    public double getBurnTime() {
        return burnTime;
    }
    public double getMass() {
        return mass;
    }
    public double getTime() {
        return time;
    }
    public void setDt(double dt) {
        this.dt = dt;
    }
    public double getAcceleration() {
        return acceleration;
    }
    public double getAltitude() {
        return altitude;
    }
    public Falcon9(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.mass = 2812273;
//        this.fuelBurnrate =2462.34567901;
        this.fuelBurnrate = 398900.0/burnTime;
        this.thrust = 6806000;
        this.time = 0;
        this.dt =0.5;
        this.gravity =  9.8;
        this.altitude = 0;
        this.acceleration = 0;
        this.fuelMass = 2000600;
        this.V = 0;
        this.Fnet = 0;


    }


    public double getV() {
        return V;
    }

    @Override
    public void moveRocket(int height, int width) {
        //this.Fg = gravConstant*massEarth*mass/altitude;
        //  fuelMass=fuelMass-fuelBurnrate;
        this.Fg = 9.8;
        mass = mass - (fuelBurnrate * dt);
        Fnet = thrust - Fg;
        acceleration = Fnet / mass;
        V = V + acceleration * dt;
        altitude = altitude + V * dt;
        time += dt;
    }


}

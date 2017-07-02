package net.darkhax.moreswords.materials;

public enum Speed {
    
    SLOW(1d),
    NORMAL(1.6d),
    FAST(2.6d);
    
    private final double speed;
    
    Speed (double speed) {
        
        this.speed = speed;
    }
    
    public double getSpeed () {
        
        return speed;
    }
}
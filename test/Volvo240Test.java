package test;

import org.junit.Before;
import org.junit.Test;
import src.Saab95;
import src.Volvo240;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertTrue;

public class Volvo240Test {

    Volvo240 testVolvo;

    @Before
    public void init() {
        testVolvo = new Volvo240();
    }
}


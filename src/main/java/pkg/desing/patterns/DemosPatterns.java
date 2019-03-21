package pkg.desing.patterns;

import pkg.desing.patterns.creational.DemoCreational;
import pkg.desing.patterns.creational.DemoCreationalPatterns;
import pkg.desing.patterns.structural.DemoStructuralPatterns;

public class DemosPatterns {

    public static void DemosRun() {
        DemoCreationalPatterns.DemoCreationals(DemoCreational.Prototype);        
        DemoStructuralPatterns.DemoStructural();
    }
}

package sprt;

import kr.ac.kaist.se.controller.sim.SimEngine;
import kr.ac.kaist.se.controller.verif.VerificationEngine;
import kr.ac.kaist.se.model.property.Property;
import kr.ac.kaist.se.model.property.PropertyChecker;
import kr.ac.kaist.se.simdata.output.record.SimLog;

public class SPRTVerificationEngine extends VerificationEngine {
    double alpha;
    double beta;
    double delta;
    int minimumSample;
    int maxRepeat;

    public SPRTVerificationEngine(SimEngine simEngine, Property property, PropertyChecker propertyChecker) {
        super(simEngine, property, propertyChecker);
        this.alpha = 0.05;
        this.beta = 0.05;
        this.delta = 0.01;
        this.minimumSample = 2;
        this.maxRepeat = 400;
    }

    public void verifySimulation() {
        boolean satisfaction = true;
        double satisfactionProb = 0.0;

        long programStartTime = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            double theta = i * 0.01;

            long thetaStartTime = System.nanoTime();
            boolean verificationResult = verifyTheta(theta);
            long thetaEndTime = System.nanoTime();
            System.out.println(i / (float) 100 + " theta verification running time: " + (thetaEndTime - thetaStartTime) / (float) 1000_000_000 + " sec");

            if (satisfaction && !verificationResult) {
                satisfactionProb = theta;
                satisfaction = false;
            }
        }

        System.out.println("Verification property satisfaction probability: " + satisfactionProb);
        long programEndTime = System.nanoTime();
        System.out.println("=== Total Program running time: " + (programEndTime - programStartTime) / (float)1000_000_000 + " sec");
    }

    public boolean verifyTheta(double theta) {
        boolean ret = true;
        int numSamples = 0;
        int numTrue = 0;

        if(theta == 1.00) ret = false;

        while(this.isSampleNeeded(numSamples, numTrue, theta)) {
            SimLog log = simEngine.executeSimulation();

            if(this.propertyChecker.check(log, this.property))
                numTrue += 1;

            numSamples += 1;
        }

        return ret;
    }

    private boolean isSampleNeeded(int numSample, int numTrue, double theta) {
        if(numSample < this.minimumSample)
            return true;

        double h0Threshold = this.beta / (1-this.alpha);
        double h1Threshold = (1-this.beta) / this.alpha;

        double v = this.getV(numSample, numTrue, theta);

        if (v <= h0Threshold)
            return false;
        else
            return !(v >= h1Threshold);
    }

    private double getV(int numSample, int numTrue, double theta) {
        double p0 = theta + this.delta;
        double p1 = theta - this.delta;

        int numFalse = numSample - numTrue;

        double p1m = Math.pow(p1, numTrue) * Math.pow((1-p1), numFalse);
        double p0m = Math.pow(p0, numTrue) * Math.pow((1-p0), numFalse);

        if(p0m == 0) {
            p1m = p1m + Double.MIN_VALUE;
            p0m = p0m + Double.MIN_VALUE;
        }

        return p1m / p0m;
    }
}

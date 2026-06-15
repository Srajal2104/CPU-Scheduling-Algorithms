package models;


public class ProcessResult {


    private String algorithm;

    private double waitingTime;

    private double turnaroundTime;



    public ProcessResult(
            String algorithm,
            double waitingTime,
            double turnaroundTime
    ){

        this.algorithm = algorithm;
        this.waitingTime = waitingTime;
        this.turnaroundTime = turnaroundTime;

    }



    public String getAlgorithm(){

        return algorithm;

    }



    public double getWaitingTime(){

        return waitingTime;

    }



    public double getTurnaroundTime(){

        return turnaroundTime;

    }


}
package models;


public class Process {


    private int pid;
    private int arrivalTime;
    private int burstTime;
    private int priority;


    private int remainingTime;


    private int completionTime;
    private int waitingTime;
    private int turnaroundTime;




    public Process(
            int pid,
            int arrivalTime,
            int burstTime,
            int priority
    ) {


        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;


        this.remainingTime = burstTime;

    }





    public int getPid() {

        return pid;

    }




    public int getArrivalTime() {

        return arrivalTime;

    }




    public int getBurstTime() {

        return burstTime;

    }




    public int getPriority() {

        return priority;

    }




    public int getRemainingTime() {

        return remainingTime;

    }




    public void setRemainingTime(int remainingTime) {

        this.remainingTime = remainingTime;

    }





    public int getCompletionTime() {

        return completionTime;

    }




    public int getWaitingTime() {

        return waitingTime;

    }




    public int getTurnaroundTime() {

        return turnaroundTime;

    }





    public void setCompletionTime(int completionTime) {

        this.completionTime = completionTime;

    }






    public void calculateTimes() {


        turnaroundTime =
                completionTime - arrivalTime;



        waitingTime =
                turnaroundTime - burstTime;


    }







    // Creates a copy of process for algorithms
    public Process copy() {


        return new Process(

                this.pid,
                this.arrivalTime,
                this.burstTime,
                this.priority

        );

    }






    @Override
    public String toString() {


        return "P" + pid;

    }



}
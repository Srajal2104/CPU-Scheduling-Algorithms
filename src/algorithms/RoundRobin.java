package algorithms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class RoundRobin implements Scheduler {


int quantum;



public RoundRobin(int q){

quantum=q;

}



@Override
public void schedule(ArrayList<Process> processes){



Queue<Process> queue =
new LinkedList<>();



ArrayList<String> chart =
new ArrayList<>();



for(Process p:processes){

queue.add(p);

}



int time=0;



while(!queue.isEmpty()){



Process p =
queue.poll();



chart.add(p.toString());



int run =
Math.min(
quantum,
p.getRemainingTime()
);



time+=run;



p.setRemainingTime(
p.getRemainingTime()-run
);



if(p.getRemainingTime()==0){


p.setCompletionTime(time);


p.calculateTimes();


}
else{


queue.add(p);


}



}



System.out.println(
"\n========== ROUND ROBIN =========="
);



GanttChart.display(chart);


Metrics.display(processes);



}


}
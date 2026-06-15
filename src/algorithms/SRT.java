package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class SRT implements Scheduler {



@Override
public void schedule(ArrayList<Process> processes){


ArrayList<String> chart =
new ArrayList<>();


int time=0;

int finished=0;



while(finished < processes.size()){


Process best=null;



for(Process p:processes){


if(p.getArrivalTime()<=time
&& p.getRemainingTime()>0){



if(best==null ||
p.getRemainingTime()
<
best.getRemainingTime()){


best=p;


}


}



}



if(best==null){

time++;

continue;

}



chart.add(best.toString());


best.setRemainingTime(
best.getRemainingTime()-1
);



time++;



if(best.getRemainingTime()==0){


best.setCompletionTime(time);


best.calculateTimes();


finished++;


}


}



System.out.println(
"\n========== SRT =========="
);



GanttChart.display(chart);


Metrics.display(processes);



}


}
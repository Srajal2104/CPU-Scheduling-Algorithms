package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class HRRN implements Scheduler {


@Override
public void schedule(ArrayList<Process> processes){


ArrayList<Process> done =
new ArrayList<>();


ArrayList<String> chart =
new ArrayList<>();


int time=0;



while(done.size()<processes.size()){


Process selected=null;

double best=-1;



for(Process p:processes){


if(!done.contains(p)
&& p.getArrivalTime()<=time){


double wait =
time-p.getArrivalTime();



double ratio =
(wait+p.getBurstTime())
/
(double)p.getBurstTime();



if(ratio>best){

best=ratio;

selected=p;

}


}


}



if(selected==null){

time++;

continue;

}



chart.add(selected.toString());


time+=selected.getBurstTime();


selected.setCompletionTime(time);


selected.calculateTimes();


done.add(selected);



}



System.out.println(
"\n========== HRRN =========="
);


GanttChart.display(chart);


Metrics.display(processes);


}


}
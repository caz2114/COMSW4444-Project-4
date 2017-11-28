package sail.g3;

import sail.sim.Point;
import sail.sim.Simulator;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class FrequencyBucket {
  HashMap<Point><int> contained_points;
  private int total_score = 0;
  private double x_0;
  private double x_1;
  private double y_0;
  private double y_1;

  public FrequencyBucket(double x_0, double x_1, double y_0, double y_1){
    this.x_0 = x_0;
    this.x_1 = x_1;
    this.y_0 = y_0;
    this.y_1 = y_1;
  }

  public void inBucket(Point target, int score){
    if(target.x >= this.x_0 && target.x < this.x_1 && target.y >= this.y_0 && target.y < this.y_1){
      this.contained_points.put(target, score);
    }
    updateScore();
  }

  public int updateScore(){
    for (int score : contained_points.values()){
      total_score += score;
    }
    return total_score;
  }
}

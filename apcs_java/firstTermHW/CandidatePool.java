/*========== CandidatePool.java ==========

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  pool
      An ArrayList of only Candidate objects

  You will need to write the following methods:
   
  getCandidatesForPosition(String pos)
  returns a candidate-only ArrayList containing all
      the Candidates in pool that have positions pos

  getBestCandidate(String pos)
      returns the Candidte in pool that matches position
      pos with the highest score
      If there are no candidates for the given position, 
      returns null

  removeCandidatesForPosition(String pos)
      Removes all the Candidates in the pool that match
      position pos.
      Returns the number of candidates removed

jdyrlandweaver
=========================*/
import java.io.*;
import java.util.*;

public class CandidatePool {
  
  //=================================
  //DO NOT MODIFY ANY OF THIS CODE
  ArrayList pool;
  
  public CandidatePool() {
    pool = new ArrayList();
  }
  
  public void addCandidate(Candidate c) {
    pool.add(c);
  }

  public String toString() {
    return pool.toString();
  }
  
  //=================================
  //START YOUR WORK HERE
  public ArrayList getCandidatesForPosition(String pos) {
    ArrayList al = new ArrayList();
    String currentPos;
    Object currentElement;

    for (int i = 0; i < pool.size(); i++) {
      currentElement = pool.get(i);
      currentPos = ((Candidate)currentElement).getPosition();
      if (currentPos == pos) {
        al.add(pool.get(i));
      }
    }
    return al;
  }
  
  public Candidate getBestCandidate(String pos) {
    ArrayList c = getCandidatesForPosition(pos);
    Object currentHighestObject = c.get(0);
    Object currentTermObject;
    double currentTermScore;

    for(int i = 1; i < c.size() - 1; i++) {
      currentTermObject = c.get(i);
      currentTermScore = ((Candidate)currentTermObject).getInterviewScore();
      if(currentTermScore > ((Candidate)currentHighestObject).getInterviewScore()) {
        currentHighestObject = (Candidate)currentTermObject;
      }
    }
    return (Candidate)currentHighestObject;
  }
  
  public int removeCandidatesForPosition(String pos){
    int numRemoved = 0;
    String currentPos;
    Object currentCandidate;

    for (int i = 0; i < pool.size(); i++) {
      currentCandidate = pool.get(i);
      currentPos = ((Candidate)currentCandidate).getPosition();
      if (currentPos == pos) {
        pool.remove(i);
        numRemoved++;
        i--;
      }
    }
    return numRemoved;
  }
}



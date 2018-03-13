package SortAndMin33;

import java.util.Comparator;

class Student {  
    private String name;  
    private double score;  
    public Student(String name,double score){  
        this.name = name;  
        this.score = score;  
    }  
    public double getScore(){  
        return this.score;  
    }  
    @Override  
    public String toString() {  
        return "����:"+this.name+",����:"+this.score;  
    }  
      
}  
class StudentComparator implements Comparator<Student> {  
    @Override  
    public int compare(Student o1,Student o2) {  
        if(o1.getScore() > o2.getScore()){  
            return 1;  
        }else if(o1.getScore() < o2.getScore()){  
            return -1;  
        }else{  
            return 0;  
        }  
    }  
}  
public class TestCode {  
  
    public static void main(String[] args) {  
          
        Student[] sts = new Student[]{  
                new Student("С��",60),  
                new Student("С��",90),  
                new Student("����",80),  
                new Student("С��",95)  
        };  
          
        java.util.Arrays.sort(sts, new StudentComparator());  
        System.out.println(java.util.Arrays.toString(sts));  
    }  
}  
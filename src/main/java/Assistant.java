import java.util.ArrayList;

public class Assistant {
    private String username="matinabedi";
    private String password="matinabedi94";
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public ArrayList<Course> creatCourse (String n ,ArrayList<Course> firstList){
        Course course = new Course();
        course.setCourseName(n);
        firstList.add(course);
        return firstList;
    }


    public void seeStudentsList(ArrayList<Student> studentsList){
        int i=1;
        for (Student student :studentsList){
            System.out.println(i+"- "+student.getName());
            i++;
        }
    }
    public void seeaTeachersList(ArrayList<Teacher> teachersList){
        int i=1;
        for (Teacher teacher :teachersList){
            System.out.println(i+"- "+teacher.getName());
            i++;
        }
    }
    public void seeaCoursesList(ArrayList<Course> coursesList){
        int i=1;
        for (Course course :coursesList){
            System.out.println(i+"- "+course.getCourseName()+" Teacher: "+course.getCourseTeacherName());
            i++;
        }
    }


    public void removeStudent(int number,ArrayList<Student> studentsList){
        studentsList.remove(number-1);
    }
    public void removeTeacher(int number,ArrayList<Teacher> teachersList){
        teachersList.remove(number-1);
    }
    public void removeCourse(int number,ArrayList<Course> coursesList){
        coursesList.remove(number-1);
    }

}


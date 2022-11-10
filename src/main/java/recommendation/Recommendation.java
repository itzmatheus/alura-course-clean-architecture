package recommendation;

import student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private Student nominated;
    private Student informed;
    private LocalDateTime dateNominated;

    public Recommendation(Student nominated, Student informed) {
        this.nominated = nominated;
        this.informed = informed;
        this.dateNominated = LocalDateTime.now();
    }

    public Student getNominated() {
        return nominated;
    }

    public Student getInformed() {
        return informed;
    }

    public LocalDateTime getDateNominated() {
        return dateNominated;
    }
}

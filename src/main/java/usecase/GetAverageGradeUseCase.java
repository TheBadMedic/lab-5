package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

/**
 * GetAverageGradeUseCase class.
 */
public final class GetAverageGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetAverageGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }

    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getAverageGrade(String course) {
        // Call the API to get usernames of all your team members
        float sum = 0;
        GetGradeUseCase grades = new GetGradeUseCase(gradeDataBase);
        // TODO Task 3b: Go to the MongoGradeDataBase class and implement getMyTeam.
        final Team team = gradeDataBase.getMyTeam();
        // Call the API to get all the grades for the course for all your team members

        int count = team.getMembers().length;

        if (count == 0) {
            return 0;
        }

        for (int i = 0; i < team.getMembers().length; i++){
            sum += grades.getGrade(team.getMembers()[i], course).getGrade();
        }


        return sum / count;
    }
}

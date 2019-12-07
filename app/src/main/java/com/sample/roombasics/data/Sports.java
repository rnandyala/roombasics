package com.sample.roombasics.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Student.class,
        parentColumns = "studentId",
        childColumns = "child_studentId"))
public class Sports {


    public int getSportsId() {
        return sportsId;
    }

    public void setSportsId(int sportsId) {
        this.sportsId = sportsId;
    }

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int sportsId;

@ColumnInfo(name= "child_studentId")
    private long childStudentId;


    private String favoriteSport;


    private String achievements;




    public String getFavoriteSport() {
        return favoriteSport;
    }

    public void setFavoriteSport(String favoriteSport) {
        this.favoriteSport = favoriteSport;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Sports(String favoriteSport, String achievements, long childStudentId) {
//        this(sportsId,favoriteSport,achievements);

        this.favoriteSport = favoriteSport;
        this.achievements = achievements;
        this.childStudentId = childStudentId;
//       this.sprotsId = sprotsId;
    }

    public long getChildStudentId() {
        return childStudentId;
    }

    public void setChildStudentId(long childStudentId) {
        this.childStudentId = childStudentId;
    }

//    public Sports(int sprotsId, String favoriteSport, int achievements) {
//        this.sprotsId = sprotsId;
//        this.favoriteSport = favoriteSport;
//        this.achievements = achievements;
//    }
}

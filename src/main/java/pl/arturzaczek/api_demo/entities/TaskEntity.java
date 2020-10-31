package pl.arturzaczek.api_demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String title;
    private LocalDateTime creationTime;
    private Date endDate;
    private TaskPriority taskPriority;
    private TaskCategory taskCategory;
    
    public TaskEntity(){
    }

    public TaskEntity(String content, String title, Date endDate) {
        this.content = content;
        this.title = title;
        this.creationTime = LocalDateTime.now();
        this.endDate = endDate;
        this.taskPriority = TaskPriority.DEFAULT;
        this.taskCategory = TaskCategory.HOME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(title, that.title) &&
                Objects.equals(creationTime, that.creationTime) &&
                Objects.equals(endDate, that.endDate);
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", insertDate=" + creationTime +
                ", finishDate=" + endDate +
                ", priority=" + taskPriority +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, title, creationTime, endDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

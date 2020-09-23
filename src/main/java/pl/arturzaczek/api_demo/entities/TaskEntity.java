package pl.arturzaczek.api_demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String title;
    private LocalDateTime insertDate;
    private LocalDateTime finishDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(title, that.title) &&
                Objects.equals(insertDate, that.insertDate) &&
                Objects.equals(finishDate, that.finishDate);
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", insertDate=" + insertDate +
                ", finishDate=" + finishDate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, title, insertDate, finishDate);
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

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
}
